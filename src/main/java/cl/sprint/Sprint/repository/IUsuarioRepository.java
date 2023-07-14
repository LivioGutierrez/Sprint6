package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
