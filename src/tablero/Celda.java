package src.tablero;

/**
 * Celda
 */
public class Celda {

    private boolean esColor;
    private Ficha ficha; 

    //private char celda = '░';
    private char celdaColor = '█';
    //█▓


    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void setFicha(Ficha f, int x, int y){
        this.ficha = f;
        this.ficha.setCoordenada(x, y);
    }
    public void setFicha(){
        this.ficha = null;
    }

    public boolean getEsColor(){
        return this.esColor;
    }

    public Ficha getFicha(){
        Ficha tmp = this.ficha;
        return tmp;
    }

    public boolean ocupadaPorFicha(){
        return (ficha!=null);
    }

    public Celda(boolean esColor){
        this.esColor = esColor;
        this.ficha = null;
    }

    public String pintarCelda( int linea){
        String res = "";
        if(esColor){
            res = imprimir(ANSI_WHITE, linea);
        }
        else{
            res = imprimir(ANSI_BLUE, linea);
        }

        return res;

    }

    private String imprimir(String color, int linea){
        String res = "";
        if(ficha!=null){
            if ((linea == 0)||(linea == 2))
                res=""+ color+celdaColor+celdaColor+   ficha.getCaracter()+ficha.getCaracter()+    color+celdaColor+celdaColor;
            if (linea == 1)
                res=""+ color+celdaColor+  ficha.getCaracter()+    ficha.getId()      +ficha.getCaracter()       +color+ celdaColor;
                //res=""+ color+celdaColor+  ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()       +color+ celdaColor;
            
        }else{
            res =""+ color+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor;
        }

        return res;
    }

    
}