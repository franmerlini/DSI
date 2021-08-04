package DAO;

import entities.Tarifa;

import javax.persistence.Query;
import java.util.List;

public class TarifaDAO extends GenericDAO {

    public List<Tarifa> listar() {
        String consulta = "SELECT t FROM Tarifa t";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
}
