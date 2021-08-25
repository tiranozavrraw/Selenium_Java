import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage {
    @FindBy(xpath = "//*[@id=\"schema-filter\"[text() = 'Производитель']]")
    private WebElement manufactureFilter;
    @FindBy(xpath = "//*[@id=\"schema-tags\"]")
    private WebElement selectedFilters;
    @FindBy(id = "schema-filter")
    private WebElement filters;
//    @FindBy(xpath = "//*[@id=\"schema-filter\"[text() = 'Samsung']]")
//    private WebElement samsungFilter;
    @FindBy(xpath = "//input[@value='samsung']/..")
    private WebElement samsungFilter;
    @FindBy(xpath = "//input[@value='bbk']")
    private WebElement BBKFilter;
    public void selectSamsungFilter(){
        samsungFilter.click();

    }
}
