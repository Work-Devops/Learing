package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Prequal {

    private WebDriver driver;

    // Constructor
    public Prequal(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By startApplicationButtonField = By.xpath("(//button[@id='dropdown-split-basic'])[2]");
    
    By childElementLocator = By.xpath("//div[contains(@class,'dropdown-menu') and contains(@class,'show')]//a[contains(text(), 'Start a PreQual Application')]");
    
//    private By startPreQualApplicationLink = By.xpath("//*[@id=root]/div[2]/div[2]/div[2]/div[1]/div[2]/div/a[1]");

    private By loanProductDropdownField = By.cssSelector("form-select");
    private By firstNameField = By.cssSelector("input[placeholder='First Name'][type='text'].form-control");

    private By lastNameField = By.cssSelector("input[placeholder='Last Name']");
    private By ssnField = By.cssSelector("input[placeholder='SSN']");
    private By dobField = By.cssSelector("input[placeholder='Date of Birth']");
    private By streetField = By.cssSelector("input[placeholder='Street']");
    private By cityField = By.cssSelector("input[placeholder='City']");
    private By zipCodeField = By.cssSelector("input[placeholder='Zip Code']");
    private By grossAnnualIncomeField = By.cssSelector("input[placeholder='Gross Annual Income']");
    private By yearsDropdownField = By.cssSelector("select#years");
    private By monthsDropdownField = By.cssSelector("select#months");
    private By authorizationField = By.id("authorization");
    private By borrowerConsentField = By.id("consent");

    // Co-borrower Fields
    private By coBorrowerFirstNameField = By.cssSelector("input[placeholder='First Name']");
    private By coBorrowerLastNameField = By.cssSelector("input[placeholder='Last Name']");
    private By coBorrowerSSNField = By.cssSelector("input[placeholder='SSN']");
    private By coBorrowerDOBField = By.cssSelector("input[placeholder='Date of Birth']");
    private By coBorrowerStreetField = By.cssSelector("input[placeholder='Street']");
    private By coBorrowerCityField = By.cssSelector("input[placeholder='City']");
    private By coBorrowerZipCodeField = By.cssSelector("input[placeholder='Zip Code']");
    private By coBorrowerYearsDropdownField = By.cssSelector("select#years");
    private By coBorrowerMonthsDropdownField = By.cssSelector("select#months");
    private By coBorrowerGrossAnnualIncomeField = By.cssSelector("input[placeholder='Gross Annual Income']");
    private By coBorrowerAuthorizationField = By.id("authorization");
    private By coBorrowerConsentField = By.id("consent");

    // Additional Fields
    private By phoneNumberField = By.cssSelector("input[placeholder='Phone Number']");
    private By emailAddressField = By.cssSelector("input[placeholder='Email Address']");
    private By maritalStatusDropdownField = By.cssSelector("select#maritalStatus");
    private By employmentStatusDropdownField = By.cssSelector("select#employmentStatus");
    private By citizenshipStatusDropdownField = By.cssSelector("select#citizenshipStatus");

    // Submit Button
    private By submitButton = By.xpath("//*[@id='root']/div[3]/div/div/form/div/div[15]/button");

    // Helper Methods
    
    public void clickStartApplicationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(startApplicationButtonField));
        button.click();
    }
    public void startPreQualApplicationLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(childElementLocator)).click();
    }

    
    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Helper Method to Select Dropdown Value
    private void selectDropdown(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    // Helper Method to Click a Button or Checkbox
    private void clickButton(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Method to Fill Borrower Details
    public void fillBorrowerDetails(String firstName, String lastName, String ssn, String dob, String street,
                                    String city, String zipCode, String grossAnnualIncome, String years, String months) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(ssnField, ssn);
        enterText(dobField, dob);
        enterText(streetField, street);
        enterText(cityField, city);
        enterText(zipCodeField, zipCode);
        enterText(grossAnnualIncomeField, grossAnnualIncome);
        selectDropdown(yearsDropdownField, years);
        selectDropdown(monthsDropdownField, months);
    }

    // Method to Fill Co-Borrower Details
    public void fillCoBorrowerDetails(String firstName, String lastName, String ssn, String dob, String street,
                                      String city, String zipCode, String grossAnnualIncome, String years, String months) {
        enterText(coBorrowerFirstNameField, firstName);
        enterText(coBorrowerLastNameField, lastName);
        enterText(coBorrowerSSNField, ssn);
        enterText(coBorrowerDOBField, dob);
        enterText(coBorrowerStreetField, street);
        enterText(coBorrowerCityField, city);
        enterText(coBorrowerZipCodeField, zipCode);
        enterText(coBorrowerGrossAnnualIncomeField, grossAnnualIncome);
        selectDropdown(coBorrowerYearsDropdownField, years);
        selectDropdown(coBorrowerMonthsDropdownField, months);
    
    }

    // Method to Fill Additional Fields
    public void fillAdditionalDetails(String phoneNumber, String emailAddress, String maritalStatus, 
                                      String employmentStatus, String citizenshipStatus) {
        enterText(phoneNumberField, phoneNumber);
        enterText(emailAddressField, emailAddress);
        selectDropdown(maritalStatusDropdownField, maritalStatus);
        selectDropdown(employmentStatusDropdownField, employmentStatus);
        selectDropdown(citizenshipStatusDropdownField, citizenshipStatus);
    }

    // Method to Click Submit Button
    public void clickSubmit() {
        clickButton(submitButton);
        System.out.println("this is the code")
         system.out.println ("this ")
         sytem.out.println("hsjd")
         syatem.out.phoneNumberField
         system.out.println("this to the testing")
         system.tetes
    }rdf

    // Method to Authorize Borrower
    public void authorizeBorrower() {
        clickButton(authorizationField);
        system.out.println ("thius is the code ")
            system.out.prinlln
    }

    // Method to Give Consent for Borrower
    public void consentBorrower() {
        clickButton(borrowerConsentField);
    }

    // Method to Authorize Co-Borrower
    public void authorizeCoBorrower() {
        clickButton(coBorrowerAuthorizationField);
    }

    // Method to Give Consent for Co-Borrower
    public void consentCoBorrower() {
        clickButton(coBorrowerConsentField);
    }
}
