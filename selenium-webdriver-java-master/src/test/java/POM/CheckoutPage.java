package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private By placeOrder = By.cssSelector("button[title='Place Order'] span span");
    private By validationAddress = By.xpath("//button[@class='button validation-passed']");
    private By shippingInfo = By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]");
    private By shippingMethodContinue = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");
    private By processToCheckout = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");
    private By company = By.id("billing:company");
    private By address = By.id("billing:street1");
    private By address2 = By.id("billing:street2");
    private By city = By.id("billing:city");
    private By postcode = By.id("billing:postcode");
    private By telephone = By.id("billing:telephone");
    private By fax = By.id("billing:fax");
    private By orderId = By.xpath("//div[@class='main-container col1-layout']//p[1]");
    private By continueButton = By.xpath("//button[@onclick='billing.save()']");
    public String getOrderId (){
        WebElement element = driver.findElement(orderId);
        return element.getText();
    }
    public void enterValue(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
    public void enterCompany(String value) {
        enterValue(company, value);
    }

    public void enterAddress(String value) {
        enterValue(address, value);
    }

    public void enterAddress2(String value) {
        enterValue(address2, value);
    }

    public void enterCity(String value) {
        enterValue(city, value);
    }

    public void enterPostcode(String value) {
        enterValue(postcode, value);
    }

    public void enterTelephone(String value) {
        enterValue(telephone, value);
    }

    public void enterFax(String value) {
        enterValue(fax, value);
    }

    public void clickContinueButton() {
        click(continueButton);
    }
    public void processToCheckoutButton() {
        click(processToCheckout);
    }
    public void shippingMethodContinueButton() {
        click(shippingMethodContinue);
    }
    public void shippingInfoButton() {
        click(shippingInfo);
    }
    public void validationAddressButton() {
        click(validationAddress);
    }
    public void placeOrderButton() {
        click(placeOrder);
    }
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
}
