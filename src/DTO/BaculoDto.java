package DTO;

public class BaculoDto {
    String nombre;
    int poder;
    int precio;
    int requisito;
    public BaculoDto(String nombre, int poder, int precio, int requisito) {
        this.nombre = nombre;
        this.poder = poder;
        this.precio = precio;
        this.requisito = requisito;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPoder() {
        return poder;
    }
    public int getPrecio() {
        return precio;
    }
    public int getRequisito() {return requisito;}
}
