package mosreg.testTask.model;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    Client client = new Client(1, "John", "Snow");
    Client client1 = new Client();

    @Test
    public void getIdClient() {
        long idClient = client.getIdClient();
        Assert.assertEquals(1,idClient);
    }

    @Test
    public void setIdClient() {
        client1.setIdClient(2);
        long idClient = client1.getIdClient();
        Assert.assertEquals(2,idClient);
    }

    @Test
    public void getName() {
        String name = client.getName();
        Assert.assertEquals("John", name);
    }

    @Test
    public void setName() {
        client1.setName("Maria");
        String name = client1.getName();
        Assert.assertEquals("Maria", name);
    }

    @Test
    public void getSurname() {
        String surName = client.getSurname();
        Assert.assertEquals("Snow", surName);
    }

    @Test
    public void setSurname() {
        client1.setSurname("Silver");
        String surName = client1.getSurname();
        Assert.assertEquals("Silver", surName);
    }
}