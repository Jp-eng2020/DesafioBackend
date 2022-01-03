package Desafio.Backend.controller;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.mappers.Idiomamapper;
import Desafio.Backend.repository.IdiomaRepository;
import Desafio.Backend.service.IdiomaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/idioma")
@RequiredArgsConstructor
@Log4j2
public class IdiomaController {
    private final IdiomaRepository idiomaRepository;
    private final IdiomaService idiomaService;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
    })
    public List<Idioma> listAllNoPageable(){
        return idiomaService.listAllNoPageable();
    }

    @GetMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 404, message = "Idioma não encontrado"),
    })
    public ResponseEntity<Idioma> findById(@PathVariable long id){
        return new ResponseEntity(idiomaService.findById(id), HttpStatus.OK);
    }



    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sucesso"),
            @ApiResponse(code = 403, message = "Não Autorizado"),
            @ApiResponse(code = 401, message = "Erro"),
            @ApiResponse(code = 400, message = "Parametros Invalidos"),
    })
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Idioma> save(@RequestBody IdiomadtoPost idiomadtoPost){

        Idioma idioma = idiomaRepository.save(Idiomamapper.INSTANCE.toLanguage(idiomadtoPost));

        return new ResponseEntity(idioma, HttpStatus.CREATED);
    }




}
