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

/* --------------TESTCASE07-------------------------/*

Verify that you will be able to save previously placed order as a pdf file

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link
*/
@Test
public class TestCase07 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase07() throws InterruptedException, IOException {
        String email = "minhmndse2003@fpt.edu.vn";
        String password = "123456789";
        WebDriver driver = driverFactory.getChromeDriver();
        try{
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
            Thread.sleep(1000);

            //4. Click on 'My Orders'
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickMyOrderLink();
            Thread.sleep(1000);
            //5. Click on 'View Order'
            myAccountPage.clickViewOrderLink();
            Thread.sleep(1000);
            //6. Click on 'Print Order' link
            myAccountPage.clickPrintOrderLink();
            Thread.sleep(300);
            //Screenshot
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String autoAllocate = "TC07.png";
            FileHandler.copy(srcFile, new File(destFile + autoAllocate));
        }catch (Exception e){
            e.getMessage();
        }
    }
}
