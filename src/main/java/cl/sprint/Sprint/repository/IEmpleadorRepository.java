package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {
}
