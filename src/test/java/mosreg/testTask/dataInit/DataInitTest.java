package mosreg.testTask.dataInit;

import mosreg.testTask.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataInitTest {
    Client client = new Client(1, "John", "Snow");
    List<Client> blackList = new ArrayList <>();

    @Test
    public void getBlackList() throws NoSuchFieldException, IllegalAccessException {
        blackList.add(client);
        Field field = DataInit.class.getDeclaredField("blackList");
        field.setAccessible(true);
        field.set(new DataInit(), blackList);
        List<Client> listFromDataInit = DataInit.getBlackList();
        Assert.assertEquals(blackList,listFromDataInit);
    }

    //пройдет только если в есть файл C:\clientsBlackList со списком в нужном формате
    @Test
    public void blackListInitialization() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = DataInit.class.getDeclaredMethod("blackListInitialization");
        method.setAccessible(true);
        method.invoke(new DataInit(),null);

        List<Client> blackList = DataInit.getBlackList();
        Assert.assertNotNull(blackList);
    }

}