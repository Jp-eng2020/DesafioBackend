package Desafio.Backend.controller;

import Desafio.Backend.dtos.CategoriaDtoPost;
import Desafio.Backend.dtos.CategoriaDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.service.CategoriaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Parametros Inválidos "),
        @ApiResponse(code = 401, message = "Credenciais inválidas"),
        @ApiResponse(code = 403, message = "Usuário não autorizado")
})
@RequiredArgsConstructor
@RequestMapping(path = "/categoria")

public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "susseso")
    })
    public List<Categorias> listAllNoPageable(){
        return categoriaService.listAllNoPageable();
    }


    @GetMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Elemento não encontrado")
    })
    public ResponseEntity<Categorias> findById(@PathVariable long id){
        return new ResponseEntity(categoriaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Categoria Salva com sucesso"),
            @ApiResponse(code = 404, message = "Idioma não encontrado"),
    })
    public ResponseEntity<Categorias> save(@RequestBody CategoriaDtoPost categoriaDtoPost){
        Categorias categoria = categoriaService.save(categoriaDtoPost);
        return new ResponseEntity(categoria, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 200, message = "Categoria não encontrada")
    })
    public ResponseEntity<Categorias> delete(@PathVariable long id){
        return new ResponseEntity(categoriaService.delete(id),HttpStatus.OK);
    }


    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Idioma não encontrado"),
            @ApiResponse(code = 401, message = "Erro"),
    })
    public ResponseEntity<Categorias> update(@RequestBody @Valid CategoriaDtoPut categoriaDtoPut){
        return new ResponseEntity(categoriaService.update(categoriaDtoPut),HttpStatus.OK);
    }

}
