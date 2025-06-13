public class Ilusionista extends Mago{

    //Empieza el objeto Ilusionista, y setea la energia magica correspondiente.
    public Ilusionista() {
        super(20);
    }

    //Setea el poder Magico del hechizero especificamente.

    public int getPoderMagico() {
        return (baculo.getPoderBaculo() + energiaMagica)*2;
    }


}

