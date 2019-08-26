package mosreg.testTask.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {
    Country country = new Country("Албания", 2);
    Country country1 = new Country();

    @Test
    public void getCountryName() {
        String countryName = country.getCountryName();
        Assert.assertEquals("Албания", countryName);
    }

    @Test
    public void setCountryName() {
        country1.setCountryName("Канада");
        String countryName = country1.getCountryName();
        Assert.assertEquals("Канада", countryName);
    }

    @Test
    public void getOrdersPerMinute() {
        int ordersPerMinute = country.getOrdersPerMinute();
        Assert.assertEquals(2, ordersPerMinute);
    }

    @Test
    public void setOrdersPerMinute() {
        country1.setOrdersPerMinute(2);
        int ordersPerMinute = country1.getOrdersPerMinute();
        Assert.assertEquals(2,ordersPerMinute);
    }
}