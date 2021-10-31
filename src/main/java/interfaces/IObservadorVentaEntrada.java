package interfaces;

import java.time.LocalDateTime;

public interface IObservadorVentaEntrada {
    public void actualizarCantVisitantes(LocalDateTime fechaHora, int cantVisitantes, int limiteSede);
}
