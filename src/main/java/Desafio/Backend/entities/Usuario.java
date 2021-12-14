package Desafio.Backend.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag;
    @NotEmpty
    private String nome;
    @CPF
    @NotEmpty
    private String CPF;
    @NotEmpty
    private int telefone;
    @NotEmpty
    private String perfil;
    @NotEmpty
    private String email;
    @NotEmpty
    private String senha;
    @OneToMany
    //add @join apos a normalização do banco
    @NotNull
    private Idioma idioma;
    @NotEmpty
    private String role;




}
