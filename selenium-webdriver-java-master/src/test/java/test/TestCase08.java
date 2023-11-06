package test;

import POM.CheckoutPage;
import POM.LoginPage;
import POM.MyAccountPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/* /-----------------------TESTCASE08-------------------------/

*  Verify you are able to change or reorder previously added product

 *  Test Data = QTY = 10

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on 'REORDER' link , change QTY & click Update

5. Verify Grand Total is changed

6. Complete Billing & Shipping Information

7. Verify order is generated and note the order number

Expected outcomes:

1) Grand Total is Changed

2) Order number is generated
*/
@Test
public class TestCase08 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase08() throws InterruptedException, IOException {
        String email = "minhmndse2003@fpt.edu.vn";
        String password = "123456789";
        String zip = "10001";
        String telephone = "0933112331";
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            //1. Go to http://live.techpanda.org/
            driver.get(url);
            //2. Click on my account link
            loginPage.clickMyAccountLink();
            Thread.sleep(200);

            //3. Login in application using previously created credential
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            // Click on Login button
            loginPage.clickLogin();
            Thread.sleep(500);

            //4. Click on 'REORDER' link , change QTY & click Update
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickMyOrderLink();
            Thread.sleep(2000);
            //Click on 'Reorder'
            myAccountPage.clickReOrderLink();
            Thread.sleep(1000);
            //Change QTY(10) and click update.
            System.out.println("GRAND PRICE before:" + driver.findElement(By.cssSelector("strong span[class='price']")).getText());
            myAccountPage.enterQTY("10");
            Thread.sleep(300);
            driver.findElement(By.xpath("//button[@title='Update']")).click();

            //5. Verify Grand Total is changed
            System.out.println("GRAND PRICE after:" + driver.findElement(By.cssSelector("strong span[class='price']")).getText());
            Thread.sleep(300);
            //process to check out
            checkoutPage.processToCheckoutButton();

            //6. Complete Billing & Shipping Information
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
            Thread.sleep(3000);
            //click continue
            checkoutPage.clickContinueButton();
            Thread.sleep(3000);

            // In Shipping Method, Click Continue
            checkoutPage.shippingMethodContinueButton();
            Thread.sleep(3000);

            //In Payment Information select 'Check/Money Order' radio button. Click Continue
            WebElement moneyOrder = driver.findElement(By.cssSelector("label[for='p_method_checkmo']"));
            moneyOrder.click();
            Thread.sleep(3000);
            WebElement btn = driver.findElement(By.cssSelector("button[onclick='payment.save()'] span span"));
            btn.click();

            //Click 'PLACE ORDER' button
            Thread.sleep(3000);
            checkoutPage.placeOrderButton();
            Thread.sleep(3000);

            //7. Verify order is generated and note the order number
            WebElement orderID = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//p[1]"));
            System.out.println("Your order Id: " + orderID.getText());
            Thread.sleep(3000);
            //Screenshot
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String autoAllocate = "TC08.png";
            FileHandler.copy(srcFile, new File(destFile + autoAllocate));
        }catch (Exception e){
            e.getMessage();
        }
    }
}
