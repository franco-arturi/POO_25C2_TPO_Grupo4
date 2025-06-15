package vista;

import controlador.JuegoControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame {

    private JButton btnDuelo;
    private JButton btnTienda;
    private JButton btnSubirNivel;
    private JButton btnEstadisticas;
    private JLabel labelTurno;


    public VistaPrincipal() {
        setTitle("Vista Principal");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(2,2,10,10));
        btnDuelo = new JButton("Duelo");
        btnTienda = new JButton("Abrir Tienda");
        btnSubirNivel = new JButton("Subir de Nivel");
        btnEstadisticas = new JButton("Ver Estadísticas");

        panelBotones.add(btnDuelo);
        panelBotones.add(btnTienda);
        panelBotones.add(btnSubirNivel);
        panelBotones.add(btnEstadisticas);

        JPanel panelTurno = new JPanel();
        labelTurno = new JLabel("Turno actual: " + JuegoControlador.getCantTurnos());
        labelTurno.setFont(new Font("Arial", Font.BOLD, 16));
        labelTurno.setText("Turno actual: " + JuegoControlador.getCantTurnos());
        panelTurno.add(labelTurno);


        //DUELO
        btnDuelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaCombate visCom = new VistaCombate();
                visCom.setVisible(true);
            }
        });

        btnTienda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaTienda vista = new VistaTienda();
                vista.setVisible(true);
                dispose();
            }
        });

        btnSubirNivel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Subir Nivel!!!");
                VistaMejora vista = new VistaMejora(JuegoControlador.getTipoMago());
                vista.setVisible(true);
                dispose();
            }
        });


        btnEstadisticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulación de estadísticas (modificá esto según tu DTO o controlador)
                String estadisticas = "Nombre: "+ JuegoControlador.getMago().getNombre() + "\nVida: "+JuegoControlador.getMago().getPuntosVida()+"\nEnergia Magia: "+JuegoControlador.getMago().getEnergiaMagica()+
                        "\nMonedas: "+JuegoControlador.getMago().getMonedas()+"\nExperiencia: "+JuegoControlador.getMago().getExperiencia()+"\nBaculo: "+JuegoControlador.getMago().getNombreBaculo()+"\n        Poder: "+JuegoControlador.getMago().getPoderBaculo();
                JOptionPane.showMessageDialog(null, estadisticas, "Estadísticas del mago", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panelPrincipal.add(panelTurno, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        this.add(panelPrincipal);
    }
}

