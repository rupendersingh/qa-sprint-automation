package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//@Listeners({})
public class BaseTest {

    protected WebDriver driver;

   // @BeforeMethod
    public void setUp() {
        System.out.println(">>> BASETEST SETUP EXECUTED <<<");
        driver = new ChromeDriver();
    }

    //@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
