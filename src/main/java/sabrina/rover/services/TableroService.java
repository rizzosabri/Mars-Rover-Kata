package sabrina.rover.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Obstaculo;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;
import sabrina.rover.repository.ObstaculoRepository;
import sabrina.rover.repository.RoverRepository;
import sabrina.rover.repository.TableroRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableroService {
    Obstaculo obstaculo = new Obstaculo(0,0, this.tablero);
    Obstaculo obstaculo2 = new Obstaculo(0,1, this.tablero);
    Tablero tablero = new Tablero(4, 4);
    Rover rover = new Rover(0, 0, "Norte", this.tablero);
    @Autowired
    private TableroRepository tableroRepository;

    @Autowired
    private ObstaculoRepository obstaculoRepository;
    @Autowired
    private RoverService roverService;

    @Autowired
    private RoverRepository roverRepository;

    @Transactional
    public void iniciarTablero() {
        generarMapa(tablero);
        save(tablero);
        saveObstaculo(obtenerObstaculos());
        saveRover(obtenerRover());

    }
    public Rover obtenerRover() {

        for (int i = 0; i <= tablero.getCasillas().length - 1; i++) {
            if (tablero.getCasillas()[i] == rover) {
            }
        }
        return rover;
    }
    private List<Obstaculo> obtenerObstaculos() {
        List<Obstaculo> listaDeObstaculos = new ArrayList<>();
        for (int i = 0; i <= tablero.getCasillas().length - 1; i++) {
            if (tablero.getCasillas()[i] instanceof Obstaculo) {
                Obstaculo obstaculoEnCasilla = (Obstaculo) tablero.getCasillas()[i];
                listaDeObstaculos.add(obstaculoEnCasilla);
            }
        }
        return listaDeObstaculos;
    }

    public Rover saveRover(Rover rover) {
        roverRepository.save(rover);
        return rover;
    }

    public void saveObstaculo(List<Obstaculo> obstaculos) {

        List<Obstaculo> obstaculosGuardados = new ArrayList<>();

        for (Obstaculo obstaculo : obstaculos) {
            obstaculosGuardados.add(obstaculoRepository.save(obstaculo));
        }
    }
    public Tablero generarMapa(Tablero tablero) {
        this.tablero.inicializarConObjetoEnPosicionAleatoria(obstaculo);
        this.tablero.inicializarConObjetoEnPosicionAleatoria(obstaculo2);
        this.tablero.inicializarConObjetoEnPosicionAleatoria(rover);
        tablero = this.tablero;
        System.out.println("tablero inicial: " + tablero);
        return this.tablero;
    }

    @Transactional
    public Tablero get() {
        System.out.println(tableroRepository.findAll());
        return tableroRepository.findAll().get(0);
    }

    @Transactional
    public Tablero save(Tablero tablero) {
        tableroRepository.save(tablero);
        return tablero;
    }



    public void mover(char[] comandos) {
     //   rover = roverService.get();
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
        System.out.println("el nuervo rover es : "  + rover);
        actualizarRover();
    }

    public Rover actualizarRover() {
        System.out.println("el rover que quiero guardar es: " + rover);
        saveRover(rover);
        return rover;
    }
}
