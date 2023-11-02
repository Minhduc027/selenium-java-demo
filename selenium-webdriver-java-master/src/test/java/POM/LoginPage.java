package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By checkGenerate = By.xpath("//label[@for='s_method_flatrate_flatrate']");
    private By myAccountLink = By.linkText("MY ACCOUNT");
    private By estimate = By.xpath("//span[contains(text(),'Estimate')]");
    private By updateTotal = By.xpath("//span[contains(text(),'Update Total')]");
    private By email = By.id("email");
    private By password = By.id("pass");
    private By loginButton = By.id("send2");
    private By myWishList = By.linkText("MY WISHLIST");
    private By addToCart = By.xpath("//button[@title='Add to Cart']");
    private By selectCountry = By.id("country");
    private By zipCode = By.id("postcode");
    public By getSelectCountry(){
        return selectCountry;
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
    public void enterZipCode(String value) {
        WebElement passwordElement = driver.findElement(zipCode);
        passwordElement.clear();
        passwordElement.sendKeys(value);
    }
    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickMyWishList() {
        driver.findElement(myWishList).click();
    }
    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }
    public void clickEstimate() {
        driver.findElement(estimate).click();
    }
    public void clickUpdateTotal() {
        driver.findElement(updateTotal).click();
    }
    public void clickCheckGenerate() {
        driver.findElement(checkGenerate).click();
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

}
