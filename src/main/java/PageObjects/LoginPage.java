package PageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.cssSelector("input[type='text']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.xpath("//*[@id='root']/div[2]/div/div/div/form/div[5]/button");
      
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        WebElement usernameElem = getUsernameField();
        // Wait until the username field is clickable
        waitForElementToBeClickable(usernameElem);
        usernameElem.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordElem = getPasswordField();
        // Wait until the password field is clickable
        waitForElementToBeClickable(passwordElem);
        passwordElem.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        WebElement button = getLoginButton();
        // Wait until the login button is clickable
        waitForElementToBeClickable(button);
        button.click();
    }

    // Wait for an element to be clickable
    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Getters for the WebElements
    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
        system.out.println("this is my commit ")
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
        system.out.println("this is my commit git")

    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }
}
