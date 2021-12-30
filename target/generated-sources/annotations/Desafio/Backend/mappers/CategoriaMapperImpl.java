package Desafio.Backend.mappers;

import Desafio.Backend.dtos.CategoriaDtoPost;
import Desafio.Backend.dtos.CategoriaDtoPut;
import Desafio.Backend.entities.Categorias;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-30T08:45:04-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
@Component
public class CategoriaMapperImpl extends CategoriaMapper {

    @Override
    public Categorias toCategoria(CategoriaDtoPost categoriaDtoPost) {
        if ( categoriaDtoPost == null ) {
            return null;
        }

        Categorias categorias = new Categorias();

        categorias.setNome( categoriaDtoPost.getNome() );
        categorias.setTag( categoriaDtoPost.getTag() );

        return categorias;
    }

    @Override
    public Categorias toCategoria(CategoriaDtoPut categoriaDtoPut) {
        if ( categoriaDtoPut == null ) {
            return null;
        }

        Categorias categorias = new Categorias();

        categorias.setId( categoriaDtoPut.getId() );
        categorias.setNome( categoriaDtoPut.getNome() );
        categorias.setTag( categoriaDtoPut.getTag() );
        if ( categoriaDtoPut.getActive() != null ) {
            categorias.setActive( categoriaDtoPut.getActive() );
        }

        return categorias;
    }
}
