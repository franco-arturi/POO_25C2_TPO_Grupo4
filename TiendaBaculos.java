
public class TiendaBaculos {
    private Baculo[] baculos = new Baculo[8];
    private Capa[] capas = new Capa[2];

    public TiendaBaculos(){
        capas [0] = new CapaRecuperacion();
        capas [1] = new CapaInvisibilidad();
        crearCatalogo();
    }

    public void crearCatalogo(){
        baculos[0] = new Baculo(100,5,"Báculo de Roble Antiguo");
        baculos[1] = new Baculo(250,10,"Báculo de Cristal Arcano");
        baculos[2] = new Baculo(600,15,"Báculo de Cristal Arcano");
        baculos[3] = new Baculo(1200,20,"Báculo del Vacío Silente");
        baculos[4] = new Baculo(2500,25,"Báculo del Archimago Supremo");
        baculos[5] = new Baculo(800,0,"Báculo Elemental");
        baculos[6] = new Baculo(1500,0,"Báculo Resonancia");
        baculos[7] = new Baculo(3000,0,"Báculo Ancestral");

    }

    public void mostrarBaculos(){
        System.out.println("----- Baculos -----");
        for (int i = 0; i < baculos.length; i++) {
            Baculo b = baculos[i];
            System.out.println("[" + i + "] ✦ " + b.getNombre());
            System.out.println("    🧪 Poder mágico : " + b.getPoderBaculo());
            System.out.println("    💰 Precio       : $" + b.getPrecio());
            System.out.println("-----------------------------------");
        }
        System.out.println("----- Capas -----");
        for (int i = 0; i < capas.length; i++) {
            Capa c = capas[i];
            System.out.println("[" + (i + baculos.length) + "] ✦ " + getNombreCapa(c));
            System.out.println("    🧪 Poder mágico : " + c.getPoderCapa());
            System.out.println("    💰 Precio       : $" + getPrecioCapa(i));
            System.out.println("-----------------------------------");
        }
    }

    private String getNombreCapa(Capa capa) {
        if (capa instanceof CapaRecuperacion) {
            return "Capa de Recuperación";
        } else if (capa instanceof CapaInvisibilidad) {
            return "Capa de Invisibilidad";
        }
        return "Capa Desconocida";
    }

    private int getPrecioCapa(int index) {
        return (index == 0) ? 500 : 1000;
    }


    public void comprarBaculo(int index, Mago mago){
        if (index < baculos.length) {
            if(mago.puedeComprar(baculos[index])){
                mago.comprar(baculos[index]);
                System.out.println("✅ Has comprado "+baculos[index].getNombre());
            }
            else{
                System.out.println("El Mago no puede comprar el baculo");
            }
        } else {
            int capaIndex = index - baculos.length;
            if (capaIndex >= 0 && capaIndex < capas.length) {
                int precioCapa = getPrecioCapa(capaIndex);
                if (mago.getMonedas() >= precioCapa) {
                    mago.setCapa(capas[capaIndex]);
                    mago.setMonedas(-precioCapa);
                    System.out.println("¡Capa adquirida!");
                } else {
                    System.out.println("No tienes suficientes monedas.");
                }
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
}