package DTO;

public class EnemigoDto {
    String nombre;
    int puntosVida;
    int energiaMagica;

    public EnemigoDto(String nombre, int puntosVida, int energiaMagica){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energiaMagica = energiaMagica;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getEnergiaMagica() {
        return energiaMagica;
    }
}
