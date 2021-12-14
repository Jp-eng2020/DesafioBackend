package Desafio.Backend.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Idioma {

    @OneToMany
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToMany
    private String nome;
}
