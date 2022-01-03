package Desafio.Backend.mappers;

import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-03T15:27:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
@Component
public class UsuariomapperImpl extends Usuariomapper {

    @Override
    public Usuario toUsuario(UsuarioPost usuarioPost) {
        if ( usuarioPost == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( usuarioPost.getNome() );
        usuario.setCpf( usuarioPost.getCpf() );
        usuario.setTelefone( usuarioPost.getTelefone() );
        usuario.setEmail( usuarioPost.getEmail() );
        usuario.setPassword( usuarioPost.getPassword() );
        usuario.setPerfil( usuarioPost.getPerfil() );
        usuario.setRole( usuarioPost.getRole() );

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
        usuario.setCpf( usuariodtoPut.getCpf() );
        usuario.setTelefone( usuariodtoPut.getTelefone() );
        usuario.setEmail( usuariodtoPut.getEmail() );
        usuario.setPassword( usuariodtoPut.getPassword() );
        usuario.setPerfil( usuariodtoPut.getPerfil() );
        usuario.setRole( usuariodtoPut.getRole() );
        if ( usuariodtoPut.getActive() != null ) {
            usuario.setActive( usuariodtoPut.getActive() );
        }

        return usuario;
    }
}
