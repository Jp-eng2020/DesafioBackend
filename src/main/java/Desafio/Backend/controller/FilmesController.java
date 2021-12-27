package Desafio.Backend.controller;


import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Filmes;
import Desafio.Backend.service.FilmesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmesController {
    private final FilmesService filmesService;

    @GetMapping
    public List<Filmes> listAllNoPageable(){
        return filmesService.listAllNoPageable();
    }
    @PutMapping
    public ResponseEntity<Filmes> update(@RequestBody @Valid FilmesDtoPut filmesDtoPut){
        return new ResponseEntity(filmesService.update(filmesDtoPut), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Filmes> save(@RequestBody @Valid FilmesDtoPost filmesDtoPost){
        Filmes filmes = filmesService.save(filmesDtoPost);
        return new ResponseEntity(filmes, HttpStatus.CREATED);
    }

}
