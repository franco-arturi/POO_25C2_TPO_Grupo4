package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaVictoria extends JFrame {

    public VistaVictoria() {
        setTitle("¡Victoria!");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje de felicitación
        JLabel etiquetaMensaje = new JLabel("¡Felicidades, ganaste la partida!", JLabel.CENTER);
        etiquetaMensaje.setFont(new Font("Serif", Font.BOLD, 22));
        etiquetaMensaje.setForeground(new Color(34, 139, 34)); // verde oscuro

        // Ícono de información positivo
        JLabel etiquetaIcono = new JLabel();
        etiquetaIcono.setHorizontalAlignment(JLabel.CENTER);
        etiquetaIcono.setIcon(UIManager.getIcon("OptionPane.informationIcon")); // ícono de información

        // Botón para finalizar
        JButton botonSalir = new JButton("Salir del juego");
        botonSalir.setFocusPainted(false);
        botonSalir.setBackground(new Color(50, 150, 50));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFont(new Font("SansSerif", Font.BOLD, 14));

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa
            }
        });

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Color.WHITE);
        panelCentro.add(etiquetaIcono, BorderLayout.CENTER);
        panelCentro.add(etiquetaMensaje, BorderLayout.SOUTH);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(botonSalir);

        add(panelCentro, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}
