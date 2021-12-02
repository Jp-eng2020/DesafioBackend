package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorias {
    @NotEmpty
    @ManyToOne
    private Idioma idioma;
    @NotEmpty
    private String nome;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag;

}
