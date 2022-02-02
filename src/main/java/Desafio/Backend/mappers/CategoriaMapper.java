package Desafio.Backend.mappers;

import Desafio.Backend.dtos.CategoriaDtoPost;
import Desafio.Backend.dtos.CategoriaDtoPut;
import Desafio.Backend.entities.Categorias;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {Idiomamapper.class})
public abstract class CategoriaMapper {

    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);
    public abstract Categorias toCategoria(CategoriaDtoPost categoriaDtoPost);
    public abstract Categorias toCategoria(CategoriaDtoPut categoriaDtoPut);



}
