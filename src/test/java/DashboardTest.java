import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка данных в дашборде")
    public void testDashboard() {
        dashboard.assertCoefficientTitleText()
                .checkDropdownMenu();
    }

}
