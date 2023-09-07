package sabrina.rover.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableroController {

    @GetMapping("/tablero")
    public String mostrarTablero() {
        //  datos del tablero y pasarlos al modelo
        // model.addAttribute("tablero", tablero);
        return "tablero"; // Nombre de la plantilla HTML
    }
}
