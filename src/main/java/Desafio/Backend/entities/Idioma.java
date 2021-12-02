package Desafio.Backend.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Idioma {
    @OneToMany
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag;
    @OneToMany
    private String nome;
}
