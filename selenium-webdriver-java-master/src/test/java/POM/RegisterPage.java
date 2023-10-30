package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private By myAccountLink = By.linkText("MY ACCOUNT");
    private By createAnAccount = By.xpath("//a[@title='Create an Account']");
    private By firstName = By.id("firstname");
    private By middleName = By.id("middlename");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmation = By.id("confirmation");
    private By register = By.xpath("//button[@title='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickCreateAnAccount() {
        driver.findElement(createAnAccount).click();
    }

    public void enterFirstName(String value) {
        WebElement firstNameElement = driver.findElement(firstName);
        firstNameElement.clear();
        firstNameElement.sendKeys(value);
    }

    public void enterMiddleName(String value) {
        WebElement middleNameElement = driver.findElement(middleName);
        middleNameElement.clear();
        middleNameElement.sendKeys(value);
    }

    public void enterLastName(String value) {
        WebElement lastNameElement = driver.findElement(lastName);
        lastNameElement.clear();
        lastNameElement.sendKeys(value);
    }

    public void enterEmail(String value) {
        WebElement emailElement = driver.findElement(email);
        emailElement.clear();
        emailElement.sendKeys(value);
    }

    public void enterPassword(String value) {
        WebElement passwordElement = driver.findElement(password);
        passwordElement.clear();
        passwordElement.sendKeys(value);
    }

    public void enterConfirmation(String value) {
        WebElement confirmationElement = driver.findElement(confirmation);
        confirmationElement.clear();
        confirmationElement.sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(register).click();
    }

    // Additional methods and actions for the RegisterPage class
}