package DAO;

import entities.Empleado;

import javax.persistence.Query;
import java.util.List;

public class EmpleadoDAO extends GenericDAO {

    public List<Empleado> listar() {
        String consulta = "SELECT e FROM Empleado e";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
}
