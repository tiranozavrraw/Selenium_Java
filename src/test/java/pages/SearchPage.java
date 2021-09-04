package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AbstractPage{

    @FindBy(className = "search__input")
    private WebElement iFrameSearchInput;

    @FindBy(className = "modal-iframe")
    private WebElement iFrameWithResults;

    @FindBy(className = "product__title")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void typeText(String text) {
        getDriver().switchTo().frame(iFrameWithResults);
        iFrameSearchInput.sendKeys(text);
        getDriver().switchTo().parentFrame();
    }

    public List<String> getSearchResultTitles(){
        getDriver().switchTo().frame(iFrameWithResults);
        var results = searchItems.stream().map(s->s.getText()).collect(Collectors.toList());
        getDriver().switchTo().parentFrame();
        return results;

    }
}
