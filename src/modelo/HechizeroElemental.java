package modelo;

public class HechizeroElemental extends Mago {

    //Empieza el objeto modelo.HechizeroElemental, y setea la energia magica correspondiente.
    public HechizeroElemental(String nombre) {
        super(10000, nombre,"Elemental");
    }



    public int getPoderMagico() {
        return (baculo.getPoderBaculo() * energiaMagica)/2;
    }
}
