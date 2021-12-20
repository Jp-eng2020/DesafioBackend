package Desafio.Backend.mappers;


import Desafio.Backend.dtos.UsuarioPost;
import Desafio.Backend.dtos.UsuariodtoPut;
import Desafio.Backend.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public abstract class Usuariomapper {
    public static final Usuariomapper INSTANCE = Mappers.getMapper(Usuariomapper.class);
    public abstract Usuario toUsuario(UsuarioPost usuarioPost);
    public abstract Usuario toUsuario(UsuariodtoPut usuariodtoPut);
}
