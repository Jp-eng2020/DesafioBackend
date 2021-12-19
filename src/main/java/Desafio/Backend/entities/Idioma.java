package Desafio.Backend.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String tag;

    @OneToMany(mappedBy = "Idioma")
    private List<Usuario> usuarioList;

    @OneToMany(mappedBy = "Idioma")
    private List<Categorias> categoriaList;

    @OneToMany(mappedBy = "Idioma")
    private List<Filmes> filmesList;


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();


}
