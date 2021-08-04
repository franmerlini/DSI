package DAO;

import entities.Usuario;

import javax.persistence.Query;
import java.util.List;

public class UsuarioDAO extends GenericDAO {

    public List<Usuario> listar() {
        String consulta = "SELECT u FROM Usuario u";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
}
