package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaludRepository extends JpaRepository<InstitucionSalud, Integer> {
}
