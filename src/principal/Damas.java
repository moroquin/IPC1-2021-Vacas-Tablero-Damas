package src.principal;

import src.tablero.*;

public class Damas {

    public Damas(){

    }

    public void jugar(){
        Tablero t = new Tablero(8, 8,true);

        t.pintarTablero();
        t.moverFicha("09", true, new Coordenada(0, 3));
        t.pintarTablero();
        t.moverFicha("09", true, new Coordenada(1, 4));
        t.pintarTablero();
        t.getFicha("02", false).getMovimientosPosibles();

        //t.getCelda(new Coordenada(1, 2)).getFicha().getMovimientosPosibles();
        //System.out.println(t.moverFicha(0, 0, 5, 5));
        //t.pintarTablero();
        //System.out.println(t.moverFicha(5, 5, 1, 1));
        //t.pintarTablero();
    }
    
}
