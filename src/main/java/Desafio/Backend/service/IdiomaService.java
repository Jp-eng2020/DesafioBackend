package Desafio.Backend.service;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.mappers.Idiomamapper;
import Desafio.Backend.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdiomaService {
    private IdiomaRepository idiomaRepository;


    public static List<Idioma> listAllNoPageable(){
        return idiomaRepository.findAll();
    }

    public Idioma findById(Long id){
        return IdiomaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("O Idioma não pode ser econtrado"));
    }

}
