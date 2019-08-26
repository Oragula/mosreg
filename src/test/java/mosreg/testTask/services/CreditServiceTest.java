package mosreg.testTask.services;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditServiceTest {

    @Test
    public void checkExcessOfOrders() throws InterruptedException {
        Assert.assertTrue(CreditService.checkExcessOfOrders(1, "Россия"));
        Assert.assertFalse(CreditService.checkExcessOfOrders(1, "Россия"));
        Assert.assertTrue(CreditService.checkExcessOfOrders(3, "Россия"));
    }
}