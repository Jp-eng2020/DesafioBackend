package Desafio.Backend.controller;

import Desafio.Backend.dtos.UserAutenticateDTO;
import Desafio.Backend.dtos.UserLoginDto;
import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.entities.Usuario;
import Desafio.Backend.service.UsuarioService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/usuario")
@RequiredArgsConstructor
@Log4j2
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
    })
    public List<Usuario> listAllNoPageable(){
        return usuarioService.listAllNoPageable();
    }

    @PostMapping(path = "/oauth")
    public ResponseEntity<UserLoginDto> autenticate(@RequestBody @Valid UserAutenticateDTO userAutenticateDTO){
        return new ResponseEntity<UserLoginDto>(usuarioService.autenticate(userAutenticateDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
    })
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        return new ResponseEntity(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucesso"),
            @ApiResponse(code = 404, message = "Idioma não encontrado"),
            @ApiResponse(code = 400, message = "Parametros Inválidos"),
    })
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioPost usuarioPost){
        Usuario usuario = usuarioService.save(usuarioPost);
       return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
    })
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        return new ResponseEntity(usuarioService.delete(id),HttpStatus.OK);
    }


    @PutMapping
    @PreAuthorize("hasRole('USER')")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
    })
    public ResponseEntity<Usuario> update(@RequestBody @Valid UsuariodtoPut usuariodtoPut,
                                        @AuthenticationPrincipal UserDetails userDetails){

        return new ResponseEntity(usuarioService.update(usuariodtoPut,userDetails),HttpStatus.OK);
    }

}
