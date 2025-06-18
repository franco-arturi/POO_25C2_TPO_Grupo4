package vista;

import controlador.JuegoControlador;

import javax.swing.*;
import java.awt.*;

public class VistaMenuInicialAux extends JFrame {

    private JTextField campoNombre;
    private JButton botonIlusionista;
    private JButton botonInvocador;
    private JButton botonElemental;

    public String getNombreJugador() {
        return campoNombre.getText();
    }

    public VistaMenuInicialAux() {
        setTitle("Menú Inicial");
        setSize(600, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuentePixel = new Font("Monospaced", Font.BOLD, 18);
        Color bordeOscuro = new Color(51, 25, 0);
        Color campoFondo = new Color(255, 230, 160);

        JPanel panelPrincipal = new PanelConFondo("/vista/fondo_pixelado.png");
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setOpaque(false);

        // Nombre del jugador
        JPanel panelNombre = new JPanel(new FlowLayout());
        panelNombre.setOpaque(false);
        JLabel etiquetaNombre = new JLabel("Nombre del Jugador:");
        etiquetaNombre.setFont(fuentePixel);
        etiquetaNombre.setForeground(bordeOscuro);

        campoNombre = new JTextField(15);
        campoNombre.setFont(fuentePixel);
        campoNombre.setBackground(campoFondo);
        campoNombre.setForeground(bordeOscuro);
        campoNombre.setBorder(BorderFactory.createLineBorder(bordeOscuro, 2));

        panelNombre.add(etiquetaNombre);
        panelNombre.add(campoNombre);

        // Botones
        botonIlusionista = new JButton("Ilusionista");
        botonInvocador = new JButton("Invocador");
        botonElemental = new JButton("Elemental");

        JButton[] botones = {botonIlusionista, botonInvocador, botonElemental};
        for (JButton boton : botones) {
            boton.setFont(fuentePixel);
            boton.setBackground(new Color(176, 80, 32));
            boton.setForeground(Color.BLACK);
            boton.setFocusPainted(false);
            boton.setPreferredSize(new Dimension(150, 50));
            boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bordeOscuro, 4),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
        }

        // Panel con clases
        JPanel panelClases = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelClases.setOpaque(false);
        panelClases.add(crearPanelClase("/vista/icono_ilusionista.png", botonIlusionista));
        panelClases.add(crearPanelClase("/vista/icono_invocador.png", botonInvocador));
        panelClases.add(crearPanelClase("/vista/icono_elemental.png", botonElemental));

        // Agregar espaciado real
        
        // Contenedor intermedio para control de espaciado
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setOpaque(false);
        panelCentro.add(Box.createVerticalStrut(80));  // espacio alto
        panelCentro.add(panelNombre);
        panelCentro.add(Box.createVerticalStrut(30));
        panelCentro.add(panelClases);

        panelPrincipal.add(panelCentro);
    

        add(panelPrincipal);

        // Acciones
        //Esto es lo que creamos sin fines esteticos, donde se llaman los metodos del controlador.
        //T0do lo demas es con fines esteticos.
        botonElemental.addActionListener(e -> {
            JuegoControlador.crearMagoElemental(getNombreJugador());
            VistaPrincipal vista = new VistaPrincipal();
            vista.setVisible(true);
            dispose();
        });
        botonIlusionista.addActionListener(e -> {
            JuegoControlador.crearMagoIlusionista(getNombreJugador());
            VistaPrincipal vista = new VistaPrincipal();
            vista.setVisible(true);
            dispose();
        });
        botonInvocador.addActionListener(e -> {
            JuegoControlador.crearMagoInvocador(getNombreJugador());
            VistaPrincipal vista = new VistaPrincipal();
            vista.setVisible(true);
            dispose();
        });
    }

    //Esto es estetico, creado en su mayoria con chatgpt.
    private JPanel crearPanelClase(String rutaImagen, JButton boton) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        JLabel icono = new JLabel(escalarIcono(rutaImagen, 64, 64));
        icono.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(icono);
        panel.add(Box.createVerticalStrut(10));
        panel.add(boton);
        return panel;
    }

    private ImageIcon escalarIcono(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image img = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    // Clase personalizada para fondo
    class PanelConFondo extends JPanel {
        private Image fondo;

        public PanelConFondo(String ruta) {
            fondo = new ImageIcon(getClass().getResource(ruta)).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}