package Desafio.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String tag;
    @JsonIgnore
    @OneToMany(mappedBy = "idioma")
    private List<Usuario> usuarioList;

    @JsonIgnore
    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL)
    private List<Categorias> categoriaList;

    @JsonIgnore
    @OneToMany(mappedBy = "idioma")
    private List<Filmes> filmesList;


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();


}