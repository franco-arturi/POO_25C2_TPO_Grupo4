package modelo;

public abstract class Capa {
    int precio;
    String nombre;

    public Capa(int precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }



    public abstract int modificadorDañoEnemigo(int daño);
    public abstract void modificadorFinalDuelo(Mago mago);
    public abstract int modificarDañoAtaque(int ataque);
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }

}
