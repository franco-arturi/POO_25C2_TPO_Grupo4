import vista.VistaMenuInicial;


public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VistaMenuInicial vista = new VistaMenuInicial();
                vista.setVisible(true);

            }
        });
    }
}