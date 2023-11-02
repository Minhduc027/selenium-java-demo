package test;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.

Note:

- build Register page as POM.

- code for switching to new window:

// switching to new window
for (String handle : driver.getWindowHandles()) {
    driver.switchTo().window(handle);
}
*/
@Test
public class TestCase05 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase05() throws InterruptedException, IOException {
        String firstName = "Mai Nguyen";
        String middleName = "Duc";
        String lastName = "Minh";
        String email = "minhmndse2003@fpt.edu.vn";
        String password = "123456789";
        String confirm = password;
        String expected = "Your Wishlist has been shared.";
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            RegisterPage registerPage = new RegisterPage(driver);
            //Home page url: http://live.techpanda.org/
            driver.get(url);
            //2. Click on my account link
            registerPage.clickMyAccountLink();
            Thread.sleep(200);
            //3. Click Create an Account link
            registerPage.clickCreateAnAccount();
            //fill New User information excluding the registered Email ID.
            //first name
            registerPage.enterFirstName(firstName);
            //middle name
            registerPage.enterMiddleName(middleName);
            //last name
            registerPage.enterLastName(lastName);
            //email
            registerPage.enterEmail(email);
            //password
            registerPage.enterPassword(password);
            //confirm password
            registerPage.enterConfirmation(confirm);
            //4. Click Register
            registerPage.clickRegister();
            //6. Go to TV menu
            driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();
            Thread.sleep(300);
            //7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();
            //8. Click SHARE WISHLIST
            driver.findElement(By.name("save_and_share")).click();
            //9. In next page enter Email and a message and click SHARE WISHLIST
            WebElement txtEmail = driver.findElement(By.xpath("//textarea[@id='email_address']"));
            txtEmail.sendKeys("demo00027@gmail.com");
            WebElement txtMessage = driver.findElement(By.xpath("//textarea[@id='message']"));
            txtMessage.sendKeys("demo key bla bla!");
            //10.Check wishlist is shared. Expected wishlist shared successfully.
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
            assertEquals(expected, driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']")).getText());
            System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']")).getText());
            //Screenshot
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String autoAllocate = "TC05.png";
            FileHandler.copy(srcFile, new File(destFile + autoAllocate));
        }catch (Exception e){
            e.getMessage();
        }
    }
}
