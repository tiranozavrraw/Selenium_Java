package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterEach
    public void turnOff() {
        driver.close();
    }

    @Test
    public void beautifulTest() {
        var tvPage = new MainPage(driver)
                .open()
                .selectTVInNavigationBar()
                .selectSamsungFilter()
                .selectSonyFilter();

        var elements = tvPage.getSelectedFilters();
        assertEquals(1, elements.size());
        var element = elements.get(0);
        assertEquals("Sony", element.getText());

    }
}
