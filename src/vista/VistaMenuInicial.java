package vista;

import controlador.JuegoControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenuInicial extends JFrame {
    public String getNombreJugador() {
        return campoNombre.getText();
    }

    private JTextField campoNombre;
    private JButton botonIlusionista;
    private JButton botonInvocador;
    private JButton botonElemental;

    public VistaMenuInicial(){
        setTitle("Menu Inicial");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel etiquetaNombre = new JLabel("Nombre del jugador:");
        campoNombre = new JTextField(20);

        botonElemental = new JButton("Elemental");
        botonIlusionista = new JButton("Ilusionista");
        botonInvocador = new JButton("Invocador");

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelNombre = new JPanel();
        panelNombre.add(etiquetaNombre);
        panelNombre.add(campoNombre);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonIlusionista);
        panelBotones.add(botonInvocador);
        panelBotones.add(botonElemental);

        panelPrincipal.add(panelNombre, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        add(panelPrincipal);


        //BOTONES PARA LA CREACION DE LA CLASE
        botonElemental.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JuegoControlador.crearMagoElemental(getNombreJugador());
                VistaPrincipal vista = new VistaPrincipal();
                vista.setVisible(true);
                //Agregamos un metodo del controlador que cree el tipo de mago que necesitamos.
                dispose();
            }
        });
        botonIlusionista.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JuegoControlador.crearMagoIlusionista(getNombreJugador());
                VistaPrincipal vista = new VistaPrincipal();
                vista.setVisible(true);
                dispose();
            }
        });
        botonInvocador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JuegoControlador.crearMagoInvocador(getNombreJugador());
                VistaPrincipal vista = new VistaPrincipal();
                vista.setVisible(true);
                dispose();
            }
        });
    }




}
