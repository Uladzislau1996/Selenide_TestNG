import Pages.Steps.DashboardSteps;
import com.google.common.collect.ImmutableMap;
import configreader.ConfigReader;
import helper.SelenideHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static config.SelenideConfiguration.config;

public class BaseTest extends SelenideHelper {

    static DashboardSteps dashboard;
    private static final String BROWSER = ConfigReader.properties.browser();
    private static final String BASEURL = ConfigReader.properties.baseUrl();

    @BeforeSuite(description = "Установить окружение в allure")
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", BROWSER)
                        .put("URL", BASEURL)
                        .build());
    }

    @BeforeClass(description = "Применить конфигурации, открыть сайт и выбрать коэффицент")
    public static void setUp() {
        //init config
        config();
        //Precondition
        dashboard = DashboardSteps.openPage()
                .setPrecondition();
    }

    @AfterMethod(description = "Добавить скриншот если тест упал")
    public void addScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
            attachScreenshot();
        }
    }

    @AfterClass(description = "Очистить кэш и куки")
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }

}
