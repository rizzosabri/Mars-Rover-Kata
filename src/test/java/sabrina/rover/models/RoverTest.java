package sabrina.rover.models;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class RoverTest {
    Tablero tablero = new Tablero(5,5);
    Obstaculo obstaculo = new Obstaculo(0,0);
    Rover rover = new Rover(0,0,"Norte", tablero);


    @Test
    void siElEjeYDisminuyeDeCeroSeConvierteEnElValorMasGrandeDeYEnElTablero() {
        tablero.colocarContenido(rover,0,0);
        tablero.inicializarConObjetoEnPosicionAleatoria(obstaculo);

        rover.mover("F");
        Assert.isTrue(rover.getY()!= -1, "No puede ser -1");
    }
    @Test
    void siElEjeXDisminuyeDeCeroSeConvierteEnElValorMasGrandeDeXEnElTablero() {
        tablero.colocarContenido(rover,0,0);
        tablero.inicializarConObjetoEnPosicionAleatoria(obstaculo);
        rover.cambiarOrientacion("L");
        rover.mover("F");
        Assert.isTrue(rover.getX()!= -1, "No puede ser -1");
    }

}