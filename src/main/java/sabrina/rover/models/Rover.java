package sabrina.rover.models;

public class Rover {

        private int x; // Posición en el eje X
        private int y; // Posición en el eje Y
        private String orientacion; // Orientación del jugador

        public Rover(int x, int y, String orientacion) {
            this.x = x;
            this.y = y;
            this.orientacion = orientacion;
        }

        // Getters y setters para los atributos
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getOrientacion() {
            return orientacion;
        }

        public void setOrientacion(String orientacion) {
            this.orientacion = orientacion;
        }


    }

