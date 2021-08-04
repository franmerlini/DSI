package boundaries;

import javax.swing.*;

public class PantSala extends PantallasMuseoSalas {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;

    public PantSala() {
        super("Pantalla Sala", 400, 200, 1050, 20);
    }

    public void mostrarCantidadVisitantes(String cantidadVisitantes, String limiteVisitantes) {
        cantidadLabel.setText(cantidadVisitantes);
        limiteLabel.setText(limiteVisitantes);
    }

    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }
}
