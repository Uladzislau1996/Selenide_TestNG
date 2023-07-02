package Pages.Steps;

import Pages.Locators.CouponLocators;
import Pages.Locators.DashboardLocators;
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

    DashboardLocators dashboard = new DashboardLocators();

    @Step("Проверить все данные в купоне")
    public void checkCouponData() {
        isCouponVisible();
        assertTrue(checkLeague(), "Название лиги не совпадает с дашбордом");
        assertTrue(checkTeams(), "Название команды не совпадате с дашбордом");
        areElementsPresent();
        areDropDownElementsPresent();
        checkTextInElements();
        checkDropdownText();
    }

    @Step("Срванить название лиги в купоне с дашбордом")
    public boolean checkLeague() {
        //Получить название лиги из дашборда
        SelenideElement dashboardLeagueName = dashboard.getLeagueName();

        //Cравнить название лиги
        return leagueName.is(text(dashboardLeagueName.getText()));
    }

    @Step("Срванить название команд в купоне с дашбордом")
    public boolean checkTeams() {
        //Получить название команды из дашборда
        SelenideElement dashboardTeamsName = dashboard.getTeamsName();

        //Проверить названи команды удалив "-" из строки в купоне
        String teamName = teamsName.getText().replaceAll("-", "");
        return dashboardTeamsName.is(text(teamName));
    }

    @Step("Сравнить коэфициент в купоне с дашбордом")
    public void checkCoefficient() {
        //Получить коэфициент из дашборда
        SelenideElement dashboardCoefficient = dashboard.getCoefficient();
        //Проверить что коэффициент совпадает
        assertTrue(coefficient.is(text(dashboardCoefficient.getText())), "не корректный коэффициент");
    }

    @Step("Проверить отображение элементов в купоне")
    public void areElementsPresent() {
        //Проверить, отображение элементов в списке
        List<SelenideElement> elements = getCouponElements();
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }

    @Step("Проверить отображение элементов в lhjglfeyt")
    public void areDropDownElementsPresent() {
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

    @Step("Возвращаю коллекцию элементов в выпадающем списке")
    public List<SelenideElement> getDropDownElements() {
        //Создаю коллекцию из элементов дропдаун меню
        return Arrays.asList(dropDownConfirm, dropDownAcceptAnyChanges, dropDownAcceptWhenRise);
    }

    @Step("Проверка текстов в элементах купона")
    public void checkTextInElements() {
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
    public void checkDropdownText() {
        dropDown.click();
        dropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(SECONDS));
        dropDownAcceptWhenRise.shouldHave(text("Принять при повышении"));
        dropDownConfirm.shouldHave(text("Подтверждать"));
        dropDownAcceptAnyChanges.shouldHave(text("Принять любое изменение"));
    }

    @Step("Проверить тип коэффициента")
    public void checkCoefficientType(String value) {
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

        } else if (value == "Б") {
            coefficientType.shouldHave(text("Тотал"));

        } else if (value == "М") {
            coefficientType.shouldHave(text("Тотал"));

        } else if (value == "Фора1") {
            coefficientType.shouldHave(text("Фора 1"));

        } else if (value == "Фора2") {
            coefficientType.shouldHave(text("Фора 2"));

        } else if (value == "БИТ1") {
            coefficientType.shouldHave(text("Индивидуальный тотал 1"));

        } else if (value == "МИТ1") {
            coefficientType.shouldHave(text("Индивидуальный тотал 1"));
        }
    }

    @Step("Клик по кнопке очистить")
    public void clearCoupon() {
        clearButton.click();
    }

    @Step("Клик по кнопке удалить ставку")
    public void deleteRate() {
        deleteRateButton.click();
    }

    @Step("Проверить что купон не отображается")
    public void IsNotCouponVisible() {
        couponBet.shouldNotBe(visible);
    }

    @Step("Проверить что купон отображается")
    public void isCouponVisible() {
        couponBet.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

}
