package boundaries;

import javax.swing.*;

public class PantSala extends Pantalla {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;

    public PantSala() {
        super("Pantalla Sala", 400, 300);
    }

    public void mostrarCantidadVisitantes(String cantidadVisitantes, String limiteVisitantes) {
        cantidadLabel.setText(cantidadVisitantes);
        limiteLabel.setText(limiteVisitantes);
        mostrarPantalla(mainPanel);
    }
}
