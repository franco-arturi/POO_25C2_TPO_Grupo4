package modelo;

public class EscudoDefensivo extends Escudo{

    public EscudoDefensivo() {
        this.nombre = "Escudo Defensivo";
    }
    
     @Override
    public int bloquearDaño(int danio) {
        return (int)(danio * 0.8); // Bloquea 20%
    }
    
}
