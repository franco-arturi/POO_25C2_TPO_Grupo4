class CapaInvisibilidad extends Capa {
    private final int precio = 1000;
    private final int poderCapa = 70;
    @Override
    public void aplicarEfecto(Mago mago, Enemigo enemigo, boolean ganoDuelo) {
        // La lógica de fallo de golpes debe implementarse en el combate
    }
    @Override
    public int getPoderExtraRival() {
        return 75;
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