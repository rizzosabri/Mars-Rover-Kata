package sabrina.rover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabrina.rover.models.Tablero;
@Repository
public interface TableroRepository  extends JpaRepository<Tablero, Long> {
}
