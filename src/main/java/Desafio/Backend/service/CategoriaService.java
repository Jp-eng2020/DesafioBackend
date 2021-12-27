package Desafio.Backend.service;

import Desafio.Backend.dtos.CategoriaDtoPost;
import Desafio.Backend.dtos.CategoriaDtoPut;
import Desafio.Backend.entities.Categorias;
import Desafio.Backend.exception.BadRequestException;
import Desafio.Backend.mappers.CategoriaMapper;
import Desafio.Backend.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private  final IdiomaService idiomaService;

    public List<Categorias> listAllNoPageable(){

        return categoriaRepository.findAll();

    }

    public Categorias findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new BadRequestException(" A Categoria não existe"));
    }

    public Categorias save(CategoriaDtoPost categoriaDtoPost){

        Categorias categorias = CategoriaMapper.INSTANCE.toCategoria(categoriaDtoPost);
        idiomaService.findById(categorias.getIdioma().getId());
        return categoriaRepository.save(categorias);
    }



    public Categorias delete(long id){
        Categorias categorias = findById(id);

        categorias.setActive(false);

        categoriaRepository.save(categorias);

        return categorias;
    }


    public Categorias update(CategoriaDtoPut categoriaDtoPut){

        Categorias categoriaPut = CategoriaMapper.INSTANCE.toCategoria(categoriaDtoPut);

        Categorias categoriaBanco = findById(categoriaPut.getId());

        idiomaService.findById(categoriaPut.getIdioma().getId());

        BeanUtils.copyProperties(categoriaPut,categoriaBanco, "criado em");

        return categoriaRepository.save(categoriaBanco);
    }

}
