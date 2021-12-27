package Desafio.Backend.dtos;


import Desafio.Backend.entities.Categorias;
import Desafio.Backend.entities.Idioma;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmesDtoPost {

    @NotEmpty
    private String titulo;
    @NotEmpty
    private String sinopse;

    @NotNull
    private Categorias categoria;

    @NotEmpty
    private String imagem;

    @NotEmpty
    private String datadeLancamento;

    @NotBlank
    private int duracao;

    @NotNull
    private Idioma idioma;

}
