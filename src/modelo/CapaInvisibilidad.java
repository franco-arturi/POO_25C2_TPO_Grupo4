package modelo;
import java.util.Random;

//Se falla el 50% de los golpes, pero se hacen 75 mas de daño al mago

public class CapaInvisibilidad extends Capa {
    public CapaInvisibilidad() {
        super(100,"Capa de Invisibilidad");

    }

    @Override
    public int modificadorDañoEnemigo(int daño) {
        Random r = new Random();
        int chance = r.nextInt(2);
        return (daño + 75)*chance;
    }

    @Override
    public void modificadorFinalDuelo(Mago mago) {

    }

    @Override
    public int modificarDañoAtaque(int ataque) {
        return ataque;
    }
}
