package modelo.fachada;

import DTO.MagoDto;
import modelo.*;
import vista.VistaMenuInicial;

import java.util.Random;



public class Juego {
    private static Juego instancia;
    private boolean estadoPartida;
    private Mago jugador;
    private int cantDuelos = 1;
    private TiendaBaculos tienda;
    private int cantTurnos = 0;
    private int[][] historial;
    private Enemigo eneAux;
    private Duelo duelo;

    private Juego() {
        tienda = new TiendaBaculos();
        tienda.crearCatalogo();
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

    /// ////////////////////////////////




//    public boolean menuJuego( int opcion){
//
//        if (cantDuelos < 10){}
//
//
//
//
//
//        else {
//            System.out.println("La batalla final iniciara...");
//            boolean victoria=iniciarDuelo();
//            if (victoria){
//                System.out.println("El jugador es Victorioso contra el Archimago.");
//            }
//            else {
//                System.out.println("El jugador es derrotado por el Archimago.");
//            }
//        }
//    }

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
            System.out.println("\n💀 Has sido derrotado en combate...\n" );
        }
        else {
            System.out.println("\n🏆 ¡Victoria! Has vencido al enemigo número: " + cantDuelos + "!\n");
            estadoAux = true;
            cantDuelos++;
        }
        historial = duelo.devolverHistorial();

        return estadoAux;
    }

    public void interactuarTienda(){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🏪 CATÁLOGO DE BÁCULOS MÁGICOS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Cantidad de monedas: $"+jugador.getMonedas());
        tienda.mostrarBaculos();
        //Agregar un chequeo de monedas.

        tienda.comprarBaculo(1,jugador);
        System.out.println("✅ Has comprado un nuevo báculo.");



    }

    public int[][] getHistorialDuelos() {
        return historial;
    }

    public Enemigo getEnemigo(){
        return eneAux;
    }


}//Final clase modelo.fachada.Juego

