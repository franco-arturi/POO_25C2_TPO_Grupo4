public class Enemigo {
    private int poderMagico;
    private int puntosVida;

    public Enemigo(int poderMagico, int puntosVida) {
        this.poderMagico = poderMagico;
        this.puntosVida = puntosVida;
    }
    public int getPoderMagico() {
        return poderMagico;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

}
