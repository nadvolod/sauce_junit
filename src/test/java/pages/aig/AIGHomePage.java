package pages.aig;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@OnPage(urlPath = "/individual")
public class AIGHomePage extends BasePage {
    private Element searchIcon = browser.element(By.id("search-panel"));
    private Element searchBar = browser.element(By.id("header-input"));

    public void search(String searchString) {
        searchIcon.hover();
        searchIcon.click();
        searchBar.setText(searchString);
        searchBar.setText(Keys.ENTER.toString());
    }

    public SearchPage getSearchPage() {
        return new SearchPage();
    }
}
