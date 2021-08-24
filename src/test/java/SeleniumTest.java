import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {
    @Test
    public void testTurnOffFilter(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/div/div[1]/ul[1]/li/a/span")).click();
        var filterForScroll = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[10]/label/span[1]/span"));
        var filter = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[2]/label/span[1]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(filterForScroll);
        actions.perform();
        filter.click();
        var changedFilter = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[2]/label/span[1]/span"));
        assertFalse(changedFilter.isSelected());

    }
    @Test
    public void testChangeFilter() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/div/div[1]/ul[1]/li/a/span")).click();
        var filterForScroll = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[10]/label/span[1]/span"));
        var filter = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[2]/label/span[1]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(filterForScroll);
        actions.perform();
        filter.click();
        Thread.sleep(10000);
        var filterForScroll2 = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[10]/label/span[1]/span"));
        Actions action = new Actions(driver);
        action.moveToElement(filterForScroll2);
        action.perform();
        var changedFilter = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[2]/label/span[1]/span"));
        if (!changedFilter.isSelected()){
            var filterToSelect = driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/ul/li[5]/label/span[1]/span"));
            filterToSelect.click();
        }
        var selectedFilters = driver.findElement(By.xpath("//*[@id=\"schema-tags\"]"));
        var xiaomiFilter = driver.findElement(By.xpath("//*[@id=\"schema-tags\"]/div[1]"));
        List<WebElement> elements = selectedFilters.findElements(By.className("schema-tags__item"));
        if (elements.size() == 1){
            var element = elements.get(0);
            assertEquals("Xiaomi", element.getText());
        } else {
            assertEquals(1, elements.size());
        }


    }



}
