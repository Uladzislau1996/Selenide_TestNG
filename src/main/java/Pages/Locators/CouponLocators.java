package Pages.Locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CouponLocators {

    protected SelenideElement couponBet = $x("//section[@class='bet-info']");
    protected SelenideElement clearButton = $x("//div[@id='clearAllBetsBlock']");
    protected SelenideElement deleteRateButton = $x("//div[@title='Удалить ставку']");
    protected SelenideElement leagueName = $x("//div[@class='liga']");
    protected SelenideElement teamsName = $x("//div[@class='teams']");
    protected SelenideElement coefficient = $x("//div[@id='all_bets']/descendant::span[2]");
    protected SelenideElement coefficientType = $x("//span[@class='type-name']");
    protected SelenideElement priceBets = $x("//div[@id='price_bets']");
    protected SelenideElement stakeAmount = $x("//span[text()='KES']/..");
    protected SelenideElement stakeAmountCounter = priceBets.$x("descendant::div[@class='rc'][1]");
    protected SelenideElement maximumBet = priceBets.$x("descendant::div[@class='lc'][3]");
    protected SelenideElement maximumBetCounter = $x("//span[@id='summ_max']");
    protected SelenideElement possibleWin = priceBets.$x("descendant::div[@class='lc'][4]");
    protected SelenideElement possibleWinCounter = priceBets.$x("descendant::div[@class='rc'][4]");
    protected SelenideElement changingCoefficient = $x("//div[@title='При изменении коэффициента']");
    protected SelenideElement dropDown = priceBets.$x("descendant::span[@class='multiselect__single']");
    protected SelenideElement dropDownAcceptWhenRise = $x("//span[normalize-space(text())=" +
            "'Принять при повышении']");
    protected SelenideElement dropDownConfirm = $x("//span[@class='multiselect__single' " +
            "and contains(text(),'Подтверждать')]");
    protected SelenideElement dropDownAcceptAnyChanges = $x("//span[text()='Принять любое изменение']");
    protected SelenideElement promoCode = $x("//div[@title='Промо-код']");
    protected SelenideElement promoCodeTextField = $x("//div[@title='Промо-код']" +
            "/following-sibling::div");

    //Метод гет предназначен для класса DashboardSteps
    public SelenideElement getCoupon() {
        return couponBet;
    }
}
