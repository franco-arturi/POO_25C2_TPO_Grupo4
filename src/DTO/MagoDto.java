package DTO;

import modelo.Mago;

public class MagoDto {
    String nombre;
    int experiencia;
    int puntosVida;
    int energiaMagica;
    int monedas;
    BaculoDto baculo;
    String capa;


    public MagoDto(Mago mago){
        this.experiencia = mago.getNivel();
        this.puntosVida = mago.getPuntosVida();
        this.energiaMagica = mago.getEnergiaMagica();
        this.monedas = mago.getMonedas();
        this.nombre = mago.getNombre();
        this.baculo = new BaculoDto(mago.getBaculo().getNombre(), mago.getBaculo().getPoderBaculo(),mago.getBaculo().getPrecio(),mago.getBaculo().getDuelosRequeridos());
        this.capa = mago.getCapa();
    }

    public String getNombre() {
        return nombre;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getEnergiaMagica() {
        return energiaMagica;
    }
    public int getMonedas() {
        return monedas;
    }
    public String getNombreBaculo() {
        return baculo.getNombre();
    }
    public int getPoderBaculo(){
        return baculo.getPoder();
    }
    public String getCapa() {
        return capa;
    }




}
