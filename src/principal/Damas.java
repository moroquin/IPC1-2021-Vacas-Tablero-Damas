package src.principal;

import java.util.Scanner;

import src.tablero.*;

public class Damas {

    private static Scanner scanner = new Scanner(System.in);

    private static String readString(String mensaje){
        String res = "";

        boolean lecturaCorrecta = false;

        while(!lecturaCorrecta){
            System.out.print(mensaje + " ");

            res = scanner.nextLine();
            res = res.trim();
            if (res.length()>0){
                lecturaCorrecta = true;
            }
            else{
                System.out.println("Debe ingresar al menos un caracter para continuar.");
            }

        }

        return res;
    }

    private static int readInt(String mensaje, boolean soloPositivo){
        int res = 0 ;
        String lectura = "";
        boolean lecturaCorrecta = false;
        while(!lecturaCorrecta){
            System.out.print(mensaje+" ");
            lectura = scanner.nextLine();

            try {
                res = Integer.valueOf(lectura);
                lecturaCorrecta = true;
                if (soloPositivo && res<0){
                    lecturaCorrecta = false;
                    System.out.println("Debe ingresar un número positivo. ");
                }
            } catch (Exception e) {
                lecturaCorrecta = false;
            }    
        }
        
        return res;
    }
    Tablero tablero ;

    public Damas(){
        tablero = new Tablero(8, 8,true);

    }

    public void jugar(){


        turno(true);
        turno(false);
        turno(true);
        turno(false);
        turno(true);
        turno(false);
        turno(true);
        turno(false);
        




/*
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
        //t.pintarTablero();*/

    }

    private void turno(boolean esBlanca){
        
        Ficha fichaAMover = null;
        Coordenada[] coordenadasPosibles = null;
        String advertencia = "";

        while (fichaAMover== null) {
            tablero.pintarTablero();
            System.out.println(advertencia);
            advertencia = "";
            System.out.println("TURNO DE LAS "+((esBlanca)?"BLANCAS":"NEGRAS"));
            fichaAMover = tablero.getFicha(Damas.readString("Seleccione la ficha que desea mover "), esBlanca);
            if (fichaAMover == null){
                advertencia +="Debe seleccionar una ficha valida";
            }
            else{
                coordenadasPosibles = fichaAMover.getMovimientosPosibles();

                if (coordenadasPosibles!=null){
                    String mensaje = "\nCoordenadas posibles para la ficha seleccionada: \n";
                    int cantidadPosibilidades = 0;
                    int i = 0;
                    while (coordenadasPosibles[i]!=null) {
                        if (coordenadasPosibles[i] != null) {
                            mensaje+= i+") "+coordenadasPosibles[i].toString()+"\n";
                            cantidadPosibilidades++;
                        }
                        i++;
                    }
                    mensaje += "\nSeleccione la coordenada a la que desea moverse: ";
                    int seleccion = -1;
                    while ((seleccion < 0)||(seleccion >= cantidadPosibilidades)){
                        seleccion = Damas.readInt(mensaje, true);
                    }

                    tablero.moverFicha(fichaAMover, coordenadasPosibles[seleccion]);

                }
                else{
                    
                    advertencia += "La ficha "+fichaAMover.getId()+" que selecciono no tiene movimientos posibles";
                    fichaAMover = null;
                }
            }

            
        }


    }


    
}
