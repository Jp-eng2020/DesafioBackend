package Desafio.Backend.service;


import Desafio.Backend.dtos.UsuariodtoPost;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.entities.Usuario;
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

    public List<Usuario> listAllNoPageable(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return UsuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("O Usuário não pode ser encontrado"));
    }

    public Usuario save(UsuariodtoPost usuariodtoPost){

        Usuario NovoUsuario = Usuariomapper.INSTANCE.toUsers(usuariodtoPost);

        Optional<Idioma> idioma = IdiomaRepository.findById(NovoUsuario.getLanguage().getId());

        if (idioma.isEmpty()) {
            throw new BadRequestException("O Idioma não pode ser encontrado");
        }

}
