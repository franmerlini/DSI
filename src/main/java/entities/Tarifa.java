package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TARIFAS", schema = "dbo", catalog = "Museo")
public class Tarifa {
    private int id;
    private Sede sede;
    private TipoVisita tipoVisita;
    private TipoEntrada tipoEntrada;
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private Double monto;
    private Double montoAdicionalGuia;

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
    @Column(name = "fecha_inicio_vigencia")
    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    @Basic
    @Column(name = "fecha_fin_vigencia")
    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    @Basic
    @Column(name = "monto")
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "monto_adicional_guia")
    public Double getMontoAdicionalGuia() {
        return montoAdicionalGuia;
    }

    public void setMontoAdicionalGuia(Double montoAdicionalGuia) {
        this.montoAdicionalGuia = montoAdicionalGuia;
    }

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @OneToOne
    @JoinColumn(name = "id_tipo_visita", referencedColumnName = "id")
    public TipoVisita getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(TipoVisita tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    @OneToOne
    @JoinColumn(name = "id_tipo_entrada", referencedColumnName = "id")
    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "id=" + id +
                ", sede=" + sede +
                ", tipoVisita=" + tipoVisita +
                ", tipoEntrada=" + tipoEntrada +
                ", fechaInicioVigencia=" + fechaInicioVigencia +
                ", fechaFinVigencia=" + fechaFinVigencia +
                ", monto=" + monto +
                ", montoAdicionalGuia=" + montoAdicionalGuia +
                '}';
    }

    public boolean esVigente(LocalDate fechaActual) {
        return fechaInicioVigencia.compareTo(fechaActual) <= 0 && fechaFinVigencia.compareTo(fechaActual) >= 0;
    }
}
