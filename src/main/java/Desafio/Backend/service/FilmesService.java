package Desafio.Backend.service;


import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.entities.Filmes;
import Desafio.Backend.entities.Idioma;
import Desafio.Backend.exception.BadRequestException;
import Desafio.Backend.mappers.FilmesMapper;
import Desafio.Backend.repository.FilmesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
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

        Filmes filmes = FilmesMapper.INSTANCE.toFilmes(filmesDtoPost);

        Idioma idiomaCategoria = idiomaService.findById(filmes.getCategoria().getIdioma().getId());
        Idioma idiomaFilme = idiomaService.findById(filmes.getIdioma().getId());
        Categorias categorias = categoriaService.findById(filmes.getCategoria().getId());

        if (!(categorias.getIdioma().getId() == idiomaCategoria.getId())){
            throw new BadRequestException("");
        }
        BeanUtils.copyProperties(idiomaFilme, filmes.getIdioma());
        BeanUtils.copyProperties(categorias, filmes.getIdioma());
        BeanUtils.copyProperties(idiomaCategoria, filmes.getCategoria().getIdioma());

        filmes.setActive(true);

        return filmesRepository.save(filmes);
    }

    public Filmes update(FilmesDtoPut filmesDtoPut){

        Filmes filmes = FilmesMapper.INSTANCE.toFilmes(filmesDtoPut);

        Categorias categorias = categoriaService.findById(filmes.getCategoria().getId());
        Idioma idiomaCategoria = idiomaService.findById(filmes.getCategoria().getIdioma().getId());
        Filmes filmeBanco = findById(filmes.getId());
        Idioma idiomaFilme = idiomaService.findById(filmesDtoPut.getIdioma().getId());

        if (!(categorias.getIdioma().getId() == idiomaCategoria.getId())){
            throw new BadRequestException("");
        }
        BeanUtils.copyProperties(idiomaFilme, filmesDtoPut.getIdioma());
        BeanUtils.copyProperties(categorias, filmesDtoPut.getCategoria());
        BeanUtils.copyProperties(idiomaCategoria, filmesDtoPut.getCategoria().getIdioma());
        BeanUtils.copyProperties(filmesDtoPut,filmeBanco, "createdAt");

        return filmesRepository.save(filmeBanco);
    }


}
