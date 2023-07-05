import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка данных в дашборде")
    public void dashboardTest() {
        dashboard.assertCoefficientTitleText()
                .checkDropdownMenu()
                .openMoreBetsMenu()
                .compareBetsNumber();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка данных в дашборде")
    public void moreBetsMenuTest() {
        dashboard.doubleClickMoreBetsMenu()
                .isMoreBetsMenuNotVisible();
    }

}
