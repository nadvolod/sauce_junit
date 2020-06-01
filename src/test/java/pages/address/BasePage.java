package pages.address;

import com.saucelabs.salsaverde.pages.PageObject;
import lombok.Getter;

public class BasePage extends PageObject {
    @Getter
    private String baseURL = "https://address-book-example.herokuapp.com";
}
