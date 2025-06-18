package modelo;

public class CapaBase extends Capa{

    public CapaBase() {
        super(0, "Capa Base");
    }

    @Override
    public int modificadorDañoEnemigo(int daño) {
        return daño;
    }

    @Override
    public void modificadorFinalDuelo(Mago mago) {

    }

    @Override
    public int modificarDañoAtaque(int ataque) {
        return ataque;
    }
}
