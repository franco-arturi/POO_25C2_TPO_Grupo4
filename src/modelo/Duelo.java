package modelo;

import DTO.DueloDto;


public class Duelo {
    private Mago mago;
    private Enemigo enemigo;
    private int contDamage;
    private int[][] historial;
    private DueloDto dueDto;

    public Duelo(Mago mago, Enemigo enemigo) {
        this.mago = mago;
        this.enemigo = enemigo;
        this.contDamage = 0;
        historial = new int[100][2];
    }

    public boolean batalla(){
        int cont = 0;
        while(mago.isVivo() && enemigo.isVivo()){
            // msgo.atacar(enemigo)\
            // rnrmigo.atacar(mago)
            historial[cont][1] =  enemigo.getPuntosVida();
            historial[cont][0] =  mago.getPuntosVida();
            cont++;
            enemigo.recibirDaño(mago.atacar());

            mago.recibirDaño(enemigo.getPoderMagico());
            contDamage += enemigo.getPoderMagico();
        }
        if(!mago.isVivo()){
            return false;
        }
        mago.victoriaDuelo(experienciaObtenida(), 100);
        return true;
    }

    public int[][] devolverHistorial(){
        return historial;
    }

    public int experienciaObtenida(){
        return (enemigo.experienciaBruta())-contDamage;
    }

}
