package test;

import POM.CheckoutPage;
import POM.LoginPage;
import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/* Verify user is able to purchase product using registered email id (USE CHROME BROWSER)

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number
*/
@Test
public class TestCase06 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase06() throws InterruptedException, IOException {
        String email = "minhmndse2003@fpt.edu.vn";
        String password = "123456789";
        String zip = "10001";
        String telephone = "0933112331";
        String expected = "Your Wishlist has been shared.";
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            LoginPage loginPage = new LoginPage(driver);
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            //1. Go to http://live.techpanda.org/
            driver.get(url);
            //2. Click on my account link
            loginPage.clickMyAccountLink();
            Thread.sleep(200);

            //3. Login in application using previously created credential
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            //4. Click on Login button
            loginPage.clickLogin();
            Thread.sleep(300);

            //4. Click on MY WISHLIST link
            loginPage.clickMyWishList();
            Thread.sleep(300);

            //5. In next page, Click ADD TO CART link
            loginPage.clickAddToCart();
            Thread.sleep(300);

            //6. Enter general shipping country, state/province and zip for the shipping cost estimate
            Select select = new Select(driver.findElement(By.id("country")));
            select.selectByValue("US");
            loginPage.enterZipCode(zip);
            Select select2 = new Select(driver.findElement(By.id("region_id")));
            select2.selectByValue("12");

            //7. Click Estimate
            loginPage.clickEstimate();

            //8. Verify Shipping cost generated
            loginPage.clickCheckGenerate();

            //9. Select Shipping Cost, Update Total
            loginPage.clickUpdateTotal();

            //10. Verify shipping cost is added to total
            System.out.println(driver.findElement(By.xpath("//td[normalize-space()='Shipping & Handling (Flat Rate - Fixed)']")).getText());
            //11. Click "Proceed to Checkout"
            checkoutPage.processToCheckoutButton();
            //12a. Enter Billing Information, and click Continue
            Select billingAddress = new Select(driver.findElement(By.id("billing-address-select")));
            billingAddress.selectByIndex(1);
            Thread.sleep(1000);
            checkoutPage.enterCompany("FPT");Thread.sleep(1000);
            checkoutPage.enterAddress("12/50");Thread.sleep(1000);
            checkoutPage.enterCity("ABCDE");Thread.sleep(1000);
            Select billing = new Select(driver.findElement(By.id("billing:region_id")));
            billing.selectByValue("12");
            checkoutPage.enterPostcode(zip);
            Select cbilling = new Select(driver.findElement(By.id("billing:country_id")));
            cbilling.selectByValue("US");
            checkoutPage.enterTelephone(telephone);
            Thread.sleep(2000);
            checkoutPage.clickContinueButton();
            Thread.sleep(2000);
            //checkoutPage.validationAddressButton();
            //12b. Enter Shipping Information, and click Continue

            //13. In Shipping Method, Click Continue
            checkoutPage.shippingMethodContinueButton();
            Thread.sleep(2000);

            //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            WebElement moneyOrder = driver.findElement(By.cssSelector("label[for='p_method_checkmo']"));
            moneyOrder.click();
            Thread.sleep(2000);
            WebElement btn = driver.findElement(By.cssSelector("button[onclick='payment.save()'] span span"));
            btn.click();

            //15. Click 'PLACE ORDER' button
            Thread.sleep(2000);
            checkoutPage.placeOrderButton();
            Thread.sleep(2000);

            //16. Verify Oder is generated. Note the order number
            System.out.println("Your order Id: " + checkoutPage.getOrderId());
            Thread.sleep(1000);
            //Screenshot
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String autoAllocate = "TC06.png";
            FileHandler.copy(srcFile, new File(destFile + autoAllocate));
        }catch (Exception e){
            e.getMessage();
        }
    }
}
