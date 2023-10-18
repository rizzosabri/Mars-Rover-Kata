package sabrina.rover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sabrina.rover.models.Rover;
import sabrina.rover.services.RoverService;
import sabrina.rover.services.TableroService;

import java.util.Map;

@RestController
@RequestMapping("/api/rover")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RoverController {

    @Autowired
    private RoverService roverService;

    @Autowired
    private TableroService tableroService;

    @GetMapping("")
    public Rover mostrarRover() {
        return roverService.get(); //
    }


    @PostMapping("/mover")
    public String ingresoComandosRover(@RequestBody Map<String, String> requestBody) {
        String mensaje = requestBody.get("mensaje");
        char[] comandos = roverService.ingresoDeComandos(mensaje);
        tableroService.mover(comandos);
        return "comandos recibidos";
    }

    @PostMapping("/guardar")
    public String guardarRover(@RequestBody Map<String, String> requestBody) {
        String mensaje = requestBody.get("guardar");
        tableroService.actualizarRover();
        return "rover actualizado";
    }


}