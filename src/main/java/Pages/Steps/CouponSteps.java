package Pages.Steps;

import Pages.Locators.CouponLocators;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static helper.SelenideHelper.SECONDS;
import static org.testng.Assert.assertTrue;

public class CouponSteps extends CouponLocators {

    DashboardSteps dashboard = new DashboardSteps();

    @Step("Проверить все данные в купоне")
    public CouponSteps checkCouponData() {
        isCouponVisible();
        assertLeagueName();
        assertTeamsName();
        shouldCouponElementsVisible();
        shouldDropDownElementsPresent();
        assertTextInElements();
        assertDropdownText();
        return this;
    }

    @Step("Срванить название лиги в купоне с дашбордом")
    public void assertLeagueName() {
        //Получить название лиги из дашборда
        String dashboardLeagueName = dashboard.getLeagueName();

        //Cравнить название лиги
        assertTrue(leagueName.is(text(dashboardLeagueName)), "Название лиги не совпадает");
    }

    @Step("Срванить название команд в купоне с дашбордом")
    public void assertTeamsName() {
        //Получить название команды из дашборда удалив пробелы
        String dashboardTeamsName = dashboard.getTeamsName().replaceAll("\\s", "");
        //Получить название команды удалив "-" и пробелсы из строки в купоне
        String teamName = teamsName.getText().replaceAll("[-\\s]", "");

        //Проверить названи команды удалив "-" из строки в купоне
        assertTrue(teamName.contains(dashboardTeamsName));

    }

    @Step("Сравнить коэфициент в купоне с дашбордом")
    public CouponSteps checkCoefficientNumber() {
        //Получить коэфициент из дашборда
        String dashboardCoefficient = dashboard.getCoefficient();
        //Проверить что коэффициент совпадает
        assertTrue(coefficient.is(text(dashboardCoefficient)), "не корректный коэффициент");
        return this;
    }

    @Step("Проверить отображение элементов в купоне")
    public void shouldCouponElementsVisible() {
        //Проверить, отображение элементов в списке
        List<SelenideElement> elements = getCouponElements();
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }

    @Step("Проверить отображение элементов в lhjglfeyt")
    public void shouldDropDownElementsPresent() {
        //открыть дропдаун
        dropDown.click();

        //Проверка элементов в дропдауне
        List<SelenideElement> elements = getDropDownElements();
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }

    @Step("Возвращаю коллекцию элементов в купоне")
    public List<SelenideElement> getCouponElements() {
        //Создать коллекцию из элементов купона
        return Arrays.asList(leagueName, teamsName,
                coefficient, stakeAmount, stakeAmountCounter, maximumBet, maximumBetCounter,
                possibleWin, possibleWinCounter, changingCoefficient, changingCoefficient,
                dropDown, promoCode, promoCodeTextField, clearButton, deleteRateButton, coefficientType);
    }

    @Step("Вернуть коллекцию элементов в выпадающем списке")
    public List<SelenideElement> getDropDownElements() {
        //Создаю коллекцию из элементов дропдаун меню
        return Arrays.asList(dropDownConfirm, dropDownAcceptAnyChanges, dropDownAcceptWhenRise);
    }

    @Step("Проверка текста в элементах купона")
    public void assertTextInElements() {
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
    }

    @Step("Проверка текста в дропдуне купона")
    public void assertDropdownText() {
        dropDown.click();
        dropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(SECONDS));
        dropDownAcceptWhenRise.shouldHave(text("Принять при повышении"));
        dropDownConfirm.shouldHave(text("Подтверждать"));
        dropDownAcceptAnyChanges.shouldHave(text("Принять любое изменение"));
    }

    @Step("Проверить тип коэффициента в зависимости от полученного значение")
    public CouponSteps checkCoefficientType(String value) {
        if (value == "1") {
            coefficientType.shouldHave(text("1Х2 П1"));

        } else if (value == "X") {
            coefficientType.shouldHave(text("1Х2 Ничья"));

        } else if (value == "2") {
            coefficientType.shouldHave(text("1Х2 П2"));

        } else if (value == "1X") {
            coefficientType.shouldHave(text("Двойной шанс 1Х"));

        } else if (value == "12") {
            coefficientType.shouldHave(text("Двойной шанс 12"));

        } else if (value == "2X") {
            coefficientType.shouldHave(text("Двойной шанс 2Х"));

        } else if (value == "Б" || value == "М") {
            coefficientType.shouldHave(text("Тотал"));

        } else if (value == "Фора1") {
            coefficientType.shouldHave(text("Фора 1"));

        } else if (value == "Фора2") {
            coefficientType.shouldHave(text("Фора 2"));

        } else if (value == "БИТ1" || value == "МИТ1") {
            coefficientType.shouldHave(text("Индивидуальный тотал 1"));
        }
        return this;
    }

    @Step("Клик по кнопке очистить")
    public CouponSteps clearCoupon() {
        clearButton.click();
        return this;
    }

    @Step("Клик по кнопке удалить ставку")
    public CouponSteps deleteRate() {
        deleteRateButton.click();
        return this;
    }

    @Step("Проверить что купон не отображается")
    public CouponSteps isNotCouponVisible() {
        couponBet.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить что купон отображается")
    public CouponSteps isCouponVisible() {
        couponBet.shouldBe(visible, Duration.ofSeconds(SECONDS));
        return this;
    }

}
