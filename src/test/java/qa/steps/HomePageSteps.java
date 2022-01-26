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
}
