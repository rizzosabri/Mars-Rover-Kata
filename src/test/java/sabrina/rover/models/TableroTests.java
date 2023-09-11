package sabrina.rover.models;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class TableroTests {

    Tablero tablero = new Tablero(5,5);

    @Test
    void colocarContenido() {
        tablero.colocarContenido(new Object(),2,1);

        Assert.isTrue(tablero.contenidoCasilla(2,1) != null, "El contenido no se coloco correctamente");
        Assert.isNull(tablero.contenidoCasilla(0,0),"No todas las casillas se iniciaron vacias");
    }

    @Test
    void inicializarConObjetoEnPosicionAleatoria(){
        ElementosDelMapa elemento = new ElementosDelMapa(1,2);
        tablero.inicializarConObjetoEnPosicionAleatoria(elemento);

        Assert.isTrue(tablero.contenidoCasilla(elemento.getX(), elemento.getY()).equals(elemento));
    }

    @Test
    void inicializarConObjetoEnPosicionAleatoria_noInicializaSiEspacioEstaOcupado() {
        tablero = new Tablero(2,1);
        Rover rover = new Rover(0,0,"Norte",tablero);
        tablero.colocarContenido(rover,0,0);

        ElementosDelMapa elemento = new ElementosDelMapa(1,2);

        tablero.inicializarConObjetoEnPosicionAleatoria(elemento);

        Assert.isTrue(tablero.contenidoCasilla(0, 0).equals(rover));
    }
}
