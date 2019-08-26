# mosreg
Тестовое задание
Для запуска приложения достаточно скачать файл mosreg.war по ссылке: hmelev.tk (5-ый пункт)
После чего запустить командой java -jar mosreg.war
Приложение будет доступно в браузере по адресу localhost
При необходимости можно загрузить "черный список" клиентов, положив файл с именем clientsBlackList на диск С: (C:/clientsBlackList) до запуска приложения. Пример можно скачать с hmelev.tk (6-ой пункт) либо создать в текстовом формате: кодировка UTF-8, каждый пользователь на отдельной строке, данные пользователя разделены пробелами, порядок данных: idClient name surname. Проверка выполняется по всем трем параметрам.
Страницы приложения: /limit - установка ограничения количества заявок в минуту для выбранной страны; /allCredits - список всех кредитов; /allCredits/{idClient} - список всех кредитов для клиента с idClient (пример: /allCredits/3).
Дополнительная информация: проверок правильности ввода данных в формах нет.

Главная страница приложения:
![Image alt](https://github.com/Oragula/mosreg/blob/master/src/main/resources/main.png)

Страница установки лимита заявок в минуту для страны:
![Image alt](https://github.com/Oragula/mosreg/blob/master/src/main/resources/limit.png)

Пример страницы со списком всех заявок:
![Image alt](https://github.com/Oragula/mosreg/blob/master/src/main/resources/allCredits.png)
