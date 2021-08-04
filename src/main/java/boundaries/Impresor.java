package boundaries;

import entities.Entrada;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Impresor {

    public void imprimirEntrada(Entrada entrada) {
        int num = entrada.getNumero();
        String sede = entrada.getSede().getNombre();
        int tarifa = entrada.getTarifa().getId();
        String tEnt = entrada.getTarifa().getTipoEntrada().getNombre();
        String tVis = entrada.getTarifa().getTipoVisita().getNombre();
        LocalDate fecha = entrada.getFechaVenta();
        LocalTime hora = entrada.getHoraVenta();
        double monto = entrada.getMonto();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaParseada = hora.format(dtf);

        System.out.println("\n* * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                     *");
        System.out.println("*    Entrada: " + num + "                     *");
        System.out.println("*    Sede: " + sede + "              *");
        System.out.println("*    Tarifa: " + tarifa + " (" + tEnt + ", " + tVis + ")    *");
        System.out.println("*    Fecha venta: " + fecha + "          *");
        System.out.println("*    Hora venta: " + horaParseada + "             *");
        System.out.println("*    Monto: $" + monto + "                    *");
        System.out.println("*                                     *");
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
    }
}
