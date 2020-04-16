package cucumber;

import com.saucelabs.framework.Browser;
import com.saucelabs.framework.pages.PageObject;
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import data.UserData;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.SignUpPage;
import pages.aig.AIGBusinessPage;
import pages.aig.AIGHomePage;
import pages.aig.AIGInsurancePage;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private UserData validUser;
    private SignUpPage signUpPage;

    public SauceSession session;
    private HomePage addressAppHomePage;
    private AIGHomePage aigHomePage;
    private AIGInsurancePage aigInsurancePage;
    private RemoteWebDriver driver;
    private AIGBusinessPage aigBusinessPage;
    private Scenario scenarioInfo;

    @io.cucumber.java.Before
    public void setup(Scenario scenario)
    {
        scenarioInfo = scenario;
        SauceOptions options = new SauceOptions();
        options.setName(scenario.getName());
        options.setCapturePerformance(true);
        options.setExtendedDebugging(true);
        session = new SauceSession(options);
        driver = session.start();
        Browser browser = new Browser(driver);
        PageObject.setBrowser(browser);
    }
    @io.cucumber.java.After
    public void after(Scenario scenario)
    {
        session.stop(!scenario.isFailed());
    }

    @Given("a user navigates to the sign up page")
    public void a_user_navigates_to_the_sign_up_page() {
        signUpPage = new SignUpPage();
        signUpPage.visit();
    }

    @When("a user enters valid information")
    public void a_user_enters_valid_information() {
        validUser = new UserData().getValidUser();
        signUpPage.signUp(validUser);
    }
    @Then("the user is successfully registered")
    public void the_user_is_successfully_registered() {
        assertTrue(new HomePage().isLoggedIn(validUser));
    }

    @Given("a user navigates to the sign in page")
    public void a_user_navigates_to_the_sign_in_page() {
        addressAppHomePage = new HomePage();
        addressAppHomePage.visit();
    }
    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assertTrue(addressAppHomePage.isLoggedIn());
    }
    @Given("a user opens a browser")
    public void a_user_opens_a_browser() {
        //do nothing
    }

    @When("a user navigates to the AIG home page")
    public void a_user_navigates_to_the_AIG_home_page() {
        aigHomePage = new AIGHomePage();
        aigHomePage.visit();
    }
    @Then("the user sees the page render successfully")
    public void the_user_sees_the_page_render_successfully() {
        assertTrue("We visited the AIG Home Page and expect it to render",
                aigHomePage.isOnPage());
    }

    @When("a user opens the AIG insurance page")
    public void aUserOpensTheAIGInsurancePage() {
        aigInsurancePage = new AIGInsurancePage();
        aigInsurancePage.visit();
    }

    @Then("the user sees the insurance page render successfully")
    public void theUserSeesTheInsurancePageRenderSuccessfully() {
        assertTrue("We opened the Insurance page in the browser and expect it to render",
                aigInsurancePage.isOnPage());
    }

    @Then("the page loads within established baseline")
    public void thePageLoadsInUnderSeconds() {
        Map<String, Object> desiredPerformanceMetrics = new HashMap();
        String metrics[] = { "speedIndex" };
        desiredPerformanceMetrics.put("metrics", metrics);
        desiredPerformanceMetrics.put("name", scenarioInfo.getName());
        Map<String, Object> performance =
                (Map<String, Object>) driver.executeScript("sauce:performance", desiredPerformanceMetrics);
        assertEquals("pass", performance.get("result"));
    }

    @Then("the user sees the Business page render sucessfully")
    public void theUserSeesTheBusinessPageRenderSuccessfully() {
        assertTrue(aigBusinessPage.isOnPage());
    }

    @When("a user navigates to the AIG business page")
    public void aUserNavigatesToTheAIGBusinessPage() {
        aigBusinessPage = new AIGBusinessPage();
        aigBusinessPage.visit();
    }

    @When("a user searches for {string}")
    public void aUserSearchesFor(String searchString) {
        aigHomePage.search(searchString);
    }

    @Then("some results come back")
    public void someResultsComeBack() {
        assertTrue(aigHomePage.getSearchPage().hasSearchResults());
    }
}
