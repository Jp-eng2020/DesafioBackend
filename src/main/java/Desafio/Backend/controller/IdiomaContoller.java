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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Idioma")
@RequiredArgsConstructor
@Log4j2
public class IdiomaContoller {

    private final IdiomaService idiomaService;

    @GetMapping
    public List<Idioma> listAllNoPageable(){
        return IdiomaService.listAllNoPageable();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Idioma> findById(@PathVariable long id){
        return new ResponseEntity(IdiomaService.findById(id), HttpStatus.OK);
    }
    public Idioma save(IdiomadtoPost idiomadtoPost){

        Idioma idioma = IdiomaRepository.save(Idiomamapper.INSTANCE.toLanguage(idiomadtoPost));

        return idioma;
    }




}
