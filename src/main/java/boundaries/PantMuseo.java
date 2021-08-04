package boundaries;

import javax.swing.*;

public class PantMuseo extends Pantalla {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;

    public PantMuseo() {
        super("Pantalla Museo", 400, 300);
    }

    public void mostrarCantidadVisitantes(String cantidadVisitantes, String limiteVisitantes) {
        cantidadLabel.setText(cantidadVisitantes);
        limiteLabel.setText(limiteVisitantes);
        mostrarPantalla(mainPanel);
    }
}
