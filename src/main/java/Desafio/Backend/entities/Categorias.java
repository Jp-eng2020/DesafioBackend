package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorias{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idioma_id")
    @NotEmpty
    private Idioma idioma;

    @NotEmpty
    private String tag;

    @OneToMany(mappedBy = "categorias")
    private List<Filmes> filmesLista;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

}
