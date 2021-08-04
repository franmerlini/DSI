package DAO;

import entities.ReservaVisita;

import javax.persistence.Query;
import java.util.List;

public class ReservaVisitaDAO extends GenericDAO {

    public List<ReservaVisita> listar() {
        String consulta = "SELECT r FROM ReservaVisita r";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
}
