package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OBRAS", schema = "dbo", catalog = "Museo")
public class Obra {
    private int id;
    private String nombre;
    private String descripcion;
    private Empleado empleado;
    private Double alto;
    private Double ancho;
    private Double peso;
    private Double valuacion;
    private LocalDate fechaCreacion;
    private LocalDate fechaPrimerIngreso;
    private String codigoSensor;
    private Integer duracionExtendida;
    private Integer duracionResumida;

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
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "alto")
    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    @Basic
    @Column(name = "ancho")
    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    @Basic
    @Column(name = "peso")
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Basic
    @Column(name = "valuacion")
    public Double getValuacion() {
        return valuacion;
    }

    public void setValuacion(Double valuacion) {
        this.valuacion = valuacion;
    }

    @Basic
    @Column(name = "fecha_creacion")
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "fecha_primer_ingreso")
    public LocalDate getFechaPrimerIngreso() {
        return fechaPrimerIngreso;
    }

    public void setFechaPrimerIngreso(LocalDate fechaPrimerIngreso) {
        this.fechaPrimerIngreso = fechaPrimerIngreso;
    }

    @Basic
    @Column(name = "codigo_sensor")
    public String getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(String codigoSensor) {
        this.codigoSensor = codigoSensor;
    }

    @Basic
    @Column(name = "duracion_extendida")
    public Integer getDuracionExtendida() {
        return duracionExtendida;
    }

    public void setDuracionExtendida(Integer duracionExtendida) {
        this.duracionExtendida = duracionExtendida;
    }

    @Basic
    @Column(name = "duracion_resumida")
    public Integer getDuracionResumida() {
        return duracionResumida;
    }

    public void setDuracionResumida(Integer duracionResumida) {
        this.duracionResumida = duracionResumida;
    }

    @OneToOne
    @JoinColumn(name = "id_empleado_creador", referencedColumnName = "id")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", empleado=" + empleado +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", peso=" + peso +
                ", valuacion=" + valuacion +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaPrimerIngreso=" + fechaPrimerIngreso +
                ", codigoSensor='" + codigoSensor + '\'' +
                ", duracionExtendida=" + duracionExtendida +
                ", duracionResumida=" + duracionResumida +
                '}';
    }
}
