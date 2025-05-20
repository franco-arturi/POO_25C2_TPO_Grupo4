public class Mago {
    int poderMagico= 0;//Cambia como lo calculamos en cada subclase.
    int experiencia= 0;
    int puntosVida= 250;
    int energiaMagica;//Cambia el valor base para cada subclase.
    int monedas = 10000;
    Baculo baculo;

    public Mago(int energiaMagica) {
        this.energiaMagica = energiaMagica;
        baculo = new Baculo(0,1,"Baculo de mala Calidad");
    }


    //Cambia en cada subclase.
    public void setPoderMagico() {
    }


    //Iguales para todas las subclases.
    public void setNivel(int exp) {
        experiencia = experiencia + exp;
    }
    public void setMonedas(int obtenidas){
        monedas = monedas + obtenidas;
    }
    public void setPuntosVida(int puntos) {
        puntosVida = puntosVida + puntos;
    }
    public void setBaculo(Baculo baculoNuevo) {
        baculo = baculoNuevo;
        setMonedas(-baculo.getPrecio());
    }
    public int getPuntosVida(){
        return puntosVida;
    }
    public int getMonedas(){
        return monedas;
    }
    public void setEnergiaMagica(int cant) {
        energiaMagica = energiaMagica + cant;
    }
    public int getNivel(){
        return experiencia;
    }
    public int getEnergiaMagica(){
        return energiaMagica;
    }
    public int atacar() {
        setPoderMagico();
        return poderMagico;
    }
}
