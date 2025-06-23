package DTO;

public class DueloDto {
    boolean victoria;
    EnemigoDto enemigo;
    int[][] historial;

    public DueloDto( EnemigoDto enemigo) {
        this.enemigo = enemigo;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
    public void setHistorial(int[][] historial) {
        this.historial = historial;
    }

    public int getPoderEnemigo() {
        return enemigo.getEnergiaMagica();
    }

    public int getVidaEnemigo() {return enemigo.getPuntosVida();}

    public boolean getVictoria() {return victoria;}

    public int[][] getHistorial() {return historial;}
}
