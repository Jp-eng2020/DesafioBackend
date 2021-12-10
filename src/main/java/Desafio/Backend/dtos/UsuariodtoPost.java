package Desafio.Backend.dtos;

import Desafio.Backend.entities.Idioma;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuariodtoPost {
    @NotEmpty(message = "o nome do Usuário deve ser preenchido ")
    private String nome;

    @CPF(message = "CPF deve ser preenchido com um CPF Válido ")
    private String CPF;

    @NotEmpty
    private String telefone;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8,max = 15)
    private String senha;

    @NonNull
    private String perfil;

    @NotNull(message = "Roles cannot be null")
    private String roles;

    @Valid
    private Idioma language;


}
