package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private final String mainPage = "https://onliner.by";

    @FindBy (xpath = "//a[.//span[@class='project-navigation__sign'][contains(text(),\"Телевизоры\")]]")
    private WebElement tvInNavigationBar;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TVPage selectTVInNavigationBar() {
        waitUntilVisible(tvInNavigationBar);
        tvInNavigationBar.click();

        TVPage tvPage = new TVPage(getDriver());
        return tvPage;
    }
    public MainPage open(){
        openUrl(mainPage);
        return this;
    }
}
