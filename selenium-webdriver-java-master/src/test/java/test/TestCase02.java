package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/*

Test Steps:

        1. Goto http://live.techpanda.org/

        2. Click on �MOBILE� menu

        3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

        4. Click on Sony Xperia mobile

        5. Read the Sony Xperia mobile from detail page.

        6. Compare Product value in list and details page should be equal ($100).

        */
@Test
public class TestCase02 {
    private static final String url = "http://live.techpanda.org/";
    private static final String destFile = "C:\\Users\\User\\OneDrive\\Máy tính\\SWT301\\SeleniumWebDriver\\screenshot\\";
    public static void testCase02() throws InterruptedException, IOException {
        int src = 0;
        StringBuilder verificationError = new StringBuilder();
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("MOBILE")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement SonyXperiaPrice = driver.findElement(By.cssSelector("span[id='product-price-1'] span[class='price']"));
        //WebElement SonyXperiaPrice = driver.findElement(By.id("product-price-1"));
        System.out.println("listPrice:" + SonyXperiaPrice.getText());
        Thread.sleep(2000);
        WebElement SonyXperiaImg = driver.findElement(By.id("product-collection-image-1"));
        SonyXperiaImg.click();
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.cssSelector(".price"));
        System.out.println("detailPrice:" + price.getText());
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String autoAllocate = "screenshot3.png";
        FileHandler.copy(srcFile, new File(destFile + autoAllocate));
    }
}
