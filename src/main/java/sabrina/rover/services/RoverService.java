package sabrina.rover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;
import sabrina.rover.repository.RoverRepository;

@Service
public class RoverService {
    @Autowired
    private RoverRepository roverRepository;
    @Autowired
    private TableroService tableroService;
    @Autowired
    private Rover rover;
    @Autowired
    private Tablero tablero;

    public char[] ingresoDeComandos(String mensaje) {
        String input = mensaje.toUpperCase();
        char[] comandos = input.toCharArray();
        return comandos;
    }

    public Rover mover(char[] comandos) {

        rover = tableroService.obtenerRover();
        tablero.vaciarCasilla(rover.getX(), rover.getY());
        for (int i = 0; i <= comandos.length - 1; i++) {
            String comando = Character.toString(comandos[i]);
            switch (comando) {
                case "B":
                    rover.mover("B");
                    if (tablero.contenidoCasilla(rover.getX(), rover.getY()) != null) {
                        System.out.println("Lo siento, casillero ocupado obstruido, no puede pasar.");
                        rover.mover("F");
                    }
                    System.out.println("la posicion actual es :  x = " + rover.getX() + " y = " + rover.getY());
                    break;
                case "F":
                    rover.mover("F");
                    if (tablero.contenidoCasilla(rover.getX(), rover.getY()) != null) {
                        System.out.println("Lo siento, casillero ocupado obstruido, no puede pasar.");
                        rover.mover("B");
                    }
                    System.out.println("la posicion actual es :  x = " + rover.getX() + " y = " + rover.getY());
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
                    System.out.println("FIN: HA LLEGADO A DESTINO");
                    break;
                default:
                    System.out.println("Entrada no válida.");
                    break;
            }

        }

        return rover;
    }



    public Rover get(Long id) {
        return roverRepository.findById(id).orElse(null);
    }



    public Rover save() {
        System.out.println("el rover que quiero guardar es: " + rover);
        //roverRepository.save(rover); no funciona, rover es un elemento de mapa no tiene la orientacion (???
        return rover;
    }
}
