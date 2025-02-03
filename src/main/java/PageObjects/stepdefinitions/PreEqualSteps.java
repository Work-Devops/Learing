package PageObjects;

import PageObjects.LoginPage;
import PageObjects.Prequal;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;
import utils.WebDriverFactory;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

import java.sql.DriverManager;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

public class PreEqualSteps {

    private WebDriver driver;
    private Prequal prequalPage;
    private LoginPage loginPage;
    private Prequal prequal;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();  // use factory method here
        prequalPage = new Prequal(driver);
        loginPage = new LoginPage(driver);
        prequal = new Prequal(driver);

            
           
        }

    

    @Given("The user is on the login page")
    public void iOpenTheLoginPage() throws InterruptedException {
        driver = WebDriverFactory.getDriver();  
        driver.get("https://ui.dev.flicportal.com/auth/login"); 
        loginPage = new LoginPage(driver);
        Thread.sleep(2000);
       
    }

    @When("The user enters a valid username and password")
    public void iEnterValidCredentials() throws InterruptedException {
        loginPage.enterUsername("kishan-ec4@yopmail.com"); 
        loginPage.enterPassword("Test@123");  
        Thread.sleep(2000);
    }
    @And ("Click on Login button")
    public void Click_on_login_button() throws InterruptedException {
    	
    	loginPage.clickLoginButton();
    	Thread.sleep(2000);
    	
    }
    
    @Then("The user should redirect to home page")
    public void The_user_should_redirect_to_home_page() {
        String baseUrl = System.getProperty("base.url", "https://ui.dev.flicportal.com/pipelines");
        driver.get(baseUrl);  
    }
    
    @When("The user clicks on \"Start Application\"")
    public void clickStartApplicationButton() throws InterruptedException {
        prequalPage.clickStartApplicationButton(); 
        
        Thread.sleep(2000);

    }

    
    @And("The user selects {string}")
    public void theUserSelects(String applicationType) throws InterruptedException {
        if (applicationType.equalsIgnoreCase("Pre-Equal Application")) {
            prequalPage.startPreQualApplicationLink();
        } else {
            throw new IllegalArgumentException("Unsupported application type: " + applicationType);
     
        }
        Thread.sleep(2000);
        
    }
    
    @When("The user enters valid borrower details")
    public void theBorrowerFillsInTheirDetails() {

        String firstName = "Margaret";
        String lastName = "Grayson";
        String ssn = "666199131";
        String dob = "03/16/1977";
        String street = "52 sweetgum";
        String city = "lake Jackson";
        String zipCode = "77566";
        String grossAnnualIncome = "50000";
        String years = "10";
        String months = "12";

       

        // Submit or proceed further
        prequal.fillBorrowerDetails(firstName, lastName, ssn, dob, street, city, zipCode, grossAnnualIncome, years, months);
    }



}
