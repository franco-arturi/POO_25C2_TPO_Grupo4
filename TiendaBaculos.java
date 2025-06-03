
public class TiendaBaculos {
    private Baculo[] baculos = new Baculo[5];

    public void crearCatalogo(){
        baculos[0] = new Baculo(100,5,"Báculo de Roble Antiguo");
        baculos[1] = new Baculo(250,10,"Báculo de Cristal Arcano");
        baculos[2] = new Baculo(600,15,"Báculo de Cristal Arcano");
        baculos[3] = new Baculo(1200,20,"Báculo del Vacío Silente");
        baculos[4] = new Baculo(2500,25,"Báculo del Archimago Supremo");
    }

    public void mostrarBaculos(){
        for (int i = 0; i < baculos.length; i++) {
            Baculo b = baculos[i];
            System.out.println("[" + i + "] ✦ " + b.getNombre());
            System.out.println("    🧪 Poder mágico : " + b.getPoderBaculo());
            System.out.println("    💰 Precio       : $" + b.getPrecio());
            System.out.println("-----------------------------------");
        }
    }

    public void comprarBaculo(int index, Mago mago){
        if(mago.puedeComprar(baculos[index])){
            mago.comprar(baculos[index]);
        }
        else{
            System.out.println("El Mago no puede comprar el baculo");
        }
    }


}
