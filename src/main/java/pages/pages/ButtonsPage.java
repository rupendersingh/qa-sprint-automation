package pages.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class ButtonsPage {

    private AndroidDriver driver;
    private WaitUtils wait;

    // Constructor injection (required)
    public ButtonsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver,10);
    }
    private By Normalbtn = AppiumBy.accessibilityId("Normal");
    //private By applink = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"App\"]");

    public void NormalBtnClick(){
        wait.waitForClickability(Normalbtn);
        driver.findElement(Normalbtn).click();
    }

    public boolean isButtonsPageVisible(){
        wait.waitForVisibility(Normalbtn);
        return driver.findElement(Normalbtn).isDisplayed();
    }
}
