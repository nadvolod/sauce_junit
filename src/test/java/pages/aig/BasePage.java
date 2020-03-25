package pages.aig;

import com.saucelabs.framework.pages.PageObject;
import lombok.Getter;

public class BasePage extends PageObject {
    @Getter
    private String baseURL = "https://www.aig.com";
}
