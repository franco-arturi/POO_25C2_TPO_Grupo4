package modelo;

public class Baculo {
    private int precio;
    private  int poderBaculo;
    private String nombre;

    public Baculo(int pr, int pb, String nm) {
        this.precio = pr;
        this.poderBaculo = pb;
        this.nombre = nm;
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
}
