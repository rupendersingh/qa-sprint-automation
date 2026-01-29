package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.ConfigReader;

//@Listeners({})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println(">>> BASETEST SETUP EXECUTED <<<");
        String baseUrl = ConfigReader.get("base.url");
        boolean isHeadless = Boolean.parseBoolean(
                ConfigReader.get("headless")
        );
        ChromeOptions options = new ChromeOptions();

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
        }

        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
