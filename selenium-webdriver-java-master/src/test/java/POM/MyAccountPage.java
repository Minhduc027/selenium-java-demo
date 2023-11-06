package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MyAccountPage {
    private WebDriver driver;

    private By myOrder = By.xpath("//a[normalize-space()='My Orders']");
    private By viewOrde = By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]");
    private By printOrder = By.xpath("//a[@class='link-print']");
    private By reOrder = By.xpath("//tr[@class='first odd']//a[@class='link-reorder'][normalize-space()='Reorder']");

    private By inputQTY = By.xpath("//input[@title='Qty']");
    public void enterQTY(String value) {
        WebElement passwordElement = driver.findElement(inputQTY);
        passwordElement.clear();
        passwordElement.sendKeys(value);
    }
    public void clickMyOrderLink() {
        driver.findElement(myOrder).click();
    }
    public void clickViewOrderLink() {
        driver.findElement(viewOrde).click();
    }
    public void clickPrintOrderLink() {
        driver.findElement(printOrder).click();
    }
    public void clickReOrderLink(){driver.findElement(reOrder).click(); }
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
