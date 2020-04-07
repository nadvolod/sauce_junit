package pages;

import com.saucelabs.framework.elements.Element;
import com.saucelabs.framework.pages.OnPage;
import org.openqa.selenium.By;
import data.UserData;

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
