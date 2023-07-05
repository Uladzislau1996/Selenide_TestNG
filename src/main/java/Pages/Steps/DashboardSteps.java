package Pages.Steps;

import Pages.Locators.CouponLocators;
import Pages.Locators.DashboardLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static helper.SelenideHelper.SECONDS;
import static org.testng.Assert.assertTrue;

public class DashboardSteps extends DashboardLocators {

    CouponLocators coupon = new CouponLocators();

    @Step("Открыть главную страницу")
    public static DashboardSteps openPage() {
        open("/");
        return new DashboardSteps();
    }

    @Step("Принять куки, скрол к коэффициенту, проверка отображения события")
    public DashboardSteps setPrecondition() {
        acceptCookie();
        isCoefficientVisible();
        scrollToCoefficient();
        isDashboardVisible();
        return this;
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

    @Step("Проверить дропдаун меню в каждом тайтле коэффициента")
    public DashboardSteps checkDropdownMenu() {
        //Проверяю текст в дропдаун меню
        for (SelenideElement element : getElementsWithMenu()) {
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
        //Проверить что элементы кликабельны
        for (SelenideElement element : getDropdownElements()) {
            element.shouldBe(Condition.enabled);
        }
    }

    @Step("Сравнить кол-во ставок в кнопке moreBets с кол-вом ставок в раскрывающимся списке")
    public DashboardSteps compareBetsNumber() {
        assertTrue(getBetsNumber().contains(getIconNumber()), "Не совпадает кол-во ставокв в кнопке moreBets" +
                "с кол-вом в раскрывающимся списке");
        return this;
    }

    @Step("В зависимости от полученного значение кликаем на коэффициент")
    public CouponSteps setCoefficient(String value) {
        if (value == "1") {
            setCoefficient(0);

        } else if (value == "X") {
            setCoefficient(1);

        } else if (value == "2") {
            setCoefficient(2);

        } else if (value == "1X") {
            setCoefficient(3);

        } else if (value == "12") {
            setCoefficient(4);

        } else if (value == "2X") {
            setCoefficient(5);

        } else if (value == "Б") {
            setCoefficient(6);

        } else if (value == "М") {
            setCoefficient(7);

        } else if (value == "Фора1") {
            setCoefficient(8);

        } else if (value == "Фора2") {
            setCoefficient(9);

        } else if (value == "БИТ1") {
            setCoefficient(10);

        } else if (value == "МИТ1") {
            setCoefficient(11);
        }

        return new CouponSteps();
    }

    @Step("В зависимости от полученного значение получить значение коэффициента")
    public String getCoefficient(String value) {
        String text = "";

        if (value == "1") {
            text = getCoefficientData(0);

        } else if (value == "X") {
            text = getCoefficientData(1);

        } else if (value == "2") {
            text = getCoefficientData(2);

        } else if (value == "1X") {
            text = getCoefficientData(3);

        } else if (value == "12") {
            text = getCoefficientData(4);

        } else if (value == "2X") {
            text = getCoefficientData(5);

        } else if (value == "Б") {
            text = getCoefficientData(6);

        } else if (value == "М") {
            text = getCoefficientData(7);
            ;

        } else if (value == "Фора1") {
            text = getCoefficientData(8);
            ;

        } else if (value == "Фора2") {
            text = getCoefficientData(9);
            ;

        } else if (value == "БИТ1") {
            text = getCoefficientData(10);
            ;

        } else if (value == "МИТ1") {
            text = getCoefficientData(11);
            ;
        }
        return text;
    }


}

