package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public WaitUtils(AndroidDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickability(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPresense(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
