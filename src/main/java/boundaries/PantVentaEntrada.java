package boundaries;

import entities.Tarifa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PantVentaEntrada extends Pantalla {
    public JTabbedPane tabbedPane;
    public JTable tarifasTable;
    public JRadioButton incluirServicioGuiaRadioButton;
    public JRadioButton noIncluirServicioGuiaRadioButton;
    public JButton siguienteButton1;
    public JButton siguienteButton2;
    public JButton cancelarButton1;
    public JButton cancelarButton2;
    public JButton cancelarButton3;
    public JButton anteriorButton1;
    public JButton anteriorButton2;
    public JButton confirmarButton;
    public JSpinner cantidadSpinner;
    public JPanel MainPanel;
    public JLabel cantidadLabel;
    public JLabel montoLabel;
    public JLabel totalLabel;
    public JLabel disponiblesLabel;

    public PantVentaEntrada() {
        super("Venta Entrada", 500, 350);

        //Agrupar radioButtons
        ButtonGroup bg = new ButtonGroup();
        bg.add(incluirServicioGuiaRadioButton);
        bg.add(noIncluirServicioGuiaRadioButton);

        //Deshabilitar botones
        siguienteButton1.setEnabled(false);
        siguienteButton2.setEnabled(false);

        //Limitar valores del cantidadSpinner
        SpinnerModel sm = new SpinnerNumberModel(0, 0, null, 1);
        cantidadSpinner.setModel(sm);

        //Posicionar el tabbedPane
        MainPanel.setLayout(null);
        tabbedPane.setLocation(0, -25);
        tabbedPane.setSize(500, 350);
    }

    public void habilitarPantalla() {
        mostrarPantalla(MainPanel);
    }

    public void mostrarTarifasVigentes(List<Tarifa> tarifas) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "TIPO ENTRADA", "TIPO VISITA",
                "MONTO", "MONTO ADICIONAL GUIA"}, 0);
        for (Tarifa tarifa : tarifas) {
            model.addRow(new Object[]{
                    tarifa.getId(),
                    tarifa.getTipoEntrada().getNombre(),
                    tarifa.getTipoVisita().getNombre(),
                    tarifa.getMonto(),
                    tarifa.getMontoAdicionalGuia()});
        }
        tarifasTable.setModel(model);
    }

    public void mostrarEntradasDisponibles(String cantidadDispobible) {
        disponiblesLabel.setText(cantidadDispobible);
    }

    public void mostrarDetalleVenta(String cant, String monto, String total) {
        cantidadLabel.setText(cant);
        montoLabel.setText("$" + monto);
        totalLabel.setText("$" + total);
    }
}