package modelo;

import java.lang.invoke.StringConcatFactory;

public abstract class Mago {
    private String tipo;
    private boolean vivo = true;
    private String nombre;
    int experiencia= 10000;
    int puntosVida= 2500;
    int vidaAux = 250;
    int energiaMagica;//Cambia el valor base para cada subclase.
    int monedas = 10000;
    Baculo baculo;
    public int duelosGanados=1;
    private Capa capa ;
    Escudo escudo;

    public Mago(int energiaMagica, String nombre, String tipo) {
        this.energiaMagica = energiaMagica;
        this.nombre = nombre;
        baculo = new Baculo(0,1,"Baculo de mala Calidad",0);
        this.tipo = tipo;
        this.capa = new CapaBase();
    }


    //Cambia en cada subclase.
    public abstract int getPoderMagico();


    //Iguales para todas las subclases.
    public void setNivel(int exp) {
        experiencia = experiencia + exp;
    }
    public void setPuntosVida(int puntos) {
        puntosVida = vidaAux;
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
        return capa.modificarDañoAtaque(getPoderMagico());
    }
    public void recibirDaño(int puntosVida){
    int danio = puntosVida;
    if (escudo != null) {
        danio = escudo.bloquearDaño(danio);
    }
    danio = capa.modificadorDañoEnemigo(danio);
    this.puntosVida -= danio;
    if(this.puntosVida < 0){
        vivo = false;
    }
}
    public void victoriaDuelo(int experiencia, int monedas){
        this.experiencia += experiencia;
        this.monedas += monedas;
        capa.modificadorFinalDuelo(this);
        this.duelosGanados++;

    }
    public boolean isVivo() {
        return vivo;
    }
    public boolean puedeComprar(Baculo baculo) {
        return baculo.getPrecio() <= this.monedas && baculo.getDuelosRequeridos()<=this.duelosGanados;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean subirVida(){
        if (getNivel() > 20) {
            setPuntosVida(100);
            this.vidaAux = this.puntosVida ;
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
    public void curar(){
        this.puntosVida = vidaAux;
    }
    public boolean puedeComprarCapa(Capa capa){
        return capa.getPrecio() <= this.monedas;
    }
    public void comprarCapa(Capa capa){
        this.capa = capa;
        this.monedas -= capa.getPrecio();
    }
    public String getCapa() {
        return capa.getNombre();
    }

    public Capa getCapaObjeto() {
        return capa;
    }

    public void equiparEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public Escudo getEscudo() {
        return escudo;
    }

        public void setMonedas(int monedas) {
        this.monedas = monedas;
    }


}
