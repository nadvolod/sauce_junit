package pages.aig;

import com.saucelabs.framework.pages.OnPage;

@OnPage(url = "/individual")
public class AIGHomePage extends BasePage {
    public void visit()
    {
        browser.get(getBaseURL());
    }
}
