package pages.aig;

import com.saucelabs.framework.pages.OnPage;
import org.openqa.selenium.By;

@OnPage(url = "/search-results")
public class SearchPage extends BasePage {
    public boolean hasSearchResults() {
        return browser.element(By.xpath("//*[@id='itemContainer']//li")).doesExist();
        //return browser.element(By.cssSelector("#itemContainer li")).doesExist();
    }
}
