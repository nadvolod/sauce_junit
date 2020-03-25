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
import pages.aig.AIGHomePage;
import pages.HomePage;
import pages.LogInPage;
import pages.SignUpPage;
import pages.aig.AIGInsurancePage;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private UserData validUser;
    private SignUpPage signUpPage;

    public SauceSession session;
    private UserData testUser;
    private HomePage homePage;
    private LogInPage loginPage;
    private AIGHomePage aigHomePage;
    private AIGInsurancePage aigInsurancePage;

    @io.cucumber.java.Before
    public void setup(Scenario scenario)
    {
        SauceOptions options = new SauceOptions();
        options.setName(scenario.getName());
        session = new SauceSession(options);
        RemoteWebDriver driver = session.start();
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
    @Given("a user is registered")
    public void a_user_is_registered() {
        //AuthenticationAPI authenticationAPI = new AuthenticationAPI();
        //testUser = authenticationAPI.createRandomUser();
    }

    @Given("a user navigates to the sign in page")
    public void a_user_navigates_to_the_sign_in_page() {
        homePage = new HomePage();
        homePage.visit();
    }
    @When("the user provides valid credentials")
    public void the_user_provides_valid_credentials() {
        loginPage = new LogInPage();
        loginPage.logIn(testUser);
    }
    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assertTrue(homePage.isLoggedIn());
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
}
