package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIOS", schema = "dbo", catalog = "Museo")
public class Usuario {
    private int id;
    private String nombre;
    private String contraseña;
    private LocalDate caducidad;
    private Empleado empleado;

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
    @Column(name = "contraseña")
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Basic
    @Column(name = "caducidad")
    public LocalDate getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
    }

    @OneToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", caducidad=" + caducidad +
                ", empleado=" + empleado +
                '}';
    }

    public Empleado conocerEmpleado() {
        return empleado;
    }
}
