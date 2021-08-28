package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TVPage {
    @FindBy(xpath = "//*[@id=\"schema-filter\"[text() = 'Производитель']]")
    private WebElement manufactureFilter;
    @FindBy(xpath = "//*[@id=\"schema-tags\"]")
    private WebElement selectedFilters;
    @FindBy(id = "\"schema-tags__item\"")
    private WebElement filtersItems;
//    @FindBy(xpath = "//*[@id=\"schema-filter\"[text() = 'Samsung']]")
//    private WebElement samsungFilter;
    @FindBy(xpath = "//input[@value='samsung']/..")
    private WebElement samsungFilter;
    @FindBy(xpath = "//input[@value='sony']/..")
    private WebElement sonyFilter;
    @FindBy(xpath = "//input[@value='bbk']")
    private WebElement BBKFilter;


    public void selectSamsungFilter(){
        samsungFilter.click();
    }

    public void selectSonyFilter() {
        sonyFilter.click();
    }

    public void scrollToBBK(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(BBKFilter);
        action.perform();
    }

    public List<WebElement> getSelectedFilters(){
       return selectedFilters.findElements(By.className("schema-tags__item"));

    }
}
