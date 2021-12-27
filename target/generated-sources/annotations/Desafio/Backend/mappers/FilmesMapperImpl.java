package Desafio.Backend.mappers;

import Desafio.Backend.dtos.FilmesDtoPost;
import Desafio.Backend.dtos.FilmesDtoPut;
import Desafio.Backend.entities.Filmes;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-27T09:28:54-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
@Component
public class FilmesMapperImpl extends FilmesMapper {

    @Override
    public Filmes toFilmes(FilmesDtoPost filmesDtoPost) {
        if ( filmesDtoPost == null ) {
            return null;
        }

        Filmes filmes = new Filmes();

        filmes.setTitulo( filmesDtoPost.getTitulo() );
        filmes.setSinopse( filmesDtoPost.getSinopse() );
        filmes.setCategoria( filmesDtoPost.getCategoria() );
        filmes.setImagem( filmesDtoPost.getImagem() );
        filmes.setDatadeLancamento( filmesDtoPost.getDatadeLancamento() );
        filmes.setDuracao( filmesDtoPost.getDuracao() );
        filmes.setIdioma( filmesDtoPost.getIdioma() );

        return filmes;
    }

    @Override
    public Filmes toFilmes(FilmesDtoPut filmesDtoPut) {
        if ( filmesDtoPut == null ) {
            return null;
        }

        Filmes filmes = new Filmes();

        filmes.setId( filmesDtoPut.getId() );
        filmes.setTitulo( filmesDtoPut.getTitulo() );
        filmes.setSinopse( filmesDtoPut.getSinopse() );
        filmes.setCategoria( filmesDtoPut.getCategoria() );
        filmes.setImagem( filmesDtoPut.getImagem() );
        filmes.setDatadeLancamento( filmesDtoPut.getDatadeLancamento() );
        filmes.setDuracao( filmesDtoPut.getDuracao() );
        filmes.setIdioma( filmesDtoPut.getIdioma() );
        if ( filmesDtoPut.getActive() != null ) {
            filmes.setActive( filmesDtoPut.getActive() );
        }

        return filmes;
    }
}
