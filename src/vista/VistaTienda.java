package vista;

import DTO.BaculoDto;
import controlador.JuegoControlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaTienda extends JFrame {

    private JLabel lblExperiencia;
    private JLabel lblDuelosGanados;
    private JLabel lblBaculosDisponibles;
    private JLabel lblCapasDisponibles;
    private JLabel lblDuelosFaltantes;

    private JButton btnAdquirirBaculo;
    private JButton btnVolver;

    private JTable tablaBaculos;
    private DefaultTableModel modeloTabla;

    public VistaTienda() {
        //Seteo de lo basico.
        setTitle("Tienda de Báculos y Capas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: Info del jugador
        JPanel panelInfo = new JPanel(new GridLayout(5, 1));
        lblExperiencia = new JLabel("Experiencia: " + JuegoControlador.getMago().getExperiencia());
        lblDuelosGanados = new JLabel("Duelos ganados: " + (JuegoControlador.getCantTurnos() - 1));
        lblBaculosDisponibles = new JLabel("Báculos disponibles: ");
        lblCapasDisponibles = new JLabel("Capas disponibles: 0");
        lblDuelosFaltantes = new JLabel("Duelos faltantes para adquirir un báculo: X");

        panelInfo.add(lblExperiencia);
        panelInfo.add(lblDuelosGanados);
        panelInfo.add(lblBaculosDisponibles);
        panelInfo.add(lblCapasDisponibles);
        panelInfo.add(lblDuelosFaltantes);


        String[] columnas = {"Nombre", "Poder", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaBaculos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaBaculos);

//        for (BaculoDto baculo : baculosDisponibles) {
//            Object[] fila = {baculo.getNombre(), baculo.getPoder(), baculo.getPrecio()};
//            modeloTabla.addRow(fila);
//        }

        // Panel inferior: botones
        JPanel panelBotones = new JPanel();
        btnAdquirirBaculo = new JButton("Comprar báculo seleccionado");
        btnVolver = new JButton("Volver");

        panelBotones.add(btnAdquirirBaculo);
        panelBotones.add(btnVolver);

        // Acción del botón de comprar báculo
        btnAdquirirBaculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tablaBaculos.getSelectedRow();
                if (fila >= 0) {
                    String nombre = (String) modeloTabla.getValueAt(fila, 0);
                    int poder = (int) modeloTabla.getValueAt(fila, 1);
                    int precio = (int) modeloTabla.getValueAt(fila, 2);
                    JOptionPane.showMessageDialog(null,
                            "Compraste el báculo " + nombre + " (Poder: " + poder + ", Precio: " + precio + ")");
                    // Acá podrías invocar algo como: JuegoControlador.comprarBaculo(nombre);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccioná un báculo de la tabla.");
                }
            }

        });
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                VistaPrincipal vista = new VistaPrincipal();
                vista.setVisible(true);
                dispose();
            }
        });

        // Armado final
        add(panelInfo, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}