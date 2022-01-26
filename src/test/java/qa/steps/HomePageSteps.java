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

    @Given("^User selects ([^\"]*) show$")
    public void searchShow(String show) {
        System.out.println("step 2");
        homePage.searchShow(show);
    }

}
