package Desafio.Backend.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @CPF
    private String cpf;

    @NotEmpty
    private String telefone;

    @NotEmpty
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "Idioma_id")
    private Idioma idioma;

    @NotEmpty
    private String senha;

    @NotEmpty
    private String perfil;

    @NotNull
    private String role;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    @Column(nullable=false)
    private boolean active;
    @PrePersist
    public void prePersist(){
        this.active = true;
    }


}