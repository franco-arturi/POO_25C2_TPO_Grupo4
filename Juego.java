import java.util.Random;

public class Juego {
    private boolean estadoPartida;
    private Mago jugador;
    private int cantDuelos = 1;
    private TiendaBaculos tienda;
    private int cantTurnos = 0;

    public Juego() {
        estadoPartida = true;
        tienda = new TiendaBaculos();
        tienda.crearCatalogo();
    }


    public void iniciarPartida(){
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✨ ¡Bienvenido al Reino de Magia! ✨");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        crearPersonaje(3);
        while (estadoPartida){
            System.out.println("\n════════════════════════════════════");
            System.out.println("🔮 Menú del Mago");
            System.out.println("1️⃣ Pelear");
            System.out.println("2️⃣ Tienda de Báculos");
            System.out.println("3️⃣ Subir de Nivel");
            System.out.println("4️⃣ Salir del Reino");
            System.out.println("════════════════════════════════════");
            estadoPartida = menuJuego(elegirOpcionMenu());
        }


    };

    // Método para elegir una opción del menú aleatoriamente
    private int elegirOpcionMenu() {
        Random random = new Random();
        return random.nextInt(4) + 1; // Genera un número aleatorio entre 1 y 4
    }

    public void crearPersonaje(int opcion){
        boolean completo = false;
        while(!completo){
            if (opcion == 1) {
                jugador = new HechizeroElemental();
                System.out.println("🧙‍♂️ Has elegido al Hechicero Elemental.");
                completo = true;
            } else if (opcion == 2) {
                jugador = new Ilusionista();
                System.out.println("🌀 Has elegido al Ilusionista.");
                completo = true;
            } else if (opcion == 3) {
                jugador = new Invocador();
                System.out.println("👻 Has elegido al Invocador.");
                completo = true;
            } else {
                System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
            }
        }
    }

    public boolean menuJuego( int opcion){
        boolean completo = true;
        //Se deberia elegir la opcion mediante un Scanner pero por la demostracion del programa solo
        // peleara hasta cierto turnos
        System.out.println("Turno: " + cantTurnos); // Mostrar el turno actual
        if (cantTurnos==5){//Esta parte solo esta para mostrar como funciona la tienda.
            System.out.println("Entrando a la tienda (turno 5)...");
            interactuarTienda();
            cantTurnos++;
            return completo;
        }
        else if(cantTurnos==9){//Esta parte solo esta para mostrar como funcionan los niveles.
            System.out.println("Subiendo de nivel (turno 9)...");
            subirNivel();
            cantTurnos++;
            return completo;
        }
        else if (cantDuelos <= 10) { // Cambio de < a <= para que la batalla final se ejecute
            if (opcion == 1) {
                //Iniciar Duelo.
                System.out.println("Peleando...");
                completo = iniciarDuelo();
                cantDuelos++;


            } else if (opcion == 2) {
                //Acceder a la tienda.
                System.out.println("Accediendo a la tienda...");
                interactuarTienda();

            } else if (opcion == 3) {
                //Subir de nivel.
                System.out.println("Subiendo de nivel...");
                subirNivel();
            } else if (opcion == 4) {
                //Salir
                System.out.println("Saliendo del reino...");
                completo = false;
            }
            cantTurnos++;
            return completo;
        }
        else {
            System.out.println("La batalla final iniciara...");
            boolean victoria=iniciarDuelo();
            if (victoria){
                System.out.println("El jugador es Victorioso contra el Archimago.");
            }
            else {
                System.out.println("El jugador es derrotado por el Archimago.");
            }
            completo=false;
            return completo;
        }
    }

    public Enemigo crearEnemigo(){
        Enemigo elegido;
        if (cantDuelos<=10){ // Cambio de < a <=
            Random rand = new Random();
            elegido = new Enemigo(rand.nextInt(101)+50,500);
        }
        else{
            elegido = new Enemigo(220,1000);
        }
        return elegido;
    }

    public boolean iniciarDuelo(){
        boolean estadoAux;
        Duelo duelo = new Duelo(jugador,crearEnemigo());
        System.out.println("\n⚔️ ¡Un nuevo duelo comienza!");
        System.out.println("Enemigo aparece... ¡Prepárate!\n");
        if (!duelo.batalla()){
            estadoAux = false;
            System.out.println("\n💀 Has sido derrotado en combate...\n" );
            estadoPartida = false; // Terminar el juego si el jugador pierde
        }
        else {
            System.out.println("\n🏆 ¡Victoria! Has vencido al enemigo número: " + cantDuelos + "!\n");
            estadoAux = true;
        }
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

    public void subirNivel(){
        System.out.println("\n🧗‍♂️ Mejora de habilidades:");
        System.out.println("Nivel actual: " + jugador.getNivel());
        int opcion = new Random().nextInt(3) + 1;//Aca iria un Scanner para elegir que opcion se quiere elegir.
        System.out.println("Opcion elegida para subir de nivel: " + opcion);
        if (jugador instanceof Invocador){
            System.out.println("\n1️⃣ Aumentar Puntos de Vida");
            System.out.println("2️⃣ Aumentar Energía Mágica");
            System.out.println("3️⃣ Crear Criaturas");
            if (opcion==1) {
                if (jugador.getNivel() > 20) {
                    jugador.setPuntosVida(100);
                    jugador.setNivel(jugador.getNivel()-20);
                    System.out.println("\n❤️ Vida aumentada con éxito.");
                }
            }
            else if (opcion==2){
                if (jugador.getNivel()>20) {
                    jugador.setEnergiaMagica(10);
                    jugador.setNivel(jugador.getNivel()-20);
                    System.out.println("\n💫 Energía mágica aumentada.");
                }
            }
            else if (opcion==3) {
                if (jugador.getNivel() > 20) {
                    //Esto le dice al codigo que estamos hablando de un Invocador y no solo de un mago.
                    //Lo agregue por que la clase Mago no tenia un metodo crearCriaturas().
                    ((Invocador)jugador).crearCriaturas();
                    jugador.setNivel(jugador.getNivel()-20);
                    System.out.println("\n🧟‍♂️ ¡Has invocado nuevas criaturas!");
                }
            }
            else{
                System.out.println("\nOpcion no valida\n");
            }
        }
        else {
            System.out.println("\n1️⃣ Aumentar Puntos de Vida");
            System.out.println("2️⃣ Aumentar Energía Mágica");

            if (opcion == 1) {
                if (jugador.getNivel() > 20) {
                    jugador.setPuntosVida(100);
                    jugador.setNivel(jugador.getNivel()-20);
                    System.out.println("\n❤️ Vida aumentada con éxito.");
                }
            } else if (opcion == 2) {
                if (jugador.getNivel() > 20) {
                    jugador.setEnergiaMagica(10);
                    jugador.setNivel(jugador.getNivel()-20);
                    System.out.println("\n💫 Energía mágica aumentada.");
                }
            } else {
                System.out.println("\nOpcion no valida\n");
            }
        }
        System.out.println("\n📊 Estado actual del mago:");
        System.out.println("🔋 Energía: " + jugador.getEnergiaMagica());
        System.out.println("❤️ Vida: " + jugador.getPuntosVida());
        if (jugador instanceof Invocador) {
            System.out.println("👻 Criaturas invocadas: " + ((Invocador)jugador).getCantCriaturas());
        }
    }
}