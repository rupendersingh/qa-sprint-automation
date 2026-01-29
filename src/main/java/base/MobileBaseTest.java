package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(ConfigReader.get("platformName"));
        options.setDeviceName(ConfigReader.get("deviceName"));
        options.setAutomationName(ConfigReader.get("automationName"));
        options.setApp(ConfigReader.get("app"));

        driver = new AndroidDriver(
                new URL(ConfigReader.get("appiumServerURL")),
                options
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
