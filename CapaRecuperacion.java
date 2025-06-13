class CapaRecuperacion extends Capa {
    private final int precio = 500;
    private final int poderCapa = 50;
    @Override
    public void aplicarEfecto(Mago mago, Enemigo enemigo, boolean ganoDuelo) {
        if (ganoDuelo) {
            mago.setPuntosVida(50); // Recupera vida (ajusta el valor según lo que desees)
        }
    }
    @Override
    public int getPoderExtraRival() {
        return 50;
    }
    @Override
    public int getPrecio() {
        return precio;
    }
    @Override
    public int getPoderCapa() {
        return poderCapa;
    }
}