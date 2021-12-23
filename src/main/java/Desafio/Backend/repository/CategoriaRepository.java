package Desafio.Backend.repository;

import Desafio.Backend.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categorias, Long> {
}
