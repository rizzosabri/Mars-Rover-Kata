package sabrina.rover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Rover;
import sabrina.rover.repository.RoverRepository;

@Service
public class RoverService {
    @Autowired
    private RoverRepository roverRepository;

    public char[] ingresoDeComandos(String mensaje) {
        String input = mensaje.toUpperCase();
        char[] comandos = input.toCharArray();
        return comandos;
    }

    public Rover get() {
        System.out.println(roverRepository.findAll());
        return roverRepository.findAll().get(0);
    }


}
