package Desafio.Backend.service;


import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.entities.Usuario;
import Desafio.Backend.exception.BadRequestException;
import Desafio.Backend.mappers.Usuariomapper;
import Desafio.Backend.repository.IdiomaRepository;
import Desafio.Backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class UsuarioService {
    private final IdiomaRepository idiomaRepository;
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listAllNoPageable() {

        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Usuario não encontrado"));
    }

    public Usuario save(UsuarioPost usuarioPost){

        Usuario newUsuario = Usuariomapper.INSTANCE.toUsuario(usuarioPost);


        Optional<Idioma> idioma = idiomaRepository.findById(newUsuario.getIdioma().getId());

        if (idioma.isEmpty()) {
            throw new BadRequestException("Idioma não encontado");
        }

        List<Usuario> emailNoFound = usuarioRepository.findByEmail(newUsuario.getEmail());

        if (!emailNoFound.isEmpty()){
            throw new BadRequestException("Email não disponível");
        }

        List<Usuario> cpfNotFound = usuarioRepository.findByCpf(newUsuario.getCpf());

        if (!cpfNotFound.isEmpty()){
            throw new BadRequestException("Cpf Invalido");
        }

        return usuarioRepository.save(newUsuario);
    }


    public Usuario update(UsuariodtoPut usuariodtoPut){

        return null;
    }


}