package Desafio.Backend.controller;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.mappers.Idiomamapper;
import Desafio.Backend.repository.IdiomaRepository;
import Desafio.Backend.service.IdiomaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/idioma")
@RequiredArgsConstructor
@Log4j2
public class IdiomaContoller {
    private final IdiomaRepository idiomaRepository;
    private final IdiomaService idiomaService;

    @GetMapping
    public List<Idioma> listAllNoPageable(){
        return idiomaService.listAllNoPageable();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Idioma> findById(@PathVariable long id){
        return new ResponseEntity(idiomaService.findById(id), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Idioma> save(@RequestBody @Valid IdiomadtoPost idiomadtoPost){

        Idioma idioma = idiomaRepository.save(Idiomamapper.INSTANCE.toLanguage(idiomadtoPost));

        return new ResponseEntity(idioma, HttpStatus.CREATED);
    }




}
