package Desafio.Backend.repository;

import Desafio.Backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByEmail(String email);

    public List<Usuario> findByCpf(String cpf);
}
