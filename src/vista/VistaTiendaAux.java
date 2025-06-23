package vista;

import DTO.BaculoDto;
import DTO.CapaDto;
import DTO.TiendaDto;
import controlador.JuegoControlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTiendaAux extends JFrame {

    private JLabel lblExperiencia;
    private JLabel lblDuelosGanados;

    private JButton btnAdquirirBaculo;
    private JButton btnVolver;

    private JTable tablaBaculos;
    private JTable tablaCapas;
    private JTable tablaEscudos;

    private DefaultTableModel modeloBaculos;
    private DefaultTableModel modeloCapas;
    private DefaultTableModel modeloEscudos;

    private TiendaDto tienda = JuegoControlador.getTienda();
    private BaculoDto[] baculos = tienda.getBaculos();
    private CapaDto[] capas = tienda.getCapas();

    public VistaTiendaAux() {
        setTitle("Tienda de Báculos y Capas");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: Info del jugador
        JPanel panelInfo = new JPanel(new GridLayout(3, 1));
        lblExperiencia = new JLabel("Experiencia: " + JuegoControlador.getMago().getExperiencia());
        lblDuelosGanados = new JLabel("Duelos ganados: " + (JuegoControlador.getCantTurnos() - 1));

        panelInfo.add(lblExperiencia);
        panelInfo.add(lblDuelosGanados);
        add(panelInfo, BorderLayout.NORTH);

        // Crear tablas y modelos
        String[] columnasBaculos = {"Nombre", "Poder", "Precio","Duelos Faltantes"};
        String[] columnasCapas = {"Nombre", "Precio"};
        String[] columnasEscudos = {"Nombre", "Precio", "Descripción"}; // Agregamos columna Precio

        modeloBaculos = new DefaultTableModel(columnasBaculos, 0);
        modeloCapas = new DefaultTableModel(columnasCapas, 0);
        modeloEscudos = new DefaultTableModel(columnasEscudos, 0);

        for (BaculoDto b : baculos) {
            int turnos = b.getRequisito()-JuegoControlador.getCantTurnos();
            if (turnos<0){
                turnos = 0;
            }
            modeloBaculos.addRow(new Object[]{b.getNombre(), b.getPoder(), b.getPrecio(), turnos});
        }

        for (CapaDto c : capas) {
            modeloCapas.addRow(new Object[]{c.getNombre(), c.getPrecio()});
        }

        // Agregar escudos fijos con precio y descripción
        modeloEscudos.addRow(new Object[]{"Escudo Defensivo", 500, "Bloquea 20% del daño recibido"});

        tablaBaculos = new JTable(modeloBaculos);
        tablaCapas = new JTable(modeloCapas);
        tablaEscudos = new JTable(modeloEscudos);

        // Cuando se selecciona un báculo, se deseleccionan capa y escudo
        tablaBaculos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                tablaCapas.clearSelection();
                tablaEscudos.clearSelection();
            }
        });

        // Cuando se selecciona una capa, se deseleccionan báculo y escudo
        tablaCapas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                tablaBaculos.clearSelection();
                tablaEscudos.clearSelection();
            }
        });

        // Cuando se selecciona un escudo, se deseleccionan báculo y capa
        tablaEscudos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                tablaBaculos.clearSelection();
                tablaCapas.clearSelection();
            }
        });

        JScrollPane scrollBaculos = new JScrollPane(tablaBaculos);
        JScrollPane scrollCapas = new JScrollPane(tablaCapas);
        JScrollPane scrollEscudos = new JScrollPane(tablaEscudos);

        JPanel panelTablas = new JPanel(new GridLayout(3, 1));
        panelTablas.add(scrollBaculos);
        panelTablas.add(scrollCapas);
        panelTablas.add(scrollEscudos);
        add(panelTablas, BorderLayout.CENTER);

        // Botón de comprar
        btnAdquirirBaculo = new JButton("Comprar Seleccionado");
        btnAdquirirBaculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaB = tablaBaculos.getSelectedRow();
                int filaC = tablaCapas.getSelectedRow();
                int filaE = tablaEscudos.getSelectedRow();

                if (filaB != -1) {
                    String nombre = (String) modeloBaculos.getValueAt(filaB, 0);
                    if(JuegoControlador.comprarBaculo(nombre)){
                        JOptionPane.showMessageDialog(null, "Báculo " + nombre + " comprado exitosamente");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No tienes el dinero o el nivel para comprar el báculo.");
                    }
                } else if (filaC != -1) {
                    String nombre = (String) modeloCapas.getValueAt(filaC, 0);
                    if(JuegoControlador.comprarCapa(nombre)){
                        JOptionPane.showMessageDialog(null, "Capa " + nombre + " comprada exitosamente");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No tienes el dinero para comprar la capa.");
                    }
                } else if (filaE != -1) {
                    int precio = Integer.parseInt(modeloEscudos.getValueAt(filaE, 1).toString());                    if(JuegoControlador.comprarEscudo(filaE)){
                        JOptionPane.showMessageDialog(null, "Escudo equipado exitosamente por $" + precio);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo equipar el escudo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccioná un báculo, una capa o un escudo para comprar.");
                }
            }
        });

        // Botón Volver
        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaPrincipal vistaPrincipal = new VistaPrincipal();
                vistaPrincipal.setVisible(true);
                dispose(); // Cierra la tienda
            }
        });

        // Panel inferior con ambos botones
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.add(btnAdquirirBaculo);
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);
    }
}