package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest extends BaseTest{

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

        var results = tvPage.getResultList();
        var notSony =results.stream().filter(x->!x.getText().contains("Sony"));
        assertEquals(0, notSony.count());
    }

    @Test
    public void testSearch() {
        var searchPage = new MainPage(driver)
                .open()
                .performSearch("Яндекс Станция")
                .getSearchResultTitles();
        //Assertion should be here someday maybe
    }
}
