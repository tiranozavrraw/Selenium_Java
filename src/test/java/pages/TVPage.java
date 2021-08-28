package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TVPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"schema-tags\"]")
    private WebElement selectedFilters;

    @FindBy(xpath = "//input[@value='samsung']/..")
    private WebElement samsungFilter;

    @FindBy(xpath = "//input[@value='sony']/..")
    private WebElement sonyFilter;

    @FindBy(xpath = "//input[@value='bbk']")
    private WebElement BBKFilter;

    public TVPage(WebDriver driver) {
        super(driver);
    }

    public TVPage selectSamsungFilter(){
        scrollToBBK();
        waitUntilVisible(samsungFilter);
        samsungFilter.click();
        return this;
    }

    public TVPage selectSonyFilter() {
        scrollToBBK();
        waitUntilVisible(sonyFilter);
        sonyFilter.click();
        return this;
    }

    private TVPage scrollToBBK() {
        scrollTo(BBKFilter);
        return this;
    }

    public List<WebElement> getSelectedFilters(){
       return selectedFilters.findElements(By.className("schema-tags__item"));
    }
}
