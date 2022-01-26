

package qa.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    protected WebDriverWait wait;

    //TODO - To move - driver initialization within @Before hook
    public BasePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://todaytix.com");
    }

    //TODO - To move - quit driver to @After hook
    public void quitDriver() {
        driver.quit();
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public boolean isElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void enterKeys(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("step 4");
        element.sendKeys(value);
    }
}