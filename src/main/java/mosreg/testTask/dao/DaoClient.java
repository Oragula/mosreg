package mosreg.testTask.dao;

import mosreg.testTask.model.Client;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DaoClient {

    @PersistenceContext
    EntityManager em;

    public Client getClientById(long idClient){
        return em.find(Client.class, idClient);
    }

    @Transactional
    public boolean addClient(Client client) {
        try {
            em.persist(client);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
