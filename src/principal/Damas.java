package src.principal;

import src.tablero.*;

public class Damas {

    public Damas(){

    }

    public void jugar(){
        Tablero t = new Tablero(8, 8,true);

        t.pintarTablero();
        t.getCelda(new Coordenada(1, 2)).getFicha().getMovimientosPosibles( t);
        //System.out.println(t.moverFicha(0, 0, 5, 5));
        //t.pintarTablero();
        //System.out.println(t.moverFicha(5, 5, 1, 1));
        //t.pintarTablero();
    }
    
}
