package Desafio.Backend.dtos;

import Desafio.Backend.entities.Idioma;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuariodtoPut {
    @Id
    private long id;

    @NotEmpty(message = "o nome do Usuário deve ser preenchido ")
    private String nome;

    @CPF(message = "CPF deve ser preenchido com um CPF Válido ")
    private String cpf;

    @NotEmpty
    private String telefone;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty(message = "Senha não pode ser vazia")
    @Size(min = 8,max = 15)
    private String password;

    @NotEmpty
    private String perfil;

    @NotNull(message = "Roles não podem ser vazias")
    private String role;


    @Min(value = 0)
    private long idiomaId;

    @NotNull
    private Boolean active;


}
