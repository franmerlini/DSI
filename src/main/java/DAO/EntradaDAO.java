package DAO;

import entities.Entrada;

import javax.persistence.Query;
import java.util.List;

public class EntradaDAO extends GenericDAO {

    public List<Entrada> listar() {
        String consulta = "SELECT e FROM Entrada e";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Entrada entrada) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entrada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
