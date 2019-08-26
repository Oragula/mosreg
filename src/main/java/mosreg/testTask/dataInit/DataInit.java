package mosreg.testTask.dataInit;

import mosreg.testTask.dao.DaoCountry;
import mosreg.testTask.model.Client;
import mosreg.testTask.model.Country;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {

    @Autowired
    DaoCountry daoCountry;

    private static List <Client> blackList = new ArrayList <>();

    public static List <Client> getBlackList() {
        return blackList;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        blackListInitialization();
        tableCountryInitialization();
    }

    private void blackListInitialization() {
        //пробуем прочитать файл с "черным списком" клиентов из файла clientsBlackList, расположенного в корне диска C:
        //данные в файле должны быть разделены пробелами, каждый новый клиент с новой строки
        //порядок данных в строке: idClient name surname
        //сравнение клиента идет по всем полям
        //если файла нет, то сообщает об ошибке и работает без файла
        File file = Paths.get("C:" + File.separatorChar + "clientsBlackList").toFile();

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(file));
            String[] array = null;
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                array = line.split(" ");
                Client client = new Client(Long.parseLong(array[0]), array[1], array[2]);
                blackList.add(client);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл с \"черным списком\" клиентов не найден по пути С:/clientsBlackList");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл с \"черным списком\"");
            e.printStackTrace();
        }
    }

    private void tableCountryInitialization() throws IOException {
        //заполняем таблицу БД country списком, считываемым из файла countries
        InputStream stream = getClass().getClassLoader().getResourceAsStream("static/initialData/countries");
        String s = IOUtils.toString(stream, "utf-8");
        String[] arr = s.split(System.lineSeparator());
        Arrays.stream(arr).forEach(countryName -> daoCountry.setCountry(new Country(countryName, 0)));
    }
}
