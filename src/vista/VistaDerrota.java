package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaDerrota extends JFrame {

    public VistaDerrota() {
        setTitle("¡Has Perdido!");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Etiqueta con ícono y mensaje
        JLabel etiquetaMensaje = new JLabel("¡Has sido derrotado!", JLabel.CENTER);
        etiquetaMensaje.setFont(new Font("Serif", Font.BOLD, 24));
        etiquetaMensaje.setForeground(Color.RED);

        // Ícono triste
        JLabel etiquetaIcono = new JLabel();
        etiquetaIcono.setHorizontalAlignment(JLabel.CENTER);
        etiquetaIcono.setIcon(UIManager.getIcon("OptionPane.errorIcon")); // ícono de error rojo

        // Botón para volver al menú o cerrar
        JButton botonVolver = new JButton("Salir...");
        botonVolver.setFocusPainted(false);
        botonVolver.setBackground(new Color(200, 50, 50));
        botonVolver.setForeground(Color.WHITE);
        botonVolver.setFont(new Font("SansSerif", Font.BOLD, 14));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra el programa por completo
            }
        });


        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Color.WHITE);
        panelCentro.add(etiquetaIcono, BorderLayout.CENTER);
        panelCentro.add(etiquetaMensaje, BorderLayout.SOUTH);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(botonVolver);

        add(panelCentro, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}
