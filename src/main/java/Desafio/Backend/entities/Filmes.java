package Desafio.Backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private String titulo;

    @NotEmpty
    private String sinopse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;

    @NotEmpty
    private String imagem;

    @NotEmpty
    private String datadeLancamento;


    private int duracao;


    @ManyToOne
    @JoinColumn(name = "Idioma_id")
    private Idioma idioma;

    @Column(nullable=false)
    private boolean active;
    @PrePersist
    public void prePersist(){
        this.active = true;
    }


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

}