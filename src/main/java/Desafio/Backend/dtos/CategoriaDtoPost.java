package Desafio.Backend.dtos;

import Desafio.Backend.entities.Idioma;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDtoPost {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String tag;

    @Min(value = 0)
    private Long idiomaId;



}
