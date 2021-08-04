package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SEDES", schema = "dbo", catalog = "Museo")
public class Sede {
    private int id;
    private String nombre;
    private Integer cantMaxVisitantes;
    private Integer cantMaxPorGuia;
    private List<Tarifa> tarifas;
    private List<Exposicion> exposiciones;
    private List<Empleado> empleados;
    private List<ReservaVisita> reservasVisita;

    @Id
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
    @Column(name = "cant_max_visitantes")
    public Integer getCantMaxVisitantes() {
        return cantMaxVisitantes;
    }

    public void setCantMaxVisitantes(Integer cantMaxVisitantes) {
        this.cantMaxVisitantes = cantMaxVisitantes;
    }

    @Basic
    @Column(name = "cant_max_por_guia")
    public Integer getCantMaxPorGuia() {
        return cantMaxPorGuia;
    }

    public void setCantMaxPorGuia(Integer cantMaxPorGuia) {
        this.cantMaxPorGuia = cantMaxPorGuia;
    }

    @OneToMany(mappedBy = "sede")
    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    @OneToMany(mappedBy = "sede")
    public List<Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(List<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    @OneToMany(mappedBy = "sede")
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @OneToMany(mappedBy = "sede")
    public List<ReservaVisita> getReservasVisita() {
        return reservasVisita;
    }

    public void setReservasVisita(List<ReservaVisita> reservasVisita) {
        this.reservasVisita = reservasVisita;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantMaxVisitantes=" + cantMaxVisitantes +
                ", cantMaxPorGuia=" + cantMaxPorGuia +
                '}';
    }

    public List<Tarifa> buscarTarifasVigentes(LocalDate fechaActual) {
        List<Tarifa> aux = new ArrayList<>();

        for (Tarifa tarifa : tarifas) {
            if (tarifa.esVigente(fechaActual)) {
                aux.add(tarifa);
            }
        }
        return aux;
    }

    public int calcularDuracionEstimadaVisitaCompleta(LocalDate fechaActual) {
        int aux = 0;
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.esVigente(fechaActual)) {
                aux += exposicion.buscarDuracionResumidaObra();
            }
        }
        return aux;
    }

    public int buscarLimiteVisitantes() {
        return getCantMaxVisitantes();
    }
}
