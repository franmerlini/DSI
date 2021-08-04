package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SESIONES", schema = "dbo", catalog = "Museo")
public class Sesion {
    private int id;
    private Usuario usuario;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    public Sesion(Usuario usuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.usuario = usuario;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "fecha_hora_inicio")
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    @Basic
    @Column(name = "fecha_hora_fin")
    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", fechaHoraFin=" + fechaHoraFin +
                '}';
    }

    public Empleado obtenerEmpleadoLogueado() {
        return usuario.conocerEmpleado();
    }
}
