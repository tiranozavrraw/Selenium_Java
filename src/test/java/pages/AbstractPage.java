package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private final static int TIMEOUT_IN_SECONDS = 30;

    protected WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;
    private WebDriverWait driverWait;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected void scrollTo(WebElement webElement){
        Actions action = new Actions(getDriver());
        action.moveToElement(webElement);
        action.perform();
    }

    protected void waitUntilVisible(WebElement webElement){
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void openUrl(String url){
        getDriver().get(url);
    }
}
