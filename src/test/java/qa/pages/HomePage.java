package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage() {

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 50);
    }

    @FindBy(how = How.ID, using = "mobile-locations")
    private WebElement locationDropDown;

    @FindBy(how = How.ID, using = "navBarLogo")
    private WebElement appLogo;

    public void selectCity(String city) {
        clickElement(locationDropDown);
    }

    public boolean verifyHomePageVisible() {
        return isElementVisible(appLogo);
    }

}
