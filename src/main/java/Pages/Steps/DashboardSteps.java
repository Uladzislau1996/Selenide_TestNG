package Pages.Steps;

import Pages.Locators.CouponLocators;
import Pages.Locators.DashboardLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static helper.SelenideHelper.SECONDS;

public class DashboardSteps extends DashboardLocators {

    CouponLocators coupon = new CouponLocators();

    @Step("Открыть главную страницу")
    public static DashboardSteps openPage() {
        open("/");
        return new DashboardSteps();
    }

    @Step("Принять куки, скрол к коэффициенту, проверка отображения события")
    public void Precondition() {
        acceptCookie.click();
        coefficient.shouldBe(Condition.visible);
        coefficient.scrollIntoView("false");
        dashboard.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

    @Step("Клик по коэффиценту ")
    public CouponSteps setCoefficient() {
        coefficient.click();
        coupon.getCoupon().shouldBe(visible, Duration.ofSeconds(SECONDS));
        return new CouponSteps();
    }

    @Step("Проверка текста тайтлов в коэффицентах дашборда")
    public DashboardSteps assertCoefficientTitleText() {
        coefficientTitle1.shouldHave(Condition.text("1"));
        coefficientTitleX.shouldHave(Condition.text("X"));
        coefficientTitle2.shouldHave(Condition.text("2"));
        coefficientTitle1x.shouldHave(Condition.text("1X"));
        coefficientTitle12.shouldHave(Condition.text("12"));
        coefficientTitle2x.shouldHave(Condition.text("2X"));
        coefficientTitleB.shouldHave(Condition.text("Б"));
        coefficientTitleTotal.shouldHave(Condition.text("Тотал"));
        coefficientTitleM.shouldHave(Condition.text("М"));
        coefficientTitleFora1.shouldHave(Condition.text("1"));
        coefficientTitleFora.shouldHave(Condition.text("Фора"));
        coefficientTitleFora2.shouldHave(Condition.text("2"));
        coefficientTitleIndividualTotalFirstTeam.shouldHave(Condition.text("Б"));
        coefficientTitleIndividualTotal.shouldHave(Condition.text("ИТ1"));
        coefficientTitleIndividualTotalSecondTeam.shouldHave(Condition.text("М"));
        return this;
    }

    @Step("Проверить дропдаун меню в тайтлах коэффициента")
    public DashboardSteps checkDropdownMenu() {
        //Создаю коллекцию элементов из элементов с выпадающим списком
        List<SelenideElement> dropdownElements = getElementsWithDropdown();

        //Проверяю текст в дропдаун меню
        for (SelenideElement element : dropdownElements) {
            element.shouldBe(visible, Duration.ofSeconds(SECONDS)).click();
            assertTextDropDown();
            isDropdownClickable();
        }

        return this;
    }

    @Step("Проверить текст в пунктах меню")
    public void assertTextDropDown() {
        dropDownX.shouldHave(Condition.text("X"));
        dropDown12.shouldHave(Condition.text("12"));
        dropDownTotal.shouldHave(Condition.text("Тотал"));
        dropDownFora.shouldHave(Condition.text("Фора"));
        dropDownIndividualTotal1.shouldHave(Condition.text("ИТ1"));
        dropDownIndividualTotal2.shouldHave(Condition.text("ИТ2"));
    }

    @Step("Проверить что элементы в дроп дауне кликабельны")
    public void isDropdownClickable() {
        List<SelenideElement> dropdownElements = getDropdownElements();

        //Проверить что элементы кликабельны
        for (SelenideElement element : dropdownElements) {
            element.shouldBe(Condition.enabled);
        }
    }

    @Step("Вернуть коллекцию элементов с пунктами меню")
    public List<SelenideElement> getDropdownElements() {
        List<SelenideElement> dropdownElements = Arrays.asList(dropDownX, dropDown12,
                dropDownTotal, dropDownFora, dropDownIndividualTotal1);
        return dropdownElements;
    }

    @Step("Вернуть коллекцию элементов с пунктами меню")
    public List<SelenideElement> getElementsWithDropdown() {
        List<SelenideElement> elementsWithDropdown = Arrays.asList(coefficientTitleX, coefficientTitle12,
                coefficientTitleTotal, coefficientTitleFora, coefficientTitleIndividualTotal);
        return elementsWithDropdown;
    }

    @Step("В зависимости от полученного значение кликаем на коэффициент")
    public CouponSteps setCoefficient(String value) {
        if (value == "1") {
            coefficient.click();

        } else if (value == "X") {
            coefficients.get(1).click();

        } else if (value == "2") {
            coefficients.get(2).click();

        } else if (value == "1X") {
            coefficients.get(3).click();

        } else if (value == "12") {
            coefficients.get(4).click();

        } else if (value == "2X") {
            coefficients.get(5).click();

        } else if (value == "Б") {
            coefficients.get(6).click();

        } else if (value == "М") {
            coefficients.get(7).click();

        } else if (value == "Фора1") {
            coefficients.get(8).click();

        } else if (value == "Фора2") {
            coefficients.get(9).click();

        } else if (value == "БИТ1") {
            coefficients.get(10).click();

        } else if (value == "МИТ1") {
            coefficients.get(11).click();
        }

        return new CouponSteps();
    }

    @Step("Дабл клик по коэффициенту")
    public CouponSteps doubleClickCoefficient() {
        coefficient.doubleClick();
        return new CouponSteps();
    }

    @Step("Получить название лиги")
    public String getLeagueName() {
        String league = leagueName.getText();
        return league;
    }

    @Step("Получить название команд")
    public String getTeamsName(){
        String teams = teamsName.getText();
        return teams;
    }

    @Step("Получить значение коэффициента")
    public String getCoefficient(){
        String text = coefficient.getText();
        return text;
    }

}

