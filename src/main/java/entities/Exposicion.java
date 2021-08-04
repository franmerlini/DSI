package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "EXPOSICIONES", schema = "dbo", catalog = "Museo")
public class Exposicion {
    private int id;
    private String nombre;
    private Empleado empleado;
    private Sede sede;
    private LocalDate fechaInicio;
    private LocalDate fechaInicioReplanificada;
    private LocalDate fechaFin;
    private LocalDate fechaFinReplanificada;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private List<AsignacionReserva> asignacionesReserva;
    private List<DetalleExposicion> detallesExposicion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fecha_inicio")
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "fecha_inicio_replanificada")
    public LocalDate getFechaInicioReplanificada() {
        return fechaInicioReplanificada;
    }

    public void setFechaInicioReplanificada(LocalDate fechaInicioReplanificada) {
        this.fechaInicioReplanificada = fechaInicioReplanificada;
    }

    @Basic
    @Column(name = "fecha_fin")
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "fecha_fin_replanificada")
    public LocalDate getFechaFinReplanificada() {
        return fechaFinReplanificada;
    }

    public void setFechaFinReplanificada(LocalDate fechaFinReplanificada) {
        this.fechaFinReplanificada = fechaFinReplanificada;
    }

    @Basic
    @Column(name = "hora_apertura")
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    @Basic
    @Column(name = "hora_cierre")
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    @OneToOne
    @JoinColumn(name = "id_empleado_creador", referencedColumnName = "id")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @OneToMany(mappedBy = "exposicion")
    public List<AsignacionReserva> getAsignacionesReserva() {
        return asignacionesReserva;
    }

    public void setAsignacionesReserva(List<AsignacionReserva> asignacionesReserva) {
        this.asignacionesReserva = asignacionesReserva;
    }

    @OneToMany(mappedBy = "exposicion")
    public List<DetalleExposicion> getDetallesExposicion() {
        return detallesExposicion;
    }

    public void setDetallesExposicion(List<DetalleExposicion> detallesExposicion) {
        this.detallesExposicion = detallesExposicion;
    }

    @Override
    public String toString() {
        return "Exposicion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleado=" + empleado +
                ", sede=" + sede +
                ", fechaInicio=" + fechaInicio +
                ", fechaInicioReplanificada=" + fechaInicioReplanificada +
                ", fechaFin=" + fechaFin +
                ", fechaFinReplanificada=" + fechaFinReplanificada +
                ", horaApertura=" + horaApertura +
                ", horaCierre=" + horaCierre +
                '}';
    }

    public boolean esVigente(LocalDate fechaActual) {
        return fechaInicio.compareTo(fechaActual) <= 0 && fechaFin.compareTo(fechaActual) >= 0;
    }

    public int buscarDuracionResumidaObra() {
        int aux = 0;
        for (DetalleExposicion detalleExposicion : detallesExposicion) {
            aux += detalleExposicion.buscarDuracionResumidaObra();
        }
        return aux;
    }
}
