package qa.steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import qa.pages.HomePage;

public class HomePageSteps {
    HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Given("^User in on application home page$")
    public void verifyApplicationHomePage() {
        Assert.assertTrue(homePage.verifyHomePageVisible());
    }

    @Given("^User selects the ([^\"]*) city$")
    public void selectCity(String city) {
        homePage.selectCity(city);
    }

    @Given("^User searches ([^\"]*) show$")
    public void searchShow(String show) {
        homePage.searchShow(show);
        Assert.assertTrue(homePage.verifyShowDisplayed());
    }

    @Given("the show page is displayed")
    public void verifyShowIsVisible() {
        Assert.assertTrue(homePage.verifyShowDisplayed());

    }

    @Given("User clicks on Get Tickets")
    public void clickGetTicket() {
        homePage.clickGetTicketButton();
        Assert.assertTrue(homePage.verifyCalendarDisplayed());
    }

    @Given("User selects a date and shows are displayed")
    public void selectDate() {
        homePage.selectDate();
        Assert.assertTrue(homePage.isShowsDisplayed());
    }

    @Given("User selects a show and selectSection is displayed")
    public void selectShow() {
        homePage.selectFirstShow();
        Assert.assertTrue(homePage.isSelectSectionDisplayed());
    }

    @Given("User selects a section and user form and two payment options displayed")
    public void selectSection() {
        homePage.selectSection();
        Assert.assertTrue(homePage.isGooglePayVisible());
        Assert.assertTrue(homePage.isCreditCardVisible());
    }

    @Given("^User enters form data with ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) ([^\"]*) values$")
    public void form(String firstName, String lastName, String emailAddress, String password, String personName, String personEmail, String phoneNumber) {
        homePage.fillFormAndSelectCard(firstName, lastName, emailAddress, password, personName, personEmail, phoneNumber);
        Assert.assertTrue(homePage.isCreditCardNumberFieldDisplayed());
    }

}
