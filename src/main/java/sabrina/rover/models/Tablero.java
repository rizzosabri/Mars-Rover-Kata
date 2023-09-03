package sabrina.rover.models;

public class Tablero {
    private int ejeX; // Número de columnas en el tablero
    private int ejeY; // Número de filas en el tablero
    private Object[] casillas; // Array unidimensional para representar el contenido de las casillas

    public Tablero(int ejeX, int ejeY) {
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        casillas = new Object[ejeX * ejeY];
        // Inicializar todas las casillas del tablero con valores predeterminados
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = null; // Inicialmente, todas las casillas están vacías
        }
    }

    // Método para obtener el contenido de una casilla en una posición específica
    public Object getCasilla(int x, int y) {
        int indice = y * ejeX + x;
        if (indice >= 0 && indice < casillas.length) {
            return casillas[indice];
        } else {
            throw new IllegalArgumentException("Posición fuera de los límites del tablero");
        }
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
}
