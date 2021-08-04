package entities;

import javax.persistence.*;

@Entity
@Table(name = "TIPOS_VISITA", schema = "dbo", catalog = "Museo")
public class TipoVisita {
    private int id;
    private String nombre;

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

    @Override
    public String toString() {
        return "TipoVisita{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
