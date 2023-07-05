package Pages.Locators;

import Pages.Steps.CouponSteps;
import Pages.Steps.DashboardSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static helper.SelenideHelper.SECONDS;

public class DashboardLocators {

    protected SelenideElement dashboard = $x("//div[@class='line-dashboard']");
    protected SelenideElement leagueName = dashboard.$x("descendant::div[@class='c-events__name'][1]");
    protected SelenideElement teamsName = dashboard.$x("descendant::span[@class='c-events__teams'][1]");
    protected SelenideElement acceptCookie = $x("//div[@class='f-policy']/descendant::div[text()='Продолжить']");
    protected SelenideElement coefficient = dashboard.$x("descendant::span[@class='c-bets__inner'][1]");
    protected SelenideElement coefficientTitle1 = dashboard.$x("descendant::div[@title='1x2'][1]");
    protected SelenideElement coefficientTitleX = dashboard.$x("descendant::div[@title='Ничья'][1]");
    protected SelenideElement coefficientTitle2 = dashboard.$x("descendant::div[@title='1x2'][2]");
    protected SelenideElement coefficientTitle1x = dashboard.$x("descendant::div[@title='Победа 1 или ничья'][1]");
    protected SelenideElement coefficientTitle12 = dashboard.$x("descendant::div[@title='Победа 1 или победа 2'][1]");
    protected SelenideElement coefficientTitle2x = dashboard.$x("descendant::div[@title='Ничья или победа 2'][1]");
    protected SelenideElement coefficientTitleB = dashboard.$x("descendant::div[@title='Тотал больше'][1]");
    protected SelenideElement coefficientTitleTotal = dashboard.$x("descendant::div[@title='Тотал'][1]");
    protected SelenideElement coefficientTitleM = dashboard.$x("descendant::div[@title='Тотал меньше'][1]");
    protected SelenideElement coefficientTitleFora1 = dashboard.$x("descendant::div[@title='Фора 1 команды'][1]");
    protected SelenideElement coefficientTitleFora = dashboard.$x("descendant::div[@title='Параметр форы'][1]");
    protected SelenideElement coefficientTitleFora2 = dashboard.$x("descendant::div[@title='Фора 2 команды'][1]");
    protected SelenideElement coefficientTitleIndividualTotalFirstTeam = dashboard
            .$x("descendant::div[@title='Индивидуальный тотал 1 команды больше'][1]");
    protected SelenideElement coefficientTitleIndividualTotal = dashboard
            .$x("descendant::div[@title='Параметр индивидуального тотала'][1]");
    protected SelenideElement coefficientTitleIndividualTotalSecondTeam = dashboard
            .$x("descendant::div[@title='Индивидуальный тотал 1 команды меньше'][1]");

    protected SelenideElement coefficientDropDown = $x("//ul[@class='b-markets-list']");
    protected SelenideElement dropDownX = coefficientDropDown.$x("descendant::li[@title='Ничья']");
    protected SelenideElement dropDown12 = coefficientDropDown
            .$x("descendant::li[@title='Победа 1 или победа 2']");
    protected SelenideElement dropDownTotal = coefficientDropDown.
            $x("descendant::li[@title='Тотал']");
    protected SelenideElement dropDownFora = coefficientDropDown.
            $x("descendant::li[@title='Параметр форы']");
    protected SelenideElement dropDownIndividualTotal1 = coefficientDropDown.
            $x("descendant::li[@title='Параметр индивидуального тотала'][1]");
    protected SelenideElement dropDownIndividualTotal2 = coefficientDropDown
            .$x("descendant::li[@title='Индивидуальный тотал 2']");

    protected ElementsCollection coefficients = dashboard.$$x("descendant::span[@class='c-bets__inner']");

    protected SelenideElement moreBetsButton = dashboard.$x("descendant::div[@class='c-events__more-wrap'][1]");

    protected SelenideElement moreBetsIcon = dashboard.$x("descendant::span[@class='scoreboard-nav__btn-label'][1]");

    protected SelenideElement moreBetsMenu = dashboard.$x("descendant::div[@class='c-events__moreEvs']");

    @Step("Открыть список со всеми ставками")
    public DashboardSteps openMoreBetsMenu() {
        moreBetsButton.shouldBe(visible).click();
        return new DashboardSteps();
    }

    @Step("Дабл клик по меню со всеми ставками")
    public DashboardSteps doubleClickMoreBetsMenu() {
        moreBetsButton.shouldBe(visible).doubleClick();
        return new DashboardSteps();
    }

    @Step("Даблклик по коэффицинету")
    public CouponSteps doubleClickCoefficient() {
        coefficient.shouldBe(visible).doubleClick();
        return new CouponSteps();
    }

    public void acceptCookie() {
        acceptCookie.click();
    }

    public CouponSteps setCoefficient() {
        coefficient.shouldBe(visible).click();
        return new CouponSteps();
    }

    public CouponSteps setCoefficient(int number) {
        coefficients.get(number).click();
        return new CouponSteps();
    }

    public String getLeagueName() {
        String league = leagueName.getText();
        return league;
    }

    public String getTeamsName() {
        String teams = teamsName.getText().replaceAll("[-\\s]", "");
        return teams;
    }

    public String getCoefficient() {
        String text = coefficient.getText();
        return text;
    }

    public String getCoefficientData(int number) {
        return coefficients.get(number).getText();
    }

    public String getBetsNumber() {
        String text = moreBetsButton.getText();
        return text;
    }

    public String getIconNumber() {
        String text = moreBetsIcon.getText();
        return text;
    }

    public void isDashboardVisible() {
        dashboard.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

    public void isCoefficientVisible() {
        coefficient.shouldBe(Condition.visible);
    }

    public DashboardSteps isMoreBetsMenuNotVisible() {
        moreBetsMenu.shouldNotBe(visible);
        return new DashboardSteps();
    }

    //Скрол к коэффициенту
    public void scrollToCoefficient() {
        coefficient.scrollIntoView("false");
    }


    //Получить список элементов с дропдаун меню
    public List<SelenideElement> getDropdownElements() {
        List<SelenideElement> dropdownElements = Arrays.asList(dropDownX, dropDown12,
                dropDownTotal, dropDownFora, dropDownIndividualTotal1);

        return dropdownElements;
    }

    //Получить список элементов содержащих дропдаун меню
    public List<SelenideElement> getElementsWithMenu() {
        List<SelenideElement> elementsWithDropdown = Arrays.asList(coefficientTitleX, coefficientTitle12,
                coefficientTitleTotal, coefficientTitleFora, coefficientTitleIndividualTotal);

        return elementsWithDropdown;
    }


}
