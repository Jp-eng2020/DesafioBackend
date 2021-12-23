package Desafio.Backend.mappers;

import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-22T10:44:56-0300",
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
        usuario.setIdioma( usuarioPost.getIdioma() );
        usuario.setSenha( usuarioPost.getSenha() );
        usuario.setPerfil( usuarioPost.getPerfil() );

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
        usuario.setIdioma( usuariodtoPut.getIdioma() );
        usuario.setSenha( usuariodtoPut.getSenha() );
        usuario.setPerfil( usuariodtoPut.getPerfil() );

        return usuario;
    }
}
