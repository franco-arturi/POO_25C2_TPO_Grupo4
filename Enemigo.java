public class Enemigo {
    private int poderMagico;
    private int puntosVida;
    private boolean vivo;


    public Enemigo(int poderMagico, int puntosVida) {
        this.poderMagico = poderMagico;
        this.vivo = true;
        this.puntosVida = puntosVida;
    }
    public int getPoderMagico() {
        return poderMagico;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public void recibirDaño(int puntosVida){
        this.puntosVida -= puntosVida;
        if(puntosVida <= 0){
            vivo = false;
        }
    }
    public int experienciaBruta(){
        return (poderMagico*2);
    }
    public boolean isVivo() {
        return vivo;
    }
}
