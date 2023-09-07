package sabrina.rover.models;
public class Rover extends ElementosDelMapa {
        private String orientacion;

        public Rover(int x, int y, String orientacion) {
            super(x, y);
            this.orientacion = orientacion;
        }

        // Getters y setters

        public String getOrientacion() {
            return orientacion;
        }

        public void setOrientacion(String orientacion) {
            this.orientacion = orientacion;
        }

    public void mover(String direccion) {
       if("F".equals(direccion)){ //F= FORWARD
        switch (orientacion) {
            case "Norte":
                y--;
                this.fueraDeLimiteSuperior();
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
        if("B".equals(direccion)){ //F= BACKWARD
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
        if ("R".equals(sentido)){
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
        if("L".equals(sentido)){
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

    public void fueraDeLimiteSuperior() {
        if (this.getY() == -1) {
            this.setY(Tablero.ejeY);
        }
}
}