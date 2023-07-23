package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer> {
}
