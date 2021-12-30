package Desafio.Backend.service;


import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.entities.Filmes;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.exception.badRequest.BadRequestException;
import Desafio.Backend.mappers.FilmesMapper;
import Desafio.Backend.repository.FilmesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class FilmesService {
    private final IdiomaService idiomaService;
    private final CategoriaService categoriaService;
    private final FilmesRepository filmesRepository;

    public Filmes findById(Long id){
        return filmesRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Filme não encontrado"));
    }

    public List<Filmes> listAllNoPageable(){

        return filmesRepository.findAll()
                .stream()
                .filter(Filmes::isActive)
                .collect(Collectors.toList());
    }

    public Filmes delete(long id){
        Filmes filmes = findById(id);

        filmes.setActive(false);

        return filmesRepository.save(filmes);
    }

    public Filmes save(FilmesDtoPost filmesDtoPost){

        Filmes filme = FilmesMapper.INSTANCE.toFilmes(filmesDtoPost);

        Idioma idiomaFilme = idiomaService.findById(filmesDtoPost.getIdiomaId());
        Categorias categoriaFilme = categoriaService.findById(filmesDtoPost.getCategoriaId());

        filme.setIdioma(idiomaFilme);
        filme.setCategoria(categoriaFilme);

        filme.setActive(true);

        return filmesRepository.save(filme);
    }

    public Filmes update(FilmesDtoPut filmesDtoPut){

        Filmes filmePut = FilmesMapper.INSTANCE.toFilmes(filmesDtoPut);

        filmePut.setCreatedAt(findById(filmePut.getId()).getCreatedAt());

        Idioma idiomaFilme = idiomaService.findById(filmesDtoPut.getIdiomaId());
        Categorias categoriaFilme = categoriaService.findById(filmesDtoPut.getCategoriaId());

        filmePut.setIdioma(idiomaFilme);
        filmePut.setCategoria(categoriaFilme);

        return filmesRepository.save(filmePut);
    }


}
