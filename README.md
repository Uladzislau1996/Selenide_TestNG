### Тестовый проект Java Selenide TestNG Maven
### Локаторы описывал в классах Locators степы в Steps
### Для просмотра Allure отчета введите команду mvn allure:serve после выполнения тестов
![Снимок экрана 2023-07-02 в 16 02 17](https://github.com/Uladzislau1996/Selenide_TestNG/assets/39631679/9479f021-6260-46c7-a4b5-ea4d65fe704e)
![Снимок экрана 2023-07-02 в 15 53 38](https://github.com/Uladzislau1996/Selenide_TestNG/assets/39631679/b1b8d851-2717-4a60-b326-ce038ec2a5dc)



### В конфиге:
1. Устанавка браузера CHROME
2. Включить интеграцию Selenide и WebDriverManager
3. Включить отображение окна браузера на экране
4. Устанавка максимального размера окна браузера
5. Устанавка BASE_URL

### В предусловии
1. Открыть сайт
2. Принять куки
3. Скрол к коэффициенту
4. Проверка отображения события

### После каждого теста
1. Сделать скрин если тест успал

### После выполенния тестов
1. Чистить кэш и куки
2. Закрыть браузер

### В классе DashboardTest
1. Проверка данных в дашборде

### В классе CouponTest
1. Проверка данных в купоне
1. Проверка данных в купоне при клике на разные коэффициенты
2. Проверка зыкрытия купона тремя способами
3. Одна негативаня проверка фейлится (мождно проверить скриншот)


 
