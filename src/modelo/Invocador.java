package modelo;

public class Invocador extends Mago {
    int cantCriaturas = 0;

    //Empieza el objeto modelo.HechizeroElemental, y setea la energia magica correspondiente.
    public Invocador(String nombre) {
        super(40, nombre,"Invocador");
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
    public boolean invocar() {
        if (getNivel() > 20) {
            crearCriaturas();
            setNivel(-20);
            return true;
        }
        return false;
    }
}

