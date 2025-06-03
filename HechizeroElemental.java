public class HechizeroElemental extends Mago {

    //Empieza el objeto HechizeroElemental, y setea la energia magica correspondiente.
    public HechizeroElemental() {
        super(10);
    }
    //Setea el poder Magico del hechizero especificamente.


    public int getPoderMagico() {
        return (baculo.getPoderBaculo() * energiaMagica)/2;
    }
}
