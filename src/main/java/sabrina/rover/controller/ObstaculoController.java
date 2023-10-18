package sabrina.rover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sabrina.rover.models.Obstaculo;
import sabrina.rover.services.ObstaculoService;
import sabrina.rover.services.TableroService;

import java.util.List;

@RestController
@RequestMapping("/api/obstaculo")

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ObstaculoController {
    @Autowired
    private ObstaculoService obstaculoService;

    @Autowired
    private TableroService tableroService;

   @GetMapping("")
   public List<Obstaculo> mostrarObstaculo() {
      return  obstaculoService.getAll();
    }
}
