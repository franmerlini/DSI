package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CREACIONES_SEDE", schema = "dbo", catalog = "Museo")
public class CreacionSede implements Serializable {
    private Sede sede;
    private Empleado empleado;

    @Id
    @OneToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Id
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
        return "CreacionSede{" +
                "sede=" + sede +
                ", empleado=" + empleado +
                '}';
    }
}
