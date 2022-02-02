package Desafio.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne()
    @JoinColumn(name = "idioma_id", referencedColumnName = "id")
    private Idioma idioma;

    @NotEmpty
    private String tag;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Filmes> filmesLista;

    @Column(nullable=false)
    private boolean active;
    @PrePersist
    public void prePersist(){
        this.active = true;
    }


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

}