
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;

public class Main {

    public static void main(String[] args){

        Tablero tablero = new Tablero(10, 10); // Ajusta el tamaño del tablero según tus necesidades
        Rover rover = new Rover(0, 0, "Norte"); // Puedes ajustar la orientación inicial si lo deseas
        tablero.inicializarConJugadorEnPosicionAleatoria(rover);
        System.out.println("Posición del jugador: X=" + rover.getX() + ", Y=" + rover.getY());
        System.out.println("tablero" + tablero.getCasilla(1,1) );

    }

}
