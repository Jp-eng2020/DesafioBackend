package Desafio.Backend.mappers;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public abstract class Idiomamapper {

    public static final Idiomamapper INSTANCE = Mappers.getMapper(Idiomamapper.class);
    public abstract Idioma toLanguage(IdiomadtoPost idiomadtoPost);



}
