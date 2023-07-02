package Pages.Locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardLocators {

    protected SelenideElement dashboard = $x("//div[@class='line-dashboard']");
    protected SelenideElement leagueName = dashboard.$x("descendant::div[@class='c-events__name'][1]");
    protected SelenideElement teamsName = dashboard.$x("descendant::span[@class='c-events__teams'][1]");
    protected SelenideElement acceptCookie = $x("//div[@class='f-policy']/descendant::div[text()='Продолжить']");
    protected SelenideElement coefficient = dashboard.$x("descendant::span[@class='c-bets__inner'][1]");
    protected SelenideElement coefficientTitle1 = $x("descendant::div[@title='1x2'][1]");
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

    public SelenideElement getTeamsName() {
        return teamsName;
    }

    public SelenideElement getLeagueName() {
        return leagueName;
    }

    public SelenideElement getCoefficient() {
        return coefficient;
    }
}
