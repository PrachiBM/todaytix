package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 35);
    }

    @FindBy(how = How.ID, using = "locations-select")
    private WebElement locationDropDown;

    @FindBy(how = How.ID, using = "navBarLogo")
    private WebElement appLogo;

    @FindBy(how = How.XPATH, using = "//*[@data-value='nyc']")
    private WebElement newYork;

    @FindBy(how = How.ID, using = "topBarSearch")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"searchBar\"]//*[text()=\"The Phantom of the Opera\"]")
    private WebElement selectShow;

    @FindBy(how = How.XPATH, using = "//img[@alt=\"The Phantom of the Opera on Broadway\"]")
    private WebElement phantomShowPage;

    @FindBy(how = How.XPATH, using = "//span[text()=\"Get tickets\"]")
    private WebElement getTickets;

    @FindBy(how = How.XPATH, using = "//a[text()=\"Skip for now\"]")
    private WebElement modalSkipButton;

    @FindBy(how = How.XPATH, using = "//*[text()=\"January\"]")
    private WebElement january;

    @FindBy(how = How.XPATH, using = "//*[text()=\"January\"]//parent::span//following-sibling::div")
    private WebElement rightArrow;

    @FindBy(how = How.XPATH, using = "//*[text()=\"24\"]")
    private WebElement date;

    @FindBy(how = How.NAME, using = "SHOW_DETAILS_SELECT_SHOWTIME_JUMP_REF")
    private WebElement shows;

    @FindBy(how = How.ID, using = "showtime-0-price")
    private WebElement showOne;

    @FindBy(how = How.XPATH, using = "//*[text()=\"Select section\"]")
    private WebElement selectSection;

    @FindBy(how = How.XPATH, using = "//*[text()=\"Premium\"]")
    private WebElement premium;

    @FindBy(how = How.XPATH, using = "//*[text()=\"Google Pay\"]")
    private WebElement googlePay;

    @FindBy(how = How.XPATH, using = "//*[text()=\"Credit Card\"]")
    private WebElement creditCard;

    @FindBy(how = How.NAME, using = "payment.creditCard")
    private WebElement creditCardNumber;

    @FindBy(how = How.NAME, using = "account.firstName")
    private WebElement firstName;

    @FindBy(how = How.NAME, using = "account.lastName")
    private WebElement lastName;

    @FindBy(how = How.NAME, using = "account.email")
    private WebElement email;

    @FindBy(how = How.NAME, using = "account.password")
    private WebElement password;

    @FindBy(how = How.NAME, using = "pickup.fullName")
    private WebElement personName;

    @FindBy(how = How.NAME, using = "pickup.email")
    private WebElement personEmail;

    @FindBy(how = How.NAME, using = "pickup.phone")
    private WebElement phoneNumber;


    public void selectCity(String city) {
        clickElement(locationDropDown);
        clickElement(newYork);
    }

    public void searchShow(String show) {
        enterKeys(searchBar, show);
        clickElement(selectShow);
    }

    public boolean verifyHomePageVisible() {
        return isElementVisible(appLogo);
    }

    public boolean verifyShowDisplayed() {
        return isElementVisible(phantomShowPage);
    }

    public void clickGetTicketButton() {
        clickElement(getTickets);
        if (isElementVisible(modalSkipButton)) {
            clickElement(modalSkipButton);
        }
    }

    public boolean verifyCalendarDisplayed() {
        return isElementVisible(january);
    }

    public void selectDate() {
        clickElement(rightArrow);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        List<WebElement> elementList = driver.findElements(By.xpath("//*[text()=\"24\"]"));
        for (WebElement element : elementList) {
            if (isElementVisible(element)) {
                clickElement(element);
                return;
            }
        }
    }

    public boolean isShowsDisplayed() {
        return isElementVisible(shows);
    }

    public void selectFirstShow() {
        clickElement(showOne);
    }

    public boolean isSelectSectionDisplayed() {
        return isElementVisible(selectSection);
    }

    public void selectSection() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        clickElement(premium);
    }

    public boolean isGooglePayVisible() {
        return isElementVisible(googlePay);
    }

    public boolean isCreditCardVisible() {
        return isElementVisible(creditCard);
    }

    public void fillFormAndSelectCard(String firstName, String lastName, String emailAddress, String password, String personName, String personEmail, String phoneNumber) {
        enterKeys(this.email, emailAddress);
        enterKeys(this.firstName, firstName);
        enterKeys(this.lastName, lastName);
        enterKeys(this.password, password);
        enterKeys(this.personName, personName);
        enterKeys(this.personEmail, personEmail);
        enterKeys(this.phoneNumber, phoneNumber);
        clickElement(creditCard);
    }

    public boolean isCreditCardNumberFieldDisplayed(){
        return isElementVisible(creditCardNumber);
    }
}
