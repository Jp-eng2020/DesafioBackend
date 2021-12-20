package Desafio.Backend.dtos;

import Desafio.Backend.entities.Idioma;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioPost {
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
    private String senha;

    @NotEmpty
    private String perfil;

    @NotNull(message = "Roles não podem ser vazias")
    private String roles;

    @Valid
    private Idioma idioma;


}
