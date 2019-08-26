package mosreg.testTask.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditServiceTestWithDelay {

    @Test
    public void checkExcessOfOrders() throws InterruptedException {
        CreditService.checkExcessOfOrders(1, "Россия");
        CreditService.checkExcessOfOrders(1, "Россия");
        Thread.sleep(60000);
        Assert.assertTrue(CreditService.checkExcessOfOrders(1, "Россия"));
    }
}