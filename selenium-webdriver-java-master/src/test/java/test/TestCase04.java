package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/
@Test
public class TestCase04 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase03() throws InterruptedException, IOException {
        StringBuilder verificationError = new StringBuilder();
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("MOBILE")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]")).click();
        Thread.sleep(2000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println(driver.getTitle());
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String autoAllocate = "TC04.png";
        FileHandler.copy(srcFile, new File(destFile + autoAllocate));
    }
}
