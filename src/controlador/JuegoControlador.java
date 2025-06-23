package controlador;

import DTO.DueloDto;
import DTO.EnemigoDto;
import DTO.MagoDto;
import DTO.TiendaDto;
import modelo.Escudo;
import modelo.fachada.Juego;

public class JuegoControlador {

    public void hacerAlgo() {
        Juego.getInstancia().iniciarDuelo();
    }



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

    public static DueloDto getDuelo(){
        return Juego.getInstancia().getDuelo();
    }

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

    public static TiendaDto getTienda(){
        return Juego.getInstancia().getTienda();
    }

    public static boolean comprarBaculo(String nombre){
        return Juego.getInstancia().comprarBaculo(nombre);
    }

    public static boolean comprarCapa(String nombre){return Juego.getInstancia().comprarCapa(nombre);}
// obtiene la lista de escudos disponibles en la tienda
    // y devuelve un array de objetos Escudo 
    public static Escudo[] getEscudos() {
        return Juego.getInstancia().getEscudos();
    }
// intenta comprar y equipar un escudo
    public static boolean comprarEscudo(int indice) {
        return Juego.getInstancia().comprarEscudo(indice);
    }

}
