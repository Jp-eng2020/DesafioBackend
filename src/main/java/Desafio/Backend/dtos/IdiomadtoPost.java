package Desafio.Backend.dtos;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IdiomadtoPost{
    @javax.validation.constraints.NotEmpty
    private Long Id;
    @NotEmpty
    private String nome;

}
