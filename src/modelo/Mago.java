package modelo;

import java.lang.invoke.StringConcatFactory;

public abstract class Mago {
    private String tipo;
    private boolean vivo = true;
    private String nombre;
    int experiencia= 10000;
    int puntosVida= 250;
    int vidaAux = 250;
    int energiaMagica;//Cambia el valor base para cada subclase.
    int monedas = 10000;
    Baculo baculo;

    public Mago(int energiaMagica, String nombre, String tipo) {
        this.energiaMagica = energiaMagica;
        this.nombre = nombre;
        baculo = new Baculo(0,1,"Baculo de mala Calidad");
        this.tipo = tipo;
    }


    //Cambia en cada subclase.
    public abstract int getPoderMagico();


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
    public void comprar(Baculo baculoNuevo) {
        baculo = baculoNuevo;
        monedas -= baculoNuevo.getPrecio();
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
        return getPoderMagico();
    }
    public void recibirDaño(int puntosVida){
        this.puntosVida -= puntosVida;
        if(this.puntosVida < 0){
            vivo = false;
        }
    }
    public void victoriaDuelo(int experiencia, int monedas){
        this.experiencia += experiencia;
        this.monedas += monedas;
        this.puntosVida = vidaAux;

    }
    public boolean isVivo() {
        return vivo;
    }
    public boolean puedeComprar(Baculo baculo) {
        return baculo.getPrecio() <= this.monedas;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean subirVida(){
        if (getNivel() > 20) {
            setPuntosVida(100);
            setNivel(-20);
            return true;
    }
        return false;
    }
    public boolean subirEnergia() {
        if (getNivel() > 20) {
            setEnergiaMagica(10);
            setNivel(-20);
            return true;
        }
        return false;
    }
    public String getTipo(){
        return tipo;
    }
    public Baculo getBaculo() {
        return baculo;
    }
}
