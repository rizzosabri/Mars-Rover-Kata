package sabrina.rover.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity

@Table(name="Obstaculo")
public class Obstaculo extends ElementosDelMapa {


    public Obstaculo(int x, int y) {
        super(x, y);
    }
}
