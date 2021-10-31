package boundaries;

import interfaces.IObservadorVentaEntrada;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PantSala extends PantallasMuseoSalas implements IObservadorVentaEntrada {
    private JLabel limiteLabel;
    private JLabel cantidadLabel;
    private JPanel mainPanel;
    private JLabel fechaHoraLabel;

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

    @Override
    public void actualizarCantVisitantes(LocalDateTime fechaHora, int cantVisitantes, int limiteSede) {
        String fechaHoraFormat = fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));
        fechaHoraLabel.setText(fechaHoraFormat);
        cantidadLabel.setText(String.valueOf(cantVisitantes));
        limiteLabel.setText(String.valueOf(limiteSede));
    }
}
