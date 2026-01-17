package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void verifyExampleDotComContent(){


        driver.get("https://example.com/");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        WebElement h1Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        String h1TestValue = h1Text.getText();
        System.out.println(h1TestValue);

        Assert.assertEquals(actualTitle,"Example Domain");
        Assert.assertEquals(h1TestValue,"Example Domain");
        driver.quit();
        //System.out.println("First Test");
    }
}
