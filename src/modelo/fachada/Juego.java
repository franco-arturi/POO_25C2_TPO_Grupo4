package modelo.fachada;

import DTO.DueloDto;
import DTO.EnemigoDto;
import DTO.MagoDto;
import DTO.TiendaDto;
import modelo.*;
import vista.VistaMenuInicial;

import java.util.Random;



public class Juego {
    private static Juego instancia;
    private Mago jugador;
    private int cantDuelos = 1;
    private TiendaBaculos tienda;
    private int[][] historial;
    private Enemigo eneAux;
    private Duelo duelo;

    private Juego() {
        tienda = new TiendaBaculos();
        tienda.crearCatalogoBaculos();
        tienda.crearCatalogoCapas();
    }

    //ESTO ES PARA EL SINGLETON, IMPORTANTISIMO PORQUE NO QUEREMOS CORRER EL RIESGO DE QUE
    //HAYA 2 INSTANCIAS DE JUEGO.
    public static Juego getInstancia() {
        if (instancia == null) {
            instancia = new Juego();
        }
        return instancia;
    }


    public void crearMagoElemental(String nombre){
        jugador = new HechizeroElemental(nombre);
    }

    public void crearMagoIlusionista(String nombre){
        jugador = new Ilusionista(nombre);
    }

    public void crearMagoInvocador(String nombre){
        jugador = new Invocador(nombre);
    }

    public MagoDto getMago(){
        MagoDto mago = new MagoDto(jugador);
        return mago;
    }

    public boolean subirVida(){
        return jugador.subirVida();
    }

    public boolean subirEnergia(){return jugador.subirEnergia();}

    public boolean crearInvocacion(){return ((Invocador)jugador).invocar();}

    public String getTipoMago(){
        return jugador.getTipo();}

    public int getCantDuelos() {
        return cantDuelos;
    }

    public TiendaDto getTienda(){
        return new TiendaDto(tienda.getBaculos(), tienda.getCapas());
    }

    public boolean comprarBaculo(String nombre){
        return tienda.comprarBaculo(nombre, jugador);
    }

    public boolean comprarCapa(String nombre){
        return tienda.comprarCapa(nombre, jugador);
    }

    public Enemigo crearEnemigo(){
        Enemigo elegido;
        if (cantDuelos<10){
            Random rand = new Random();
            elegido = new Enemigo(rand.nextInt(101)+50,500);
        }
        else{
            elegido = new Enemigo(220,1000);
        }
        return elegido;
    }

    public void crearDuelo(){
        this.eneAux = crearEnemigo();
        this.duelo = new Duelo(jugador,eneAux);
    }

    public boolean iniciarDuelo(){
        boolean estadoAux;

        if (!duelo.batalla()){
            estadoAux = false;

        }
        else {
            estadoAux = true;
            cantDuelos++;
        }
        historial = duelo.devolverHistorial();

        return estadoAux;
    }

    public DueloDto getDuelo(){
        crearDuelo();
        DueloDto duelo = new DueloDto(new EnemigoDto("a",eneAux.getPuntosVida(),eneAux.getPoderMagico()));
        duelo.setVictoria(iniciarDuelo());

        duelo.setHistorial(historial);

        return duelo;
    }

    public int[][] getHistorialDuelos() {
        return historial;
    }

    public Enemigo getEnemigo(){
        return eneAux;
    }


}//Final clase modelo.fachada.Juego

