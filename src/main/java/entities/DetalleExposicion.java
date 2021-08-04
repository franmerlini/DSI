package entities;

import javax.persistence.*;

@Entity
@Table(name = "DETALLES_EXPOSICION", schema = "dbo", catalog = "Museo")
public class DetalleExposicion {
    private int id;
    private Exposicion exposicion;
    private Obra obra;
    private String lugarAsignado;

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
    @Column(name = "lugar_asignado")
    public String getLugarAsignado() {
        return lugarAsignado;
    }

    public void setLugarAsignado(String lugarAsignado) {
        this.lugarAsignado = lugarAsignado;
    }

    @ManyToOne
    @JoinColumn(name = "id_exposicion", referencedColumnName = "id")
    public Exposicion getExposicion() {
        return exposicion;
    }

    public void setExposicion(Exposicion exposicion) {
        this.exposicion = exposicion;
    }

    @OneToOne
    @JoinColumn(name = "id_obra", referencedColumnName = "id")
    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "DetalleExposicion{" +
                "id=" + id +
                ", exposicion=" + exposicion +
                ", obra=" + obra +
                ", lugarAsignado='" + lugarAsignado + '\'' +
                '}';
    }

    public int buscarDuracionResumidaObra() {
        return obra.getDuracionResumida();
    }
}
