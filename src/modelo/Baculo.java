package modelo;

public class Baculo {
    private int precio;
    private  int poderBaculo;
    private String nombre;
    private int duelosRequeridos;

    public Baculo(int pr, int pb, String nm, int due) {
        this.precio = pr;
        this.poderBaculo = pb;
        this.nombre = nm;
        this.duelosRequeridos = due;
    }

    public int getPrecio() {
        return precio;
    }
    public int getPoderBaculo() {
        return poderBaculo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getDuelosRequeridos() {
        return duelosRequeridos;
    }
}
