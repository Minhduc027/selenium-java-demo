package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available."

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty

        */
@Test
public class TestCase03 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase03() throws InterruptedException, IOException {
        int src = 0;
        String expected1 = "The requested quantity for \"Sony Xperia\" is not available";
        String expected2 = "SHOPPING CART IS EMPTY";
        StringBuilder verificationError = new StringBuilder();
        WebDriver driver = driverFactory.getChromeDriver();
        //1. Go to http://live.techpanda.org/
        driver.get(url);
        System.out.println(driver.getTitle());
        //2. Click on �MOBILE� menu
        driver.findElement(By.linkText("MOBILE")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
        //3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
        driver.findElement(By.xpath("//li[3]//div[1]//div[3]//button[1]")).click();
        //4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
        WebElement txtQuantity = driver.findElement(By.xpath("//input[@title='Qty']"));
        txtQuantity.sendKeys("1000");//�QTY� value = 1000
        driver.findElement(By.xpath("//button[@title='Update']")).click();
        Thread.sleep(2000);
        //"The requested quantity for "Sony Xperia" is not available." is expected here
        WebElement errorMsg = driver.findElement(By.cssSelector(".item-msg.error"));
        //screenshot1
        TakesScreenshot screenshot1 = ((TakesScreenshot) driver);
        File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
        String autoAllocate1 = "TC03-01.png";
        FileHandler.copy(srcFile1, new File(destFile + autoAllocate1));
        //5. Verify the error message
        assertEquals(expected1, errorMsg.getText());

        System.out.println("Error message:" + errorMsg.getText());
        //6. Then click on �EMPTY CART� link in the footer of list of all mobiles.
        driver.findElement(By.id("empty_cart_button")).click();
        //A message "SHOPPING CART IS EMPTY" is expected.
        WebElement emptyCartMsg = driver.findElement(By.cssSelector("div[class='main-container col1-layout'] p:nth-child(1)"));
        //screenshot2
        System.out.println("Message: " + emptyCartMsg.getText());
        TakesScreenshot screenshot2 = ((TakesScreenshot) driver);
        File srcFile2 = screenshot2.getScreenshotAs(OutputType.FILE);
        String autoAllocate2 = "TC03-02.png";
        FileHandler.copy(srcFile2, new File(destFile + autoAllocate2));
        //7. Verify cart is empty
        assertEquals(expected2, emptyCartMsg.getText());
    }
}
