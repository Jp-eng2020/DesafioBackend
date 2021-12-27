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
    private String nome;
    @NotEmpty
    private String tag;

}
