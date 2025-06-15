package DTO;

public class BaculoDto {
    String nombre;
    int poder;
    int precio;
    public BaculoDto(String nombre, int poder, int precio) {
        this.nombre = nombre;
        this.poder = poder;
        this.precio = precio;
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
}
