package modelo;

public class Ilusionista extends Mago {

    //Empieza el objeto modelo.Ilusionista, y setea la energia magica correspondiente.
    public Ilusionista(String nombre) {
        super(20, nombre,"Ilusionista");
    }

    //Setea el poder Magico del hechizero especificamente.

    public int getPoderMagico() {
        return (baculo.getPoderBaculo() + energiaMagica)*2;
    }


}

