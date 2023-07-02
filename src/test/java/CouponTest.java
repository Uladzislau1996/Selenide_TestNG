import Pages.Steps.CouponSteps;
import Pages.Steps.DashboardSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class CouponTest extends BaseTest {

    CouponSteps coupon;

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка название команд/лиги в купоне")
    public void testLeagueAndTeamName() {
        coupon = new DashboardSteps().setCoefficient();
        coupon.checkCouponData();
        coupon.checkCoefficient();
    }

}
