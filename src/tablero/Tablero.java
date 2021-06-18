package src.tablero;

public class Tablero {

    private Celda[][] tablero; 
    private final int x,y;

    public Tablero(int x, int y){
        this.x = x;
        this.y = y;
        tablero = new Celda[x][y];
        inicializarTablero();

        tablero[1][0].setFicha(new Ficha(true, "AA"));
        tablero[0][1].setFicha(new Ficha(false, "AB"));
        tablero[0][0].setFicha(new Ficha(true, "AC"));
        tablero[1][1].setFicha(new Ficha(false, "AD"));
        //tablero[0][1].setFicha(new Ficha(false));


    }

    public boolean moverFicha(int posXIni, int posYIni, int posXFin, int posYFin){
        boolean resultado = false;
        if (tablero[posXIni][posYIni].ocupadaPorFicha()){
            if (!tablero[posXFin][posYFin].ocupadaPorFicha()){
                tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha());
                resultado = true;
            }
        }
        return resultado;
    }

    private void inicializarTablero(){

        boolean esColorInicio = false;
        boolean esColorIteracion = false;
        for ( int i = 0; i < y; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < x; j++) {
                tablero[j][i] = new Celda(esColorIteracion);
                esColorIteracion = !esColorIteracion;
                
            }
            esColorInicio = !esColorInicio;
        }
    }

    public void pintarTablero(){

        for ( int i = 0; i < y; i++) {            
            
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(tablero[j][i].pintarCelda(k));
                }
                System.out.println("");
            }

            
        }
        System.out.println("\n\n");
    }
    
}
