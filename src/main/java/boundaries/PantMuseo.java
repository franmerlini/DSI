package boundaries;

import javax.swing.*;

public class PantMuseo extends PantallasMuseoSalas {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;

    public PantMuseo() {
        super("Pantalla Museo", 400, 200, 100, 20);
    }

    public void mostrarCantidadVisitantes(String cantidadVisitantes, String limiteVisitantes) {
        cantidadLabel.setText(cantidadVisitantes);
        limiteLabel.setText(limiteVisitantes);
    }

    public void habilitarPantalla() {
        mostrarPantalla(mainPanel);
    }
}
