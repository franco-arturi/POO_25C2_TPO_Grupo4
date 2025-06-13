public class Duelo {
    private Mago mago;
    private Enemigo enemigo;
    private int contDamage;

    public Duelo(Mago mago, Enemigo enemigo) {
        this.mago = mago;
        this.enemigo = enemigo;
        this.contDamage = 0;
    }

    public boolean batalla(){
        while(mago.isVivo() && enemigo.isVivo()){
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

    public int experienciaObtenida(){
        return (enemigo.experienciaBruta())-contDamage;
    }

}
