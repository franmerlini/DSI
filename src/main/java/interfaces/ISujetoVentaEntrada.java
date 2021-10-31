package interfaces;

public interface ISujetoVentaEntrada {
    public void suscribir(IObservadorVentaEntrada observador);

    public void desuscribir(IObservadorVentaEntrada observador);

    public void notificar();
}
