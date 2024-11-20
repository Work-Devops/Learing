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
    private By startApplicationButtonField = (By.id("dropdown-split-basic"));
    private By startPreQualApplicationLink = By.xpath("//a[@class='dropdown-item' and contains(text(),'Start a PreQual Application')]");

    private By loanProductDropdownField = By.cssSelector("select.form-select");
    private By firstNameField = By.cssSelector("input[placeholder='First Name']");
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

    public void clickStartPreQualApplicationLink() {
        WebElement link = driver.findElement(startPreQualApplicationLink);
        link.click();
    }

    private WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }

    private void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    private void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        waitForElementToBeClickable(element);
        element.clear();
        element.sendKeys(text);
    }

    private void selectDropdown(By locator, String visibleText) {
        WebElement dropdown = findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    private void safeClick(By locator) {
        WebElement element = findElement(locator);
        waitForElementToBeClickable(element);
        element.click();
    }

    // Borrower Dropdown Methods
    public void selectYears(String years) {
        selectDropdown(yearsDropdownField, years);
    }

    public void selectMonths(String months) {
        selectDropdown(monthsDropdownField, months);
    }

    // Co-Borrower Dropdown Methods
    public void selectCoBorrowerYears(String years) {
        selectDropdown(coBorrowerYearsDropdownField, years);
    }

    public void selectCoBorrowerMonths(String months) {
        selectDropdown(coBorrowerMonthsDropdownField, months);
    }

    // Unified Dropdown Selection Method
    public void selectDropdown(String fieldType, String value, boolean isCoBorrower) {
        By locator;
        if (fieldType.equalsIgnoreCase("years")) {
            locator = isCoBorrower ? coBorrowerYearsDropdownField : yearsDropdownField;
        } else if (fieldType.equalsIgnoreCase("months")) {
            locator = isCoBorrower ? coBorrowerMonthsDropdownField : monthsDropdownField;
        } else {
            throw new IllegalArgumentException("Invalid dropdown type: " + fieldType);
        }
        selectDropdown(locator, value);
    }

    // Unified Borrower & Co-Borrower Logic
    public void enterField(String fieldType, String value, boolean isCoBorrower) {
        By locator = isCoBorrower ? coBorrowerFieldLocator(fieldType) : borrowerFieldLocator(fieldType);
        enterText(locator, value);
    }

    private By borrowerFieldLocator(String fieldType) {
        switch (fieldType.toLowerCase()) {
            case "firstname": return firstNameField;
            case "lastname": return lastNameField;
            case "ssn": return ssnField;
            case "dob": return dobField;
            case "street": return streetField;
            case "city": return cityField;
            case "zipcode": return zipCodeField;
            case "income": return grossAnnualIncomeField;
            default: throw new IllegalArgumentException("Invalid borrower field: " + fieldType);
        }
    }

    private By coBorrowerFieldLocator(String fieldType) {
        switch (fieldType.toLowerCase()) {
            case "firstname": return coBorrowerFirstNameField;
            case "lastname": return coBorrowerLastNameField;
            case "ssn": return coBorrowerSSNField;
            case "dob": return coBorrowerDOBField;
            case "street": return coBorrowerStreetField;
            case "city": return coBorrowerCityField;
            case "zipcode": return coBorrowerZipCodeField;
            case "income": return coBorrowerGrossAnnualIncomeField;
            default: throw new IllegalArgumentException("Invalid co-borrower field: " + fieldType);
        }
    }

    // Borrower Actions
    public void selectLoanProduct(String productName) {
        selectDropdown(loanProductDropdownField, productName);
    }

    public void authorizeBorrower() {
        safeClick(authorizationField);
    }

    public void consentBorrower() {
        safeClick(borrowerConsentField);
    }

    // Co-Borrower Actions
    public void authorizeCoBorrower() {
        safeClick(coBorrowerAuthorizationField);
    }

    public void consentCoBorrower() {
        safeClick(coBorrowerConsentField);
    }

    // Additional Field Methods
    public void enterPhoneNumber(String phoneNumber) {
        enterText(phoneNumberField, phoneNumber);
    }

    public void enterEmailAddress(String emailAddress) {
        enterText(emailAddressField, emailAddress);
    }

    public void selectMaritalStatus(String maritalStatus) {
        selectDropdown(maritalStatusDropdownField, maritalStatus);
    }

    public void selectEmploymentStatus(String employmentStatus) {
        selectDropdown(employmentStatusDropdownField, employmentStatus);
    }

    public void selectCitizenshipStatus(String citizenshipStatus) {
        selectDropdown(citizenshipStatusDropdownField, citizenshipStatus);
    }

    public void clickSubmitButton() {
        safeClick(submitButton);
    }
}
