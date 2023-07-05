package Pages.Steps;

import Pages.Locators.CouponLocators;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class CouponSteps extends CouponLocators {

    DashboardSteps dashboard = new DashboardSteps();

    @Step("Срванить название лиги в купоне с дашбордом")
    public CouponSteps assertLeagueName() {
        //Cравнить название лиги в купоне и дашборде
        assertTrue(leagueName.is(text(dashboard.getLeagueName())), "Название лиги не совпадает");
        return this;
    }

    @Step("Срванить название команд в купоне с дашбордом")
    public CouponSteps assertTeamsName() {
        //Проверить названи команды в куопне и дашборде
        assertTrue(getTeamsName().contains(dashboard.getTeamsName()), "Не совпадает название команды");
        return this;
    }

    @Step("Сравнить коэфициент в купоне с дашбордом")
    public CouponSteps checkCoefficientNumber(String value) {
        //Проверить что коэффициент в купоне и дашборде совпадает
        assertTrue(coefficient.is(text(dashboard.getCoefficient(value))), "не корректный коэффициент");
        return this;
    }

    @Step("Сравнить коэфициент в купоне с дашбордом")
    public CouponSteps checkCoefficient() {
        //Проверить что коэффициент в дашборде и купоне совпадает
        assertTrue(coefficient.is(text(dashboard.getCoefficient())), "не корректный коэффициент");
        return this;
    }

    @Step("Проверить отображение элементов в купоне")
    public CouponSteps checkCouponElementsVisibility() {
        //Проверить, отображение элементов в купоне
        for (SelenideElement element : getCouponElements()) {
            element.shouldBe(visible);
        }
        return this;
    }

    @Step("Проверить отображение элементов в дропдаун меню")
    public CouponSteps checkDropDownElementsVisibility() {
        //открыть дропдаун
        openDropDown();

        //Проверка элементов в дропдауне
        for (SelenideElement element : getDropDownElements()) {
            element.shouldBe(visible);
        }

        return this;
    }

    @Step("Проверка текста в элементах купона")
    public CouponSteps checkElementsText() {
        clearButton.shouldHave(text("Очистить"));
        stakeAmount.shouldHave(text("СУММА СТАВКИ (\n" +
                "KES\n" +
                ")"));
        maximumBet.shouldHave(text("Максимальная ставка:"));
        maximumBetCounter.shouldHave(text("0"));
        possibleWin.shouldHave(text(" Возможный выигрыш:"));
        possibleWinCounter.shouldHave(text("0"));
        changingCoefficient.shouldHave(text("При изменении коэффициента"));
        dropDown.shouldHave(text("Подтверждать"));
        return this;
    }

    @Step("Проверка текста в dropdown menu купона")
    public CouponSteps checkDropdownElementsText() {
        //Открыть дродаун, проверить наличие dropdown menu
        openDropDown();
        isDropdownElementVisible();

        //Проверка текста в dropdown menu
        dropDownAcceptWhenRise.shouldHave(text("Принять при повышении"));
        dropDownConfirm.shouldHave(text("Подтверждать"));
        dropDownAcceptAnyChanges.shouldHave(text("Принять любое изменение"));
        return this;
    }

}
