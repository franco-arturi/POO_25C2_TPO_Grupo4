public class Invocador extends Mago {
    int cantCriaturas = 0;

    //Empieza el objeto HechizeroElemental, y setea la energia magica correspondiente.
    public Invocador() {
        super(40);
    }
    //Setea el poder Magico del hechizero especificamente.

    public int getPoderMagico() {
        return (baculo.getPoderBaculo() + energiaMagica + cantCriaturas);
    }
    public void crearCriaturas() {
        cantCriaturas++;
    }
    public int getCantCriaturas() {
        return cantCriaturas;
    }
}

