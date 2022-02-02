package Desafio.Backend.mappers;

import Desafio.Backend.dtos.IdiomadtoPost;
import Desafio.Backend.entities.Idioma;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-01T15:15:23-0300",
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

        idioma.setNome( idiomadtoPost.getNome() );
        idioma.setTag( idiomadtoPost.getTag() );

        return idioma;
    }
}
