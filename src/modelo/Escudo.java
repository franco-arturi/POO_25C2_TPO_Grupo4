package modelo;

public abstract class Escudo {

    protected String nombre;

    public abstract int bloquearDaño(int danio);
    public int reflejarDanio(int danio) {
        return 0; // Por defecto no refleja
    }

     public String getNombre() {
        return nombre;
    }
    
}
