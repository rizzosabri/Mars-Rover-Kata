package sabrina.rover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabrina.rover.models.Obstaculo;

@Repository
public interface ObstaculoRepository  extends JpaRepository<Obstaculo, Long> {
}
