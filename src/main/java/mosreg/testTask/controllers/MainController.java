package mosreg.testTask.controllers;

import mosreg.testTask.dao.DaoClient;
import mosreg.testTask.dao.DaoCountry;
import mosreg.testTask.dao.DaoCredit;
import mosreg.testTask.model.Client;
import mosreg.testTask.model.Country;
import mosreg.testTask.model.Credit;
import mosreg.testTask.services.ClientService;
import mosreg.testTask.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    DaoCountry daoCountry;

    @Autowired
    DaoCredit daoCredit;

    @Autowired
    DaoClient daoClient;

    private static List<Country> countriesList;

    @GetMapping("/")
    public String getMain(Model model){
        List<Country> countries = daoCountry.getAllCountries();
        countriesList = countries;
        model.addAttribute("countries", countries);
        return "main";
    }

    @PostMapping(value = "/")
    @ResponseBody
    public String postOrder(@ModelAttribute ("order") Credit credit, @ModelAttribute("client") Client client, @ModelAttribute("country") Country country){
        //проверяем пользователя на присутствие в черном списке, если присутствует сразу отказываем в кредите
        if (ClientService.checkClientInBlackList(client)) return "К сожалению, в кредите отказано. Клиент находится в черном списке";

        //получаем значение лимита для указанной в заявке страны
        int limit = daoCountry.getLimitByCountryname(country.getCountryName());

        //проверяем не превышает ли эта завка установленного лимита
        if (!CreditService.checkExcessOfOrders(limit, country.getCountryName())) return "Превышен лимит заявок в минуту из страны " + country.getCountryName();

        //если все проверки пройдены успешно, то начинаем процедуру добавления кредита в БД

        //добавляем пользователя в базу данных если он там отсутствует
        Client clientFromDB = daoClient.getClientById(client.getIdClient());
        if (clientFromDB == null) daoClient.addClient(client);
        else client = clientFromDB;
        //устанавливаем для кредита пользователя и страну
        credit.setClient(client);
        credit.setCountry(country);
        //добавляем кредит в БД
        daoCredit.addCredit(credit);
        return "Заявка на кредит принята";
    }

    @GetMapping("/allCredits")
    public String getAllCredits(Model model){
        List<Credit> credits = daoCredit.getAllCredits();
        model.addAttribute("credits", credits);
        return "allCredits";
    }

    @GetMapping("/allCredits/{idClient}")
    public String getAllCreditsOfClient (@PathVariable int idClient, Model model){
        List<Credit> credits = daoCredit.getCreditsByClientId(idClient);
        model.addAttribute("credits", credits);
        return "clientsCredits";
    }

    @GetMapping("/limit")
    public String getLimitPage(Model model){
        model.addAttribute("countries", countriesList);
        return "limit";
    }

    @PostMapping("/limit")
    @ResponseBody
    public String setLimit(@ModelAttribute ("country") Country country) {
        String response = daoCountry.setLimitForCountry(country) ?
                "ограничение количества заявок в минуту для страны " + country.getCountryName() + " успешно установлено"
                : "не удалось установить ограничение количества заявок в минуту для страны " + country.getCountryName();
        return response;
    }
}
