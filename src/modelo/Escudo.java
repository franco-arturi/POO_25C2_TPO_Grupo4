package modelo;

public abstract class Escudo {

    protected String nombre;

public int bloquearDaño(int danio) {
    return (int)(danio * 0.8); // Bloquea el 20% del daño
}
 

     public String getNombre() {
        return nombre;
    }
    
}
