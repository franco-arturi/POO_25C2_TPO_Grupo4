package vista;

import DTO.DueloDto;
import DTO.EnemigoDto;
import controlador.JuegoControlador;
import modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VistaCombate extends JFrame {

    private JLabel lblNombreEnemigo;
    private JLabel lblPoderEnemigo;
    private JTable tablaCombate;
    private DefaultTableModel modeloTabla;
    private JButton btnIniciar;
    private JButton btnVolver;

    public VistaCombate() {
        setTitle("Vista de Combate");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Panel de información del enemigo
        DueloDto duelo = JuegoControlador.getDuelo();

        JPanel panelInfo = new JPanel(new GridLayout(2, 1));
        lblNombreEnemigo = new JLabel("Enemigo: Poder "+ duelo.getPoderEnemigo());
        lblPoderEnemigo = new JLabel("Vida inicial: " + duelo.getVidaEnemigo());
        panelInfo.add(lblNombreEnemigo);
        panelInfo.add(lblPoderEnemigo);

        // Tabla de combate
        modeloTabla = new DefaultTableModel(new Object[]{"Vida Mago", "Vida Enemigo"}, 0);
        tablaCombate = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaCombate);

        // Botón de combate
        btnIniciar = new JButton("Iniciar Combate");
        btnIniciar.addActionListener((ActionEvent e) -> {
//            modeloTabla.setRowCount(0);  // Limpiar tabla
            boolean partida = duelo.getVictoria();
            int[][] historial = duelo.getHistorial();
            int cont = 0;
            while(historial[cont][0]>0 && historial[cont][1]>0){
                modeloTabla.addRow(new Object[]{historial[cont][0],historial[cont][1]});
                cont++;
            }
            if(partida){
                JOptionPane.showMessageDialog(null, "Duelo ganado!!!");
                if(JuegoControlador.getCantTurnos()>10){
                    VistaVictoria vistaVictoria = new VistaVictoria();
                    vistaVictoria.setVisible(true);
                }
                else{
                    VistaPrincipal vis = new VistaPrincipal();
                    vis.setVisible(true);
                }

                dispose();
            }
            else{
                VistaDerrota vis = new VistaDerrota();
                vis.setVisible(true);
                dispose();
            }
        });

        // Botón de volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener((ActionEvent e) -> {
            dispose(); // Cierra esta ventana
        });

        // Panel inferior con ambos botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnIniciar);
        panelBotones.add(btnVolver);

        // Agregar componentes al JFrame
        add(panelInfo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
