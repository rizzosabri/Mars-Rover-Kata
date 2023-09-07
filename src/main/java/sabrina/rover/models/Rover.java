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
                this.fueraDeLimiteInferior();
                break;
            case "Este":
                x++;
                this.fueraDeLimitePorElLadoDerecho();
                break;
            case "Oeste":
                x--;
                this.fueraDeLimitePorElLadoIzquierdo();
                break;
            default:
                throw new IllegalArgumentException("Orientación no válida");
        }
    }
        if("B".equals(direccion)){ //F= BACKWARD
            switch (orientacion) {
                case "Norte":
                    y++;
                    this.fueraDeLimiteInferior();
                    break;
                case "Sur":
                    y--;
                    this.fueraDeLimiteSuperior();
                    break;
                case "Este":
                    x--;
                    this.fueraDeLimitePorElLadoIzquierdo();
                    break;
                case "Oeste":
                    x++;
                    this.fueraDeLimitePorElLadoDerecho();
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
            int largoDelTablero=Tablero.ejeY;
        if (this.getY() == -1) {
            this.setY(largoDelTablero);
        }
    }

    public void fueraDeLimitePorElLadoIzquierdo() {
        if (this.getX() == -1) {
            this.setX(Tablero.ejeX);
        }
    }

    public void fueraDeLimitePorElLadoDerecho() {
        if (this.getX() >Tablero.ejeX) {
            this.setX(0);
        }
    }

    public void fueraDeLimiteInferior() {

        if (this.getY() >Tablero.ejeY) {
            this.setY(0);
        }
    }
}