package DAO;

import entities.Sede;

import javax.persistence.Query;
import java.util.List;

public class SedeDAO extends GenericDAO {

    public List<Sede> listar() {
        String consulta = "SELECT s FROM Sede s";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
}
