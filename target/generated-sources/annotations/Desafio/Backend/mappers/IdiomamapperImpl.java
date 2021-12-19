package Desafio.Backend.mappers;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-19T15:29:24-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
@Component
public class IdiomamapperImpl extends Idiomamapper {

    @Override
    public Idioma toLanguage(IdiomadtoPost idiomadtoPost) {
        if ( idiomadtoPost == null ) {
            return null;
        }

        Idioma idioma = new Idioma();

        if ( idiomadtoPost.getId() != null ) {
            idioma.setId( idiomadtoPost.getId() );
        }
        idioma.setNome( idiomadtoPost.getNome() );

        return idioma;
    }
}
