package sabrina.rover.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Obstaculo;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;
import sabrina.rover.repository.RoverRepository;
import sabrina.rover.repository.TableroRepository;

@Service
public class TableroService {
    Tablero tablero = new Tablero(4, 4);
    Rover rover = new Rover(0, 0, "Norte", this.tablero);
    @Autowired
    private TableroRepository tableroRepository;
    @Autowired
    private RoverRepository roverRepository;

    @Transactional
    public void iniciarTablero() {
        generarMapa(tablero);
        save(tablero);
        rover = obtenerRover();
        saveRover(rover);
    }

    Rover saveRover(Rover rover) {
        roverRepository.save(rover);
        return rover;
    }

    public Tablero generarMapa(Tablero tablero) {
        Obstaculo obstaculo = new Obstaculo(0, 0);
        this.tablero.inicializarConObjetoEnPosicionAleatoria(obstaculo);
        this.tablero.inicializarConObjetoEnPosicionAleatoria(rover);
        tablero = this.tablero;
        return this.tablero;
    }

    @Transactional
    public Tablero get(Long id) {
        return tableroRepository.findById(id).orElse(null);
    }

    @Transactional
    public Tablero save(Tablero tablero) {
        tableroRepository.save(tablero);
        return tablero;
    }

    public Rover obtenerRover() {
        for (int i = 0; i <= tablero.getCasillas().length - 1; i++) {
            if (tablero.getCasillas()[i] == rover) {

            }

        }
        return rover;
    }


}
