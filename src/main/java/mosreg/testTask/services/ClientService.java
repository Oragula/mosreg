package mosreg.testTask.services;

import mosreg.testTask.dataInit.DataInit;
import mosreg.testTask.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    //если клиент присутствует в черном списке возвращаем true
    //иначе - false
    public static boolean checkClientInBlackList(Client client) {
        List<Client> blackList = DataInit.getBlackList();
        if (blackList.contains(client)) return true;
        else return false;
    }
}
