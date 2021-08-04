package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ASIGNACIONES_RESERVA", schema = "dbo", catalog = "Museo")
public class AsignacionReserva implements Serializable {
    private ReservaVisita reservaVisita;
    private Exposicion exposicion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_reserva_visita", referencedColumnName = "numero")
    public ReservaVisita getReservaVisita() {
        return reservaVisita;
    }

    public void setReservaVisita(ReservaVisita reservaVisita) {
        this.reservaVisita = reservaVisita;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "id_exposicion", referencedColumnName = "id")
    public Exposicion getExposicion() {
        return exposicion;
    }

    public void setExposicion(Exposicion exposicion) {
        this.exposicion = exposicion;
    }

    @Override
    public String toString() {
        return "AsignacionReserva{" +
                "reservaVisita=" + reservaVisita +
                ", exposicion=" + exposicion +
                '}';
    }
}
