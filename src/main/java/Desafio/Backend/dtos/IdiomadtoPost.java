package Desafio.Backend.dtos;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IdiomadtoPost {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String nome;

}
