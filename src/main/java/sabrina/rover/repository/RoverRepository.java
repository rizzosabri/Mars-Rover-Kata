package sabrina.rover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabrina.rover.models.Rover;


@Repository
public interface RoverRepository  extends JpaRepository<Rover, Long> {
}