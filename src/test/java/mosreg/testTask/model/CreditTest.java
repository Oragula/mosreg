package mosreg.testTask.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditTest {
    Client client = new Client(1, "John", "Snow");
    Country country = new Country("Албания", 2);
    Credit credit = new Credit();

    @Test
    public void getIdCredit() {
        credit.setIdCredit(1);
        int idCredit = credit.getIdCredit();
        Assert.assertEquals(1,idCredit);
    }

    @Test
    public void getSum() {
        credit.setSum(100);
        int sum = credit.getSum();
        Assert.assertEquals(100,sum);
    }

    @Test
    public void getTerm() {
        credit.setTerm((short) 10);
        short term = credit.getTerm();
        Assert.assertEquals(10,term);
    }

    @Test
    public void getClient() {
        credit.setClient(client);
        Client clientFromCredit = credit.getClient();
        Assert.assertEquals(client, clientFromCredit);
    }

    @Test
    public void getCountry() {
        credit.setCountry(country);
        Country countryFromCredit = credit.getCountry();
        Assert.assertEquals(country,countryFromCredit);
    }

}