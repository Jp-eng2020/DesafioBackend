package Desafio.Backend.dtos;

import Desafio.Backend.entities.Idioma;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDtoPut {

    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String tag;

    @NotNull
    private Idioma idioma;

}
