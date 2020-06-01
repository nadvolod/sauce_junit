package pages.address;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import org.openqa.selenium.By;

@OnPage(urlPath="/addresses")
public class ListAddressPage extends BasePage {

    private Element notice = browser.element(By.cssSelector("[data-test=notice]"));

    public boolean hasAddress(String id) {
        Element showID = browser.element(By.cssSelector("[data-test=show-" + id + "]"));
        return showID.doesExist();
    }

}
