package pages;

import com.saucelabs.framework.elements.Element;
import org.openqa.selenium.By;

public class EditAddressPage extends BasePage {

    private Element firstName = browser.element(By.id("address_first_name"));
    private Element lastName = browser.element(By.id("address_last_name"));
    private Element streetAddress = browser.element(By.id("address_street_address"));
    private Element secondaryAddress = browser.element(By.id("address_secondary_address"));
    private Element city = browser.element(By.id("address_city"));
    private Element zipCode = browser.element(By.id("address_zip_code"));
    private Element submit = browser.element(By.name("commit"));

    public void visit(String id) {
        browser.get("https://address-book-example.herokuapp.com/addresses/" + id + "/edit");
    }

}
