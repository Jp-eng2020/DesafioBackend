package Desafio.Backend.controller;


import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.entities.Filmes;
import Desafio.Backend.service.FilmesService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@ApiResponses(value = {
        @ApiResponse(code = 401, message = "credenciais inválidas"),
        @ApiResponse(code = 403, message = "Não Autorizado"),
        @ApiResponse(code = 400, message = "Parametros Inválidos"),
})
@RequiredArgsConstructor
public class FilmesController {
    private final FilmesService filmesService;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "susseso")
    })
    public List<Filmes> listAllNoPageable(){
        return filmesService.listAllNoPageable();
    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Idioma ou Categoria não encontrado")
    })
    public ResponseEntity<Filmes> update(@RequestBody @Valid FilmesDtoPut filmesDtoPut){
        return new ResponseEntity(filmesService.update(filmesDtoPut), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Filme não encontrado"),
    })
    public ResponseEntity<Filmes> findById(@PathVariable long id){
        return new ResponseEntity(filmesService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "sucesso"),
            @ApiResponse(code = 401, message = "Erro"),
    })
    public ResponseEntity<Filmes> save(@RequestBody @Valid FilmesDtoPost filmesDtoPost){
        Filmes filmes = filmesService.save(filmesDtoPost);
        return new ResponseEntity(filmes, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Filme nao encontrado"),
    })
    public ResponseEntity<Categorias> delete(@PathVariable long id){
        return new ResponseEntity(filmesService.delete(id),HttpStatus.OK);
    }

}
