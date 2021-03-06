package pages.address;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import data.UserData;
import org.openqa.selenium.By;

@OnPage(urlPath="/sign_up")
public class SignUpPage extends BasePage {

    private Element email = browser.element(By.id("user_email"));
    private Element password = browser.element(By.id("user_password"));
    private Element submit = browser.element(By.cssSelector("[data-test=submit]"));

    public void signUp(UserData validUser) {
        email.setText(validUser.getEmail());
        password.setText(validUser.getPassword());
        submit.click();
    }
}
