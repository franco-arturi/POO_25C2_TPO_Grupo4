package controlador;

import DTO.EnemigoDto;
import DTO.MagoDto;
import modelo.fachada.Juego;

public class JuegoControlador {
/*
    public void hacerAlgo() {
        Juego.getInstancia().iniciarDuelo();
    }

 */

    public static void crearMagoElemental(String nombre){
        Juego.getInstancia().crearMagoElemental(nombre);
    }

    public static void crearMagoIlusionista(String nombre){
        Juego.getInstancia().crearMagoIlusionista(nombre);
    }

    public static void crearMagoInvocador(String nombre){Juego.getInstancia().crearMagoInvocador(nombre);}

    public static MagoDto getMago(){
        return Juego.getInstancia().getMago();
    }

    public static boolean subirVida(){return Juego.getInstancia().subirVida();}

    public static boolean subirEnergia(){return Juego.getInstancia().subirEnergia();}

    public static boolean crearInvocacion(){return Juego.getInstancia().crearInvocacion();}

    public static String getTipoMago(){return Juego.getInstancia().getTipoMago();}

    public static boolean iniciarDuelo(){return Juego.getInstancia().iniciarDuelo();}

    public static int getCantTurnos(){return Juego.getInstancia().getCantDuelos();}

    public static int[][] getHistorialDuelo(){
        return Juego.getInstancia().getHistorialDuelos();
    };

    public static EnemigoDto getEnemigo(){
        return new EnemigoDto("Enemigo",Juego.getInstancia().getEnemigo().getPuntosVida(),Juego.getInstancia().getEnemigo().getPoderMagico());
    }

    public static void crearDuelo(){
        Juego.getInstancia().crearDuelo();
    }
}
