package DTO;

public class EscudoDto {
    String nombre;
    String descripcion;

    public EscudoDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
