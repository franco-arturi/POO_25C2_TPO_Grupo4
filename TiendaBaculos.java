
public class TiendaBaculos {
    private Baculo[] baculo = new Baculo[5];

    public void crearCatalogo(){
        baculo[0] = new Baculo(100,5,"Báculo de Roble Antiguo");
        baculo[1] = new Baculo(250,10,"Báculo de Cristal Arcano");
        baculo[2] = new Baculo(600,15,"Báculo de Cristal Arcano");
        baculo[3] = new Baculo(1200,20,"Báculo del Vacío Silente");
        baculo[4] = new Baculo(2500,25,"Báculo del Archimago Supremo");
    }

    public void mostrarBaculos(){
        for (int i = 0; i < baculo.length; i++) {
            Baculo b = baculo[i];
            System.out.println("[" + i + "] ✦ " + b.getNombre());
            System.out.println("    🧪 Poder mágico : " + b.getPoderBaculo());
            System.out.println("    💰 Precio       : $" + b.getPrecio());
            System.out.println("-----------------------------------");
        }
    }

    public Baculo comprarBaculo(int index){
        return baculo[index];
    }


}
