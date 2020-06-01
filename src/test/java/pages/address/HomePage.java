package pages.address;

import com.saucelabs.salsaverde.elements.Element;
import com.saucelabs.salsaverde.pages.OnPage;
import data.UserData;
import org.openqa.selenium.By;

@OnPage(urlPath="/")
public class HomePage extends BasePage {
    private Element logOut = browser.element(By.cssSelector("[data-test=sign-out]"));
    private Element currentUser = browser.element(By.cssSelector("[data-test=current-user]"));

    public void logOut() {
        logOut.click();
    }

    public boolean isLoggedIn() {
        return logOut.doesExist();
    }

    public boolean isLoggedIn(UserData userData) {
        return userData.getEmail().equals((currentUser.getText()));
    }
}
