package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private final String mainPage = "https://onliner.by";

    @FindBy (xpath = "//a[.//span[@class='project-navigation__sign'][contains(text(),\"Телевизоры\")]]")
    private WebElement tvInNavigationBar;

    @FindBy (className = "fast-search__input")
    private WebElement searchInput;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage performSearch(String text) {
        searchInput.sendKeys(text.substring(0, 1));
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.typeText(text.substring(1));
        return searchPage;
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
