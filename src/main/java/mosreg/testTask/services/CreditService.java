package mosreg.testTask.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CreditService {
    private static volatile List<String> listOfThreads = new ArrayList <>();

    /**
     * Метод возвращает false если для страны задан лимит заявок в минуту (не равен нулю) и он уже исчерпан
     * Если же лимит не установлен, либо он не исчерпан, то метод учитывает эту заявку и возвращает true
     * @param ordersPerMinute - лимит количества заявок в минуту для страны с именем countryName
     * @param countryName - наименование страны
     * @return false или true
     */
    public static synchronized boolean checkExcessOfOrders(int ordersPerMinute, String countryName){
        if (ordersPerMinute != 0 && Collections.frequency(listOfThreads, countryName) >= ordersPerMinute) return false;
        listOfThreads.add(countryName);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                listOfThreads.remove(countryName);
            }
        }, 1, TimeUnit.MINUTES);

        return true;
    }
}
