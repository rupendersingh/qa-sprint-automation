package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAppiumTest {
    @Test
    public void launchAppAndVerifyElement() throws MalformedURLException {
        System.out.println("Test Starts Successfully");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.setAutomationName("UiAutomator2");
        options.setApp(System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        WebElement accessibility =
                driver.findElement(By.xpath("//*[@text='Accessibility']"));

        Assert.assertTrue(accessibility.isDisplayed(),
                "Accessibility option is not visible");

        driver.quit();

    }
}
