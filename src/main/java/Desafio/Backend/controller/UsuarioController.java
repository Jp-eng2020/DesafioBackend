package Desafio.Backend.controller;

import Desafio.Backend.dtos.UsuariodtoPost;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.entities.Usuario;
import Desafio.Backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Usuarios")
@RequiredArgsConstructor
@Log4j2
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping
    public List<Usuario> listAllNoPageable(){
        return usuarioService.listAllNoPageable();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Idioma> findById(@PathVariable long id){
        return new ResponseEntity(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuariodtoPost usuariodtoPost){
        Usuario usuario = usuarioService.save(usuariodtoPost);
        log.info(usuario);
        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }


}
