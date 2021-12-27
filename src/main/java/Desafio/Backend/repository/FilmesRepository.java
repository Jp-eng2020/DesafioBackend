package Desafio.Backend.repository;

import Desafio.Backend.entities.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
}
