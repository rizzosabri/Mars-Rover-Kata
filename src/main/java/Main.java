
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;

public class Main {

    public static void main(String[] args){

        Tablero tablero = new Tablero(10, 10); // Ajusta el tamaño del tablero según tus necesidades
        Rover rover = new Rover(0, 0, "Este"); // Puedes ajustar la orientación inicial si lo deseas
        tablero.inicializarConContenidoEnPosicionAleatoria(rover);
        System.out.println("Posición del Rover: X=" + rover.getX() + ", Y=" + rover.getY());
        System.out.println(rover.getOrientacion());
        rover.cambiarOrientacion("R");
        System.out.println(rover.getOrientacion());

        rover.moverAdelante();

        // Verificar la nueva posición del jugador
        System.out.println("Nueva posición del rover: X=" + rover.getX() + ", Y=" + rover.getY());

    }

}
