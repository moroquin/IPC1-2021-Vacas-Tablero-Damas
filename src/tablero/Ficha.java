package src.tablero;

public class Ficha {
    private boolean esNegra;

    private boolean debeAscender;

    //private int x,y; 
    private Coordenada posicion;

    private char celda = '░';
    private char celdaColor = '█';
    //█▓
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private String id;


    
    public String getCaracter(){
        String res =(esNegra)?""+ANSI_RED+celda:""+ANSI_YELLOW+celda;
        return res;
    }

    public Ficha(boolean esNegra , String id, Coordenada posicion, boolean debeAscender){
        this.debeAscender = debeAscender;
        this.posicion = posicion;
        this.esNegra = esNegra;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public Coordenada[] getMovimientosPosibles(int x, int y){
        Coordenada[] res = new Coordenada[4];
        int cont =0;


        return res;
    }


}
