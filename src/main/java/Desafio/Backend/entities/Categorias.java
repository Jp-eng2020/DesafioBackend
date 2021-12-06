package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorias{
    @NotEmpty
    @ManyToOne
    private Idioma idioma;
    @NotEmpty
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag;

}
