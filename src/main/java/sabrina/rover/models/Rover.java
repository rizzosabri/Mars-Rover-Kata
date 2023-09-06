package sabrina.rover.models;

public class Rover {

        private int x; // Posición en el eje X
        private int y; // Posición en el eje Y
        private String orientacion; // Orientación del rover

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

    public void mover(String direccion) {
       if(direccion=="F"){ //F= FORWARD
        switch (orientacion) {
            case "Norte":
                y--;
                break;
            case "Sur":
                y++;
                break;
            case "Este":
                x++;
                break;
            case "Oeste":
                x--;
                break;
            default:
                throw new IllegalArgumentException("Orientación no válida");
        }
    }
        if(direccion=="B"){ //F= BACKWARD
            switch (orientacion) {
                case "Norte":
                    y++;
                    break;
                case "Sur":
                    y--;
                    break;
                case "Este":
                    x--;
                    break;
                case "Oeste":
                    x++;
                    break;
                default:
                    throw new IllegalArgumentException("Orientación no válida");
            }
        }
    }

    public void cambiarOrientacion(String sentido) {
        if (sentido== "R"){
            switch (orientacion) {
                case "Norte":
                    orientacion="Este";
                    break;
                case "Sur":
                    orientacion="Oeste";
                    break;
                case "Este":
                    orientacion="Sur";
                    break;
                case "Oeste":
                    orientacion="Norte";
                    break;
            }
        }
        if(sentido=="L"){
            switch (orientacion) {
                case "Norte":
                    orientacion="Oeste";
                    break;
                case "Sur":
                    orientacion="Este";
                    break;
                case "Este":
                    orientacion="Norte";
                    break;
                case "Oeste":
                    orientacion="Sur";
                    break;
            }
        }
    }


}
