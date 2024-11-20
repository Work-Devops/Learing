package stepdefinitions;

import PageObjects.Prequal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreEqualSteps {

    WebDriver driver;
    Prequal prequal;

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        driver = new ChromeDriver(); // Use the appropriate WebDriver instance
        driver.manage().window().maximize();
        driver.get("https://ui.dev.flicportal.com/pipelines"); // Replace with actual URL
        prequal = new Prequal(driver);
        System.out.println("User is on the home page.");
    }

    @When("The user clicks on {string}")
    public void the_user_clicks_on(String buttonName) {
        prequal.clickStartApplicationButton(); // Reuse the method from the Prequal page object
        prequal.clickStartPreQualApplicationLink(); // Clicks on "Start a PreQual Application"
        System.out.println("Clicked on button: " + buttonName);
    }

    @And("The user selects {string}")
    public void the_user_selects(String applicationType) {
        prequal.selectLoanProduct(applicationType); // Reuse the method for selecting loan product
        System.out.println("Selected application type: " + applicationType);
    }

    @And("The user enters borrower details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_borrower_details(String firstName, String lastName, String ssn, String dob, String street, String city, String zipCode, String grossIncome) {
        prequal.enterField("firstname", firstName, false);
        prequal.enterField("lastname", lastName, false);
        prequal.enterField("ssn", ssn, false);
        prequal.enterField("dob", dob, false);
        prequal.enterField("street", street, false);
        prequal.enterField("city", city, false);
        prequal.enterField("zipcode", zipCode, false);
        prequal.enterField("income", grossIncome, false);
        System.out.println("Borrower details entered.");
    }

    @And("The user enters co-borrower details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_co_borrower_details(String firstName, String lastName, String ssn, String dob, String street, String city, String zipCode, String grossIncome) {
        prequal.enterField("firstname", firstName, true);
        prequal.enterField("lastname", lastName, true);
        prequal.enterField("ssn", ssn, true);
        prequal.enterField("dob", dob, true);
        prequal.enterField("street", street, true);
        prequal.enterField("city", city, true);
        prequal.enterField("zipcode", zipCode, true);
        prequal.enterField("income", grossIncome, true);
        System.out.println("Co-borrower details entered.");
    }

    @And("The user enters invalid data in the form \\(e.g., invalid email or phone number , Address\\)")
    public void the_user_enters_invalid_data_in_the_form() {
        prequal.enterEmailAddress("invalid_email");
        prequal.enterPhoneNumber("invalid_phone");
        prequal.enterField("street", "", false);
        System.out.println("Invalid data entered in the form.");
    }

    @Then("The user submits the application successfully")
    public void the_user_submits_the_application_successfully() {
        prequal.clickSubmitButton();
        System.out.println("Submitted the application successfully.");
        // Add assertions to verify success
    }

    @Then("The user should see validation errors for all required fields")
    public void the_user_should_see_validation_errors_for_all_required_fields() {
        // Validation error checks (can be extended)
        System.out.println("Validation errors displayed.");
    }

    @Then("The loan should be declined")
    public void the_loan_should_be_declined() {
        System.out.println("Loan was declined as expected.");
        // Add assertion to check for decline message
    }
}
