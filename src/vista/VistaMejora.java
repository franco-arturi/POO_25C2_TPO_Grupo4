package vista;

import controlador.JuegoControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMejora extends JFrame {
    private JButton btnMejorarVida;
    private JButton btnMejorarEnergia;
    private JButton btnCrearInvocacion;
    private JButton btnVolver;
    private String tipoMago;
    public VistaMejora(String tipoMago) {
        this.tipoMago = tipoMago;

        setTitle("Subir de Nivel");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 10, 10));

        btnMejorarVida = new JButton("Mejorar Vida");
        btnMejorarEnergia = new JButton("Mejorar Energía Mágica");
        btnCrearInvocacion = new JButton("Crear Invocación");
        btnVolver = new JButton("Volver");


        panelBotones.add(btnMejorarVida);
        panelBotones.add(btnMejorarEnergia);

        btnMejorarVida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(JuegoControlador.subirVida()){
                    JOptionPane.showMessageDialog(null, "Vida subida con exito!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No tienes el suficiente nivel!");
                }
            }
        });

        btnMejorarEnergia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(JuegoControlador.subirEnergia()){
                    JOptionPane.showMessageDialog(null, "Energia subida con exito!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No tienes el suficiente nivel!");
                }
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaPrincipal vista = new VistaPrincipal();
                vista.setVisible(true);
                dispose();
            }
        });


        if (tipoMago.equalsIgnoreCase("Invocador")) {
            btnCrearInvocacion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(JuegoControlador.crearInvocacion()){
                        JOptionPane.showMessageDialog(null, "Invocacion creada con exito!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Nivel insuficiente!");
                    }
                }
            });
            panelBotones.add(btnCrearInvocacion);
        }


        panelBotones.add(btnVolver);

        add(panelBotones);
    }
}
