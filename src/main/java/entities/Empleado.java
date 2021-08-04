package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLEADOS", schema = "dbo", catalog = "Museo")
public class Empleado {
    private int id;
    private Sede sede;
    private String nombre;
    private String apellido;
    private Integer codigoValidacion;
    private String cuit;
    private String dni;
    private String domicilio;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private String mail;
    private String sexo;
    private String telefono;

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
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "codigo_validacion")
    public Integer getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(Integer codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    @Basic
    @Column(name = "cuit")
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Basic
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "domicilio")
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Basic
    @Column(name = "fecha_ingreso")
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Basic
    @Column(name = "fecha_nacimiento")
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", sede=" + sede +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", codigoValidacion=" + codigoValidacion +
                ", cuit='" + cuit + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaNacimiento=" + fechaNacimiento +
                ", mail='" + mail + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Sede obtenerSedeDondeTrabaja() {
        return sede;
    }
}
