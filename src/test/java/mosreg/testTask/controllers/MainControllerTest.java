package mosreg.testTask.controllers;

import mosreg.testTask.dao.DaoClient;
import mosreg.testTask.dao.DaoCountry;
import mosreg.testTask.dao.DaoCredit;
import mosreg.testTask.dataInit.DataInit;
import mosreg.testTask.model.Client;
import mosreg.testTask.model.Country;
import mosreg.testTask.model.Credit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @InjectMocks
    private MainController mainController = new MainController();

    @Mock
    private Model model;

    @Mock
    private DaoCountry daoCountry = new DaoCountry();

    @Mock
    private DaoCredit daoCredit = new DaoCredit();

    @Mock
    private DaoClient daoClient = new DaoClient();

    @Test
    public void getMain() throws Exception {
        String p = mainController.getMain(model);
        Assert.assertEquals("main", p);
    }

    @Test
    public void postOrder() {
        Client client = new Client(1, "John", "Snow");
        Country country = new Country("Албания", 2);
        Credit credit = new Credit();
        credit.setCountry(country);
        credit.setClient(client);

        String p = mainController.postOrder(credit, client, country);
        Assert.assertEquals("Заявка на кредит принята", p);
    }

    @Test
    public void getAllCredits() {
        String p = mainController.getAllCredits(model);
        Assert.assertEquals("allCredits", p);
    }

    @Test
    public void getAllCreditsOfClient() {
        String p = mainController.getAllCreditsOfClient(3,model);
        Assert.assertEquals("clientsCredits", p);
    }

    @Test
    public void getLimitPage() {
        String p = mainController.getLimitPage(model);
        Assert.assertEquals("limit", p);
    }

    @Test
    public void setLimit() {
        Country country = new Country("Албания", 2);
        String p = mainController.setLimit(country);
        Assert.assertEquals("не удалось установить ограничение количества заявок в минуту для страны Албания", p);
    }
}