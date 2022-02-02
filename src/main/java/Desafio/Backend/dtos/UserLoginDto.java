package Desafio.Backend.dtos;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private long id;

    private String role;

    private String token;

}
