package sabrina.rover.models;

public class ElementosDelMapa {
    protected int x; // Posición en el eje X
    protected int y; // Posición en el eje Y
    public ElementosDelMapa(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
