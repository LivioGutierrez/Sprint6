package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILiquidacionRepository extends JpaRepository<Liquidacion, Long> {
}
