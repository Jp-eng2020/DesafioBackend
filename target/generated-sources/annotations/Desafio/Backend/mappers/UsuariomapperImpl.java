package Desafio.Backend.mappers;

import Desafio.Backend.dtos.UsuariodtoPost;
import Desafio.Backend.entities.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-16T09:35:35-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
public class UsuariomapperImpl extends Usuariomapper {

    @Override
    public Usuario toUsuario(UsuariodtoPost usuariodtoPost) {
        if ( usuariodtoPost == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( usuariodtoPost.getNome() );
        usuario.setCPF( usuariodtoPost.getCPF() );
        if ( usuariodtoPost.getTelefone() != null ) {
            usuario.setTelefone( Integer.parseInt( usuariodtoPost.getTelefone() ) );
        }
        usuario.setPerfil( usuariodtoPost.getPerfil() );
        usuario.setEmail( usuariodtoPost.getEmail() );
        usuario.setSenha( usuariodtoPost.getSenha() );

        return usuario;
    }
}
