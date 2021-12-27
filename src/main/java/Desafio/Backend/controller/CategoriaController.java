package Desafio.Backend.controller;

import Desafio.Backend.dtos.CategoriaDtoPost;
import Desafio.Backend.dtos.CategoriaDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/categoria")

public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categorias> listAllNoPageable(){
        return categoriaService.listAllNoPageable();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Categorias> findById(@PathVariable long id){
        return new ResponseEntity(categoriaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorias> save(@RequestBody CategoriaDtoPost categoriaDtoPost){
        Categorias categoria = categoriaService.save(categoriaDtoPost);
        return new ResponseEntity(categoria, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Categorias> delete(@PathVariable long id){
        return new ResponseEntity(categoriaService.delete(id),HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Categorias> update(@RequestBody @Valid CategoriaDtoPut categoriaDtoPut){
        return new ResponseEntity(categoriaService.update(categoriaDtoPut),HttpStatus.OK);
    }

}
