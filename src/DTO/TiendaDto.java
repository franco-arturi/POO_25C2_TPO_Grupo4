package DTO;

import modelo.Baculo;
import modelo.Capa;

public class TiendaDto {
    //La tienda tiene objetos nada más, asi que tenemos que crear 2 listas con objetos capas y baculos.
    private CapaDto[] capas;
    private BaculoDto[] baculos;

    public TiendaDto(Baculo[] baculos, Capa[] capas) {
        // Contar cuántos baculos y capas no son null
        int cantidadBaculos = 0;
        for (Baculo b : baculos) {
            if (b != null) cantidadBaculos++;
        }

        int cantidadCapas = 0;
        for (Capa c : capas) {
            if (c != null) cantidadCapas++;
        }

        // Inicializar arrays solo con los no-nulos
        this.baculos = new BaculoDto[cantidadBaculos];
        this.capas = new CapaDto[cantidadCapas];

        // Copiar los datos no-nulos
        int i = 0;
        for (Baculo b : baculos) {
            if (b != null) {
                this.baculos[i++] = new BaculoDto(b.getNombre(), b.getPoderBaculo(), b.getPrecio(),b.getDuelosRequeridos());
            }
        }

        int j = 0;
        for (Capa c : capas) {
            if (c != null) {
                this.capas[j++] = new CapaDto(c.getNombre(), c.getPrecio());
            }
        }




    }

    public BaculoDto[] getBaculos() {
        return baculos;
    }
    public CapaDto[] getCapas() {
        return capas;
    }
}
