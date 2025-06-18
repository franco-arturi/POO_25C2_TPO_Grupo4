import vista.VistaMenuInicial;
import vista.VistaMenuInicialAux;


public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VistaMenuInicialAux vista = new VistaMenuInicialAux();
                vista.setVisible(true);

            }
        });
    }
}