package boundaries;

import interfaces.IObservadorVentaEntrada;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PantMuseo extends PantallasMuseoSalas implements IObservadorVentaEntrada {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;
    private JLabel fechaHoraLabel;

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

    @Override
    public void actualizarCantVisitantes(LocalDateTime fechaHora, int cantVisitantes, int limiteSede) {
        String fechaHoraFormat = fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));
        fechaHoraLabel.setText(fechaHoraFormat);
        cantidadLabel.setText(String.valueOf(cantVisitantes));
        limiteLabel.setText(String.valueOf(limiteSede));
    }
}
