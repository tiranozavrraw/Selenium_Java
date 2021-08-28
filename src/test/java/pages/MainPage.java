package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy (xpath = "//*[@class='project-navigation__sign'][contains(text(),'Телевизоры')]")
    private WebElement tv;
    @FindBy (xpath = "//a[.//span[@class='project-navigation__sign'][contains(text(),\"Телевизоры\")]]")
    private WebElement tvInNavigationBar;

    public void selectTVInNavigationBar() {
        tvInNavigationBar.click();
    }
    public void selectTVInNavigationBar2() {
        tv.click();
    }
}
