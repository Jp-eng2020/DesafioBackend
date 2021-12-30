package Desafio.Backend.dtos;

import Desafio.Backend.entities.Categorias;
import Desafio.Backend.entities.Idioma;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmesDtoPut {

    private Long id;
    @NotEmpty
    private String titulo;

    @NotEmpty
    private String sinopse;

    @Min(value = 1)
    private long categoriaId;

    @NotEmpty
    private String imagem;

    @NotEmpty
    private String datadeLancamento;


    private int duracao;

    @Min(value = 1)
    private long idiomaId;

    @NotNull
    private Boolean active;
}
