package sabrina.rover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sabrina.rover.models.Tablero;
import sabrina.rover.services.TableroService;

import java.util.Map;

@RestController
public class TableroController {

    @Autowired
    private TableroService tableroService;

    @PostMapping ("/api/tablero")
    //ResponseEntity es una clase proporcionada por Spring Framework que permite a un controlador devolver una respuesta HTTP personalizada
    public ResponseEntity<String> ejecutarInicio(@RequestBody Map<String, String> requestBody) {
        String mensaje = requestBody.get("mensaje");

        if ("inicio".equals(mensaje)) {
            tableroService.iniciarTablero();
            return ResponseEntity.ok("Función ejecutada");
        } else {
            return ResponseEntity.badRequest().body("Mensaje no válido");
        }
    }

    @GetMapping("/api/tablero/{id}")
    public Tablero get(@PathVariable("id") Long id) {
        return tableroService.get(id);
    }




}
