package sabrina.rover.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sabrina.rover.models.Rover;
import sabrina.rover.models.Tablero;


//un "bean" es un término que se utiliza para referirse a un objeto gestionado por el contenedor de Spring.
// Estos objetos gestionados son instancias de clases Java que son administradas por Spring y
// están configuradas en el contexto de la aplicación Spring.
@Configuration
public class MiConfiguracion {


    @Bean
    public Tablero tablero() {
        return new Tablero(0,0);
    }
    @Bean
    public Rover rover() {
        return new Rover(0,0,"Norte", tablero());
    }
}