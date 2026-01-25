package pages.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class AppPage {
    private AndroidDriver driver;
    private WaitUtils wait;

    // Constructor injection (required)
    public AppPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver,10);
    }
    private By actionBar= AppiumBy.accessibilityId("Action Bar");

    public void actionBarClick(){
        wait.waitForClickability(actionBar);
        driver.findElement(actionBar).click();
    }

    public boolean IsAppPageVisible(){
        wait.waitForVisibility(actionBar);
        return driver.findElement(actionBar).isDisplayed();
    }
}
