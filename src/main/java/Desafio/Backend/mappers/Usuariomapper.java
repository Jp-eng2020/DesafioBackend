package Desafio.Backend.mappers;


import Desafio.Backend.dtos.UsuariodtoPost;
import Desafio.Backend.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spting")
public abstract class Usuariomapper {
    public static final Usuariomapper INSTACE = Mappers.getMapper(Usuariomapper.class);
    public abstract Usuario toUsuario(UsuariodtoPost usuariodtoPost);
}
