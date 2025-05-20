public class Duelo {
    private Mago mago;
    private Enemigo enemigo;
    private int contDamage;
    private int auxPuntosVida;

    public Duelo(Mago mago, Enemigo enemigo) {
        this.mago = mago;
        this.enemigo = enemigo;
        this.auxPuntosVida = mago.getPuntosVida();
    }

    public boolean batalla(){
        while(mago.getPuntosVida()>0 && enemigo.getPuntosVida()>0){
            enemigo.setPuntosVida(-mago.atacar());
            mago.setPuntosVida(-enemigo.getPoderMagico());
            contDamage = contDamage + enemigo.getPoderMagico();
        }
        if(mago.getPuntosVida()<0){
            return false;
        }
        mago.setNivel(experienciaObtenida());
        mago.setMonedas(100);
        mago.setPuntosVida(-mago.getPuntosVida());
        mago.setPuntosVida(auxPuntosVida);
        return true;
    }

    public int experienciaObtenida(){
        return (enemigo.getPoderMagico()*2)-contDamage;
    }

}
