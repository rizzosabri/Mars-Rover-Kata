package sabrina.rover.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Random;

@Data
@Entity
@Table(name = "Tablero")
public class Tablero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "id")
    protected Long id;
    @Column(name = "largo")
    protected int ejeX; // Número de columnas en el tablero
    @Column(name = "alto")
    protected int ejeY; // Número de filas en el tablero
    @Transient
    @JsonIgnore
    private Object[] casillas; // Array unidimensional para representar el contenido de las casillas


    public Tablero() {
    }

    public Tablero(int ejeX, int ejeY) {
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        casillas = new Object[ejeX * ejeY];
        // Inicializar todas las casillas del tablero con valores predeterminados
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = null; // Inicialmente, todas las casillas están vacías
        }
    }

    @Transient
    // Método para obtener el contenido de una casilla en una posición específica
    public Object contenidoCasilla(int x, int y) {
        int indice = y * ejeX + x;
        if (indice >= 0 && indice < casillas.length) {
            return casillas[indice];
        }
        return null;
    }

    // Método para colocar contenido en una casilla en una posición específica
    public void colocarContenido(Object contenido, int x, int y) {
        int indice = y * ejeX + x;
        if (indice >= 0 && indice < casillas.length) {
            casillas[indice] = contenido;
        } else {
            throw new IllegalArgumentException("Posición fuera de los límites del tablero");
        }
    }

    public void vaciarCasilla(int x, int y) {
        int indice = y * ejeX + x;
        if (indice >= 0 && indice < casillas.length) {
            casillas[indice] = null;
        }
    }

    public void inicializarConObjetoEnPosicionAleatoria(ElementosDelMapa elemento) {
        boolean flag = true;
        do {
            int x = coordenadaAleatoria(ejeX);
            int y = coordenadaAleatoria(ejeY);
            if (contenidoCasilla(x, y) == null) {
                elemento.setX(x);
                elemento.setY(y);
                colocarContenido(elemento, x, y);
                flag = false;
            }
        } while (flag);
    }

    public int coordenadaAleatoria(int eje) {
        Random random = new Random();
        int valor = random.nextInt(eje);
        return valor;
    }


}
