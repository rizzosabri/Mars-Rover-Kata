package sabrina.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass //, indica que una clase es una superclase común que proporciona
// propiedades de mapeo a las clases derivadas, pero no se mapea a una tabla por sí misma.


public class ElementosDelMapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name="id")
    protected Long id;
    @Column(name="Posicion en X")
    protected int x; // Posición en el eje X
    @Column(name="Posicion en Y")
    protected int y; // Posición en el eje Y
    public ElementosDelMapa(int x, int y) {
        this.x = x;
        this.y = y;
    }
public ElementosDelMapa(){};
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}
