package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "RESERVAS_VISITA", schema = "dbo", catalog = "Museo")
public class ReservaVisita {
    private int numero;
    private Sede sede;
    private Integer cantidadAlumnos;
    private Integer cantidadAlumnosConfirmada;
    private LocalDateTime fechaHoraCreacion;
    private LocalDateTime fechaHoraReserva;
    private LocalTime horaInicioReal;
    private LocalTime horaFinReal;
    private List<AsignacionReserva> asignacionesReserva;

    @Id
    @Column(name = "numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "cantidad_alumnos")
    public Integer getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Integer cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    @Basic
    @Column(name = "cantidad_alumnos_confirmada")
    public Integer getCantidadAlumnosConfirmada() {
        return cantidadAlumnosConfirmada;
    }

    public void setCantidadAlumnosConfirmada(Integer cantidadAlumnosConfirmada) {
        this.cantidadAlumnosConfirmada = cantidadAlumnosConfirmada;
    }

    @Basic
    @Column(name = "fecha_hora_creacion")
    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    @Basic
    @Column(name = "fecha_hora_reserva")
    public LocalDateTime getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(LocalDateTime fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    @Basic
    @Column(name = "hora_inicio_real")
    public LocalTime getHoraInicioReal() {
        return horaInicioReal;
    }

    public void setHoraInicioReal(LocalTime horaInicioReal) {
        this.horaInicioReal = horaInicioReal;
    }

    @Basic
    @Column(name = "hora_fin_real")
    public LocalTime getHoraFinReal() {
        return horaFinReal;
    }

    public void setHoraFinReal(LocalTime horaFinReal) {
        this.horaFinReal = horaFinReal;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @OneToMany(mappedBy = "reservaVisita")
    public List<AsignacionReserva> getAsignacionesReserva() {
        return asignacionesReserva;
    }

    public void setAsignacionesReserva(List<AsignacionReserva> asignacionesReserva) {
        this.asignacionesReserva = asignacionesReserva;
    }

    @Override
    public String toString() {
        return "ReservaVisita{" +
                "numero=" + numero +
                ", sede=" + sede +
                ", cantidadAlumnos=" + cantidadAlumnos +
                ", cantidadAlumnosConfirmada=" + cantidadAlumnosConfirmada +
                ", fechaHoraCreacion=" + fechaHoraCreacion +
                ", fechaHoraReserva=" + fechaHoraReserva +
                ", horaInicioReal=" + horaInicioReal +
                ", horaFinReal=" + horaFinReal +
                '}';
    }

    public boolean esSedeActual(Sede sedeActual) {
        return sede == sedeActual;
    }

    public boolean esFechaActual(LocalDate fechaActual) {
        return fechaHoraReserva.toLocalDate().compareTo(fechaActual) == 0;
    }
}
