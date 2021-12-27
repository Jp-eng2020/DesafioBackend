package Desafio.Backend.mappers;

import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Filmes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FilmesMapper {
    public static final FilmesMapper INSTANCE = Mappers.getMapper(FilmesMapper.class);

    public abstract Filmes toFilmes(FilmesDtoPost filmesDtoPost);

    public abstract Filmes toFilmes(FilmesDtoPut filmesDtoPut);

}
