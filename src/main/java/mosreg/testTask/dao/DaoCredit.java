package mosreg.testTask.dao;

import mosreg.testTask.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoCredit {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean addCredit(Credit credit){
        try {
            em.persist(credit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Credit> getAllCredits(){
        return em.createQuery("select c from Credit c", Credit.class).getResultList();
    }

    public List<Credit> getCreditsByClientId(long idClient){
        return em.createQuery("select c from Credit c where c.client.idClient = :idClient", Credit.class).setParameter("idClient", idClient).getResultList();
    }
}
