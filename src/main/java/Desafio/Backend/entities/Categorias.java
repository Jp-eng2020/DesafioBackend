package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorias{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idioma_id")
    @NotEmpty
    private Idioma idioma;

    @NotEmpty
    private String tag;

    @OneToMany(mappedBy = "categoria")
    private List<Filmes> filmesLista;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

}