import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tablero tablero = new Tablero(10, 10); // Ajusta el tamaño del tablero según tus necesidades
        Rover rover = new Rover(0, 0, "Este"); // Puedes ajustar la orientación inicial si lo deseas
        tablero.inicializarConContenidoEnPosicionAleatoria(rover);
        System.out.println("Posición del Rover: X=" + rover.getX() + ", Y=" + rover.getY());
        System.out.println(rover.getOrientacion());
        rover.cambiarOrientacion("L");
        System.out.println(rover.getOrientacion());
        rover.mover("F");

        // Verificar la nueva posición del jugador
        System.out.println("Nueva posición del rover: X=" + rover.getX() + ", Y=" + rover.getY());

        boolean continuarMoviendo;
        do {
            continuarMoviendo = true;
            System.out.println("Ingresa los comandos que desee  para mover al rover (F=HACIA DELANTE, B=HACIA ATRAS," +
                    " R=GIRAR SU ORIENTACION HACIA LA DERECHA , L=GIRAR SU ORIENTACION HACIA LA IZQUIERDA). Si ha llegado a destino y desea salir " +
                    "ingrese S:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toUpperCase();
            char[] comandos = input.toCharArray();

            for (int i = 0; i <= comandos.length - 1; i++) {
                String comando = Character.toString(comandos[i]);
                switch (comando) {
                    case "B":
                        rover.mover("B");
                        System.out.println("la nueva posicion es :  x = " + rover.getX() + " y = " + rover.getY());
                        break;
                    case "F":
                        rover.mover("F");
                        System.out.println("la nueva posicion es :  x = " + rover.getX() + " y = " + rover.getY());
                        break;
                    case "R":
                        rover.cambiarOrientacion("R");
                        System.out.println("la nueva orientacion es : " + rover.getOrientacion());
                        break;
                    case "L":
                        rover.cambiarOrientacion("L");
                        System.out.println("la nueva orientacion es : " + rover.getOrientacion());
                        break;
                    case "S":
                        continuarMoviendo = false;
                        System.out.println("FIN: HA LLEGADO A DESTINO");
                        break;
                    default:
                        System.out.println("Entrada no válida.");
                        break;
                }
            }
        } while (continuarMoviendo);

    }
}
    
