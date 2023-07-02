import Pages.Steps.CouponSteps;
import Pages.Steps.DashboardSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "getCoefficient")
    @Severity(SeverityLevel.NORMAL)
    @Description("Установить коэфицент, проверить данные купоне, удалить коэфициент ")
    public void openAndDeleteCouponTest(String coefficients) {
        dashboard.isCorrectCoefficientTitle();

        coupon = dashboard.setCoefficient(coefficients);
        coupon.checkCouponData();
        coupon.checkCoefficientType(coefficients);
        coupon.clearCoupon();
        coupon.IsNotCouponVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон удаляется по кнопке DeleteRate")
    public void deleteRateTest() {
        dashboard.isCorrectCoefficientTitle();

        coupon = dashboard.setCoefficient();
        coupon.checkCouponData();
        coupon.checkCoefficient();
        coupon.deleteRate();
        coupon.IsNotCouponVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон удаляется по кнопке clearCoupon")
    public void clearCouponTest() {
        dashboard.isCorrectCoefficientTitle();

        coupon = dashboard.setCoefficient();
        coupon.checkCouponData();
        coupon.checkCoefficient();
        coupon.clearCoupon();
        coupon.IsNotCouponVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон не появляется после добла клика по коэффициенту в дашборде")
    public void couponIsNotVisible() {
        dashboard.isCorrectCoefficientTitle();

        coupon = dashboard.doubleClickCoefficient();
        coupon.IsNotCouponVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон отображается после дабл клика по коэффициенту")
    public void couponIsVisible() {
        dashboard.isCorrectCoefficientTitle();

        coupon = dashboard.doubleClickCoefficient();
        coupon.isCouponVisible();
    }


    @DataProvider
    public Object[][] getCoefficient() {
        return new Object[][]{
                {"1"}, {"X"}, {"2"}, {"1X"}, {"12"}, {"2X"}, {"Б"}, {"М"}, {"Фора1"}, {"Фора2"}, {"БИТ1"}, {"МИТ1"},
        };
    }

}
