package Desafio.Backend.service;


import Desafio.Backend.dtos.UserAutenticateDTO;
import Desafio.Backend.dtos.UserLoginDto;
import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.entities.Usuario;
import Desafio.Backend.exception.badRequest.BadRequestException;
import Desafio.Backend.exception.forbbiden.ForbiddenException;
import Desafio.Backend.mappers.Usuariomapper;
import Desafio.Backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class UsuarioService implements UserDetailsService {
    private final IdiomaService idiomaService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public List<Usuario> listAllNoPageable() {

        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Usuario não encontrado"));
    }

    public Usuario save(UsuarioPost usuarioPost){

        Usuario newUsuario = Usuariomapper.INSTANCE.toUsuario(usuarioPost);

        Idioma idioma = idiomaService.findById(usuarioPost.getIdiomaId());

        List<Usuario> emailNaoEncontrado = usuarioRepository.findByEmail(newUsuario.getEmail());
        if (!emailNaoEncontrado.isEmpty())throw new BadRequestException("Email já registrado no sistema");

        List<Usuario> cpfNaoEncontrado = usuarioRepository.findByCpf(newUsuario.getCpf());
        if (!cpfNaoEncontrado.isEmpty())throw new BadRequestException("Cpf Já registrado");

        newUsuario.setIdioma(idioma);
        newUsuario.setActive(true);
        newUsuario.setPassword(encoder.encode(newUsuario.getPassword()));

        return usuarioRepository.save(newUsuario);
    }


    public Usuario update(UsuariodtoPut usuariodtoPut, UserDetails userDetails){
        Usuario userP = Usuariomapper.INSTANCE.toUsuario(usuariodtoPut);

        userP.setCreatedAt(findById(userP.getId()).getCreatedAt());

        Boolean isAdmin = userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));

        if (!isAdmin && !userDetails.getUsername().equals(findById(userP.getId()).getEmail())) {
            throw new ForbiddenException("Acesso negado!");
        }

        List<Usuario> cpfNotFound = usuarioRepository.findByCpf(userP.getCpf());

        if (cpfNotFound.size() == 1 && !userP.getCpf().equals(findById(userP.getId()).getCpf())){
            throw new BadRequestException("Cpf indisponivel");
        }


        List<Usuario> emailNaoEncontrado = usuarioRepository.findByEmail(userP.getEmail());

        if (emailNaoEncontrado.size() == 1 && !userP.getEmail().equals(findById(userP.getId()).getEmail())){
            throw new BadRequestException("Email indisponivel");
        }

        userP.setPassword(encoder.encode(userP.getPassword()));

        Idioma idioma = idiomaService.findById(usuariodtoPut.getIdiomaId());

        userP.setIdioma(idioma);

        return usuarioRepository.save(userP);
    }

    public Usuario delete(Long id){
        Usuario usuario = findById(id);
        usuario.setActive(false);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        return Optional.ofNullable(usuarioRepository.findByEmail(email).get(0))
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));
    }

    public UserLoginDto autenticate(UserAutenticateDTO userAutenticateDTO) {
        List<Usuario> byEmail = usuarioRepository.findByEmail(userAutenticateDTO.getEmail());
        if (byEmail.isEmpty()){
            throw new BadRequestException("ERROR EMAIL Invalido");
        }
        if (!encoder.matches(userAutenticateDTO.getPassword(),byEmail.get(0).getPassword())){
            throw new BadRequestException("Senha invalida");
        }
      String token = Base64.getEncoder()
                .encodeToString((byEmail.get(0).getEmail() + ":" + userAutenticateDTO.getPassword())
                        .getBytes());
        log.info("{\"id\": \"" + byEmail.get(0).getId() + "\",\"token\": \"" + token + "\"}");
        UserLoginDto userLoginDto = new UserLoginDto(byEmail.get(0).getId(), byEmail.get(0).getRole(), token);
        return userLoginDto;

    }
}