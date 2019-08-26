package mosreg.testTask.services;

import mosreg.testTask.dao.DaoClient;
import mosreg.testTask.dataInit.DataInit;
import mosreg.testTask.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClientServiceTest {

    @Test
    public void checkClientInBlackList() {
        List<Client> blacklist = DataInit.getBlackList();
        Client client = new Client(1,"John","Silver");
        Client client1 = new Client(1,"John","Snow");
        blacklist.add(client);

        Assert.assertTrue(ClientService.checkClientInBlackList(client));
        Assert.assertFalse(ClientService.checkClientInBlackList(client1));
    }
}