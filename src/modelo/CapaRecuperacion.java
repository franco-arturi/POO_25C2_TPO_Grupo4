package modelo;

//Cura luego de cada duelo pero el enemigo hace 50 de daño mas.

public class CapaRecuperacion extends Capa{
    public CapaRecuperacion() {
        super(100,"Capa Recuperacion");
    }


    @Override
    public int modificadorDañoEnemigo(int daño) {
        return daño + 50;
    }

    @Override
    public void modificadorFinalDuelo(Mago mago) {
        mago.curar();

    }

    @Override
    public int modificarDañoAtaque(int ataque) {
        return ataque;

    }


}
