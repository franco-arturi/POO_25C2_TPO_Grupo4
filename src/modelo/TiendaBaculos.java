package modelo;

/*
* No puedo mostrar cosas por pantalla, ya que ese es el rol de la vista.
* Lo que deberia hacer es prestar los metodos necesarios para que el controlador
* permita un correcto flujo del juego.
* Es decir, cuando queremos mostrar los baculos, en vez de imprimirlo le podria mandar la lista de baculos.
* En comprar, sacariamos el system.out y le dejariamos la logica de la compra solamente, devolviendo un estado quizas.
*
* */
public class TiendaBaculos {
    private Baculo[] baculos = new Baculo[3];
    private Capa[] capas = new Capa[2];
     private Escudo[] escudos = new Escudo[1];


    public void crearCatalogoBaculos(){
        baculos[0] = new Baculo(100,50,"Báculo Elemental",2);
        baculos[1] = new Baculo(250,150,"Báculo Resonancia",5);
        baculos[2] = new Baculo(600,300,"Báculo Ancestral",8);

    }

    public void crearCatalogoCapas(){
        capas[0]= new CapaInvisibilidad();
        capas[1]= new CapaRecuperacion();

    }
    public void crearCatalogoEscudos() {
        escudos[0] = new EscudoDefensivo();
    }

    public Baculo[] getBaculos(){
        return baculos;
    }

    public Capa[] getCapas(){
        return capas;
    }
    
    public Escudo[] getEscudos() {
        return escudos;
    }

    public int buscarIndiceBaculoPorNombre(String nombreBuscado) {
        for (int i = 0; i < baculos.length; i++) {
            Baculo b = baculos[i];
            if (b != null && b.getNombre().equals(nombreBuscado)) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    public int buscarIndiceCapaPorNombre(String nombreCapa) {
        for (int i = 0; i < capas.length; i++) {
            Capa c = capas[i];
            if (c != null && c.getNombre().equals(nombreCapa)) {
                return i;
            }
        }
        return -1;
    }

    public boolean comprarBaculo(String nomBac, Mago mago){
        int indice = buscarIndiceBaculoPorNombre(nomBac);
        if(mago.puedeComprar(baculos[indice])){
            mago.comprar(baculos[indice]);
            return true;
        }
        return false;
    }

    public boolean comprarCapa(String nomCapa, Mago mago){
        int indice = buscarIndiceCapaPorNombre(nomCapa);
        if(mago.puedeComprarCapa(capas[indice])){
            mago.comprarCapa(capas[indice]);
            return true;
        }
        return false;

    }

   public boolean comprarEscudo(int indice, Mago mago) {
    // Definí el precio del escudo (puedes ajustar el valor según tu lógica)
    int precio = 500; // Por ejemplo, 500 monedas para el escudo defensivo

    if (indice >= 0 && indice < escudos.length) {
        if (mago.getMonedas() >= precio) {
            mago.equiparEscudo(escudos[indice]);
            // Descontar el precio del escudo
            // Si no tienes un setter, podés restar así:
            // mago.monedas -= precio;
            // Pero lo ideal es tener un setter:
            mago.setMonedas(mago.getMonedas() - precio);
            return true;
        }
    }
    return false;
    }
}
