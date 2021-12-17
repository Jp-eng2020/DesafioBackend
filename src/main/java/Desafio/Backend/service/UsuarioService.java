package Desafio.Backend.service;


import Desafio.Backend.dtos.UsuariodtoPost;
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

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("O Usuário não pode ser encontrado"));
    }

    public Usuario save(UsuariodtoPost usuariodtoPost) {

        Usuario novoUsuario = Usuariomapper.INSTACE.toUsuario(usuariodtoPost);

        Optional<Idioma> idioma = idiomaRepository.findById(novoUsuario.getIdioma().getId());

        if (idioma.isEmpty()) {
            throw new BadRequestException("O Idioma não pode ser encontrado");
        }

        List<Usuario> emailNotFound = usuarioRepository.findByEmail(novoUsuario.getEmail());

        if (!emailNotFound.isEmpty()){
            throw new BadRequestException(" ");
        }

        List<Usuario> cpfNotFound = usuarioRepository.findByCpf(novoUsuario.getCPF());

        if (!cpfNotFound.isEmpty()){
            throw new BadRequestException(" ");
        }

        return usuarioRepository.save(novoUsuario);

    }


    public Usuario update(UsuariodtoPut usuariodtoPut){

        return null;
    }


}