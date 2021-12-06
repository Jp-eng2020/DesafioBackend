package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filmes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String Titulo;
    @NotEmpty
    private String Sinopse;
    @ManyToOne
    @NotNull
    private Idioma idioma;
    @NotEmpty
    private String DataLancamento;
    @NotEmpty
    private Long Duracao;
    @ManyToOne
    @NotNull
    private Categorias categoria;


}
