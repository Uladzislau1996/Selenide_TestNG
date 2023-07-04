import Pages.Steps.CouponSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CouponTest extends BaseTest {

    CouponSteps coupon;

    @Test(dataProvider = "getCoefficient")
    @Severity(SeverityLevel.NORMAL)
    @Description("Установить коэфицент, проверить данные купоне, удалить коэфициент ")
    public void checkCouponDataTest(String setCoefficient) {
        coupon = dashboard.setCoefficient(setCoefficient)
                .isCouponVisible()
                .checkCoefficientNumber(setCoefficient)
                .checkCouponElementsVisibility()
                .checkDropDownElementsVisibility()
                .checkElementsText()
                .checkDropdownElementsText()
                .clearCoupon()
                .isCouponNotVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон удаляется по кнопке DeleteRate")
    public void deleteRateTest() {
        dashboard.assertCoefficientTitleText();

        coupon = dashboard.setCoefficient()
                .isCouponVisible()
                .checkCoefficient()
                .assertLeagueName()
                .assertTeamsName()
                .deleteRate()
                .isCouponNotVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон удаляется по кнопке clearCoupon")
    public void clearCouponTest() {
        dashboard.assertCoefficientTitleText();

        coupon = dashboard.setCoefficient()
                .isCouponVisible()
                .checkCoefficient()
                .assertLeagueName()
                .assertTeamsName()
                .clearCoupon()
                .isCouponNotVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон не появляется после добла клика по коэффициенту в дашборде")
    public void doubleClickCoefficientTest() {
        dashboard.assertCoefficientTitleText();

        coupon = dashboard.doubleClickCoefficient()
                .isCouponNotVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Купон отображается после дабл клика по коэффициенту")
    public void couponVisibilityTest() {
        dashboard.assertCoefficientTitleText();

        coupon = dashboard.doubleClickCoefficient()
                .isCouponVisible();
    }


    @DataProvider
    public Object[][] getCoefficient() {
        return new Object[][]{
                {"1"}, {"X"}, {"2"}, {"1X"}, {"12"}, {"2X"}, {"Б"}, {"М"}, {"Фора1"}, {"Фора2"}, {"БИТ1"}, {"МИТ1"},
        };
    }

}
