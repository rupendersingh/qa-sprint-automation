package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class RecoveryDayXUIActionsTest{

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println(">>> TEST SETUP EXECUTED <<<");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(groups = {"smoke", "regression"})
    public void recoveryDayXUI(){
        System.out.println("INSIDE TEST METHOD");
        Assert.assertNotNull(driver, "Driver is NULL");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Test Starts");
        WebElement element = driver.findElement(By.linkText("Dropdown"));
        Assert.assertEquals(element.getText(),"Dropdown");
        System.out.println("Dropdown Selected");


        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText,"I am a JS Alert");
        System.out.println("Alert text captured: " + alertText);
        alert.accept();
        System.out.println("Alert Accepted");

        driver.navigate().back();
        WebElement multiWindows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Multiple Windows")));
        multiWindows.click();
        WebElement clickHere = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Click Here']")));
        String parentWindow = driver.getWindowHandle();
        clickHere.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles){
            if(!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to Child Window");
                System.out.println(handle);
                WebElement heading = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("H3"))));
                Assert.assertEquals(heading.getText(), "New Window");
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Switched to Parent Window");

        WebElement parentHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("H3")));
        Assert.assertEquals(parentHeading.getText(),"Opening a new window");

        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),"The Internet");
        System.out.println("Test Finished");

    }
}
