package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ENTRADAS", schema = "dbo", catalog = "Museo")
public class Entrada {
    private int numero;
    private Sede sede;
    private Tarifa tarifa;
    private LocalDate fechaVenta;
    private LocalTime horaVenta;
    private Double monto;

    public Entrada() {
    }

    public Entrada(int numero, Sede sede, Tarifa tarifa, LocalDate fechaVenta, LocalTime horaVenta, Double monto) {
        this.numero = numero;
        this.sede = sede;
        this.tarifa = tarifa;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.monto = monto;
    }

    @Id
    @Column(name = "numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "fecha_venta")
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Basic
    @Column(name = "hora_venta")
    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
    }

    @Basic
    @Column(name = "monto")
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @OneToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @OneToOne
    @JoinColumn(name = "id_tarifa", referencedColumnName = "id")
    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "numero=" + numero +
                ", sede=" + sede +
                ", tarifa=" + tarifa +
                ", fechaVenta=" + fechaVenta +
                ", horaVenta=" + horaVenta +
                ", monto=" + monto +
                '}';
    }

    public boolean esSedeActual(Sede sedeActual) {
        return sede == sedeActual;
    }

    public boolean esFechaActual(LocalDate fechaActual) {
        return fechaVenta.compareTo(fechaActual) == 0;
    }
}
