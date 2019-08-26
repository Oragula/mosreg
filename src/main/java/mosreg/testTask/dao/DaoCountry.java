package mosreg.testTask.dao;

import mosreg.testTask.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoCountry {

    @PersistenceContext
    EntityManager em;

    public Country getCountryByName(String countryName){
        Country country = em.find(Country.class, countryName);
        return country;
    }

    @Transactional
    public void setCountry(Country country){
        em.persist(country);
    }

    @Transactional
    public boolean setLimitForCountry(Country country){
        try {
            Country countryFromDB = em.find(country.getClass(),country.getCountryName());
            countryFromDB.setOrdersPerMinute(country.getOrdersPerMinute());
            em.merge(countryFromDB);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Country> getAllCountries(){
        return em.createQuery("select c from Country c", Country.class).getResultList();
    }

    public int getLimitByCountryname(String countryName){
        return (int)em.createQuery("select c.ordersPerMinute from Country c where c.countryName = :countryName").setParameter("countryName", countryName).getSingleResult();
    }
}
