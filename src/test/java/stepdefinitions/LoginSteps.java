package stepdefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverFactory;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("The user is on the login page")
    public void iOpenTheLoginPage() throws InterruptedException {
        driver = WebDriverFactory.getDriver();  
        driver.get("https://ui.dev.flicportal.com/auth/login"); 
        loginPage = new LoginPage(driver);
        Thread.sleep(2000);
    }

    @When("The user enters a valid username and password")
    public void iEnterValidCredentials() throws InterruptedException {
        loginPage.enterUsername("Mukeshk.relayhumancloud.com"); 
        loginPage.enterPassword("Mukesh@123456");  
        Thread.sleep(2000);
    }
    @Then ("Click on Login button")
    public void Click_on_login_button() throws InterruptedException {
    	
    	loginPage.clickLoginButton();
    	Thread.sleep(2000);
    }
    @After
    public void tearDown() {
        WebDriverFactory.quitDriver(); // Clean up and quit the WebDriver session
    }
}
