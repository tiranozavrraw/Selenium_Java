package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.TVPage;


import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    WebDriver driver;
    private WebDriverWait wait;



    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://onliner.by");
    }
    @AfterEach
    public void turnOff() {
        driver.close();
    }

    @Test
    public void beautifulTest() {
        MainPage mainPage = new MainPage();
        PageFactory.initElements(driver, mainPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[@class='project-navigation__sign'][contains(text(),\"Телевизоры\")]]")));
        mainPage.selectTVInNavigationBar();
        TVPage tvPage = new TVPage();
        PageFactory.initElements(driver, tvPage);
        tvPage.scrollToBBK(driver);
        tvPage.selectSamsungFilter();
        tvPage.scrollToBBK(driver);
        tvPage.selectSonyFilter();
        var elements = tvPage.getSelectedFilters();
        if (elements.size() == 1){
            var element = elements.get(0);
            assertEquals("Sony", element.getText());
        } else {
            assertEquals(1, elements.size());
        }

    }


}
