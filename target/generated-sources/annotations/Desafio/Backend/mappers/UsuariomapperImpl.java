package Desafio.Backend.mappers;

import Desafio.Backend.dtos.UsuariodtoPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-19T13:17:55-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class UsuariomapperImpl extends Usuariomapper {

    @Override
    public Usuario toUsuario(UsuariodtoPost usuariodtoPost) {
        if ( usuariodtoPost == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( usuariodtoPost.getNome() );
        usuario.setTelefone( usuariodtoPost.getTelefone() );
        usuario.setEmail( usuariodtoPost.getEmail() );
        usuario.setSenha( usuariodtoPost.getSenha() );
        usuario.setPerfil( usuariodtoPost.getPerfil() );

        return usuario;
    }

    @Override
    public Usuario toUsuario(UsuariodtoPut usuariodtoPut) {
        if ( usuariodtoPut == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuariodtoPut.getId() );
        usuario.setNome( usuariodtoPut.getNome() );
        usuario.setTelefone( usuariodtoPut.getTelefone() );
        usuario.setEmail( usuariodtoPut.getEmail() );
        usuario.setSenha( usuariodtoPut.getSenha() );
        usuario.setPerfil( usuariodtoPut.getPerfil() );

        return usuario;
    }
}
