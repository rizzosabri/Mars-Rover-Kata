package sabrina.rover.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableroController {

    @GetMapping("/tablero")
    public String mostrarTablero(Model model) {
        //  datos del tablero y pasarlos al modelo
        // model.addAttribute("tablero", tablero);
        return "tablero"; // Nombre de la plantilla HTML
    }
}
