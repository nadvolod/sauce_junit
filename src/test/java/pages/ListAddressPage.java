package pages;

import com.saucelabs.framework.elements.Element;
import com.saucelabs.framework.pages.OnPage;
import org.openqa.selenium.By;
import data.AddressData;

@OnPage(path="/addresses")
public class ListAddressPage extends BasePage {

    private Element notice = browser.element(By.cssSelector("[data-test=notice]"));

    public boolean hasAddress(String id) {
        Element showID = browser.element(By.cssSelector("[data-test=show-" + id + "]"));
        return showID.doesExist();
    }

}
