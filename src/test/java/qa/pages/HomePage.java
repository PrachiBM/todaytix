package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage() {

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 50);
    }

    @FindBy(how = How.ID, using = "locations-select")
    private WebElement locationDropDown;

    @FindBy(how = How.ID, using = "navBarLogo")
    private WebElement appLogo;

    @FindBy(how = How.XPATH, using = "//*[@data-value='nyc']")
    private WebElement newYork;

    @FindBy(how = How.ID, using = "topBarSearch")
    private WebElement searchBar;

    public void selectCity(String city) {
        clickElement(locationDropDown);
        clickElement(newYork);
    }

    public void searchShow(String show) {
        enterKeys(searchBar, show);
    }

    public boolean verifyHomePageVisible() {
        return isElementVisible(appLogo);
    }

}
