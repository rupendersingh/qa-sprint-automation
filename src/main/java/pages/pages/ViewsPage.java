package pages.pages;

import actions.MobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class ViewsPage {

    private AndroidDriver driver;
    private WaitUtils wait;
    private MobileActions actions;

    // Constructor injection (required)
    public ViewsPage(AndroidDriver driver) {
        this.driver = driver;
        this.actions = new MobileActions(driver);
        this.wait = new WaitUtils(driver,10);
    }
    private By buttonsVp = AppiumBy.accessibilityId("Buttons");
    private By TextFieldsbtn = AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"TextFields\"))");
    public void textFieldClick(){
        wait.waitForPresense(TextFieldsbtn);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new,UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click(); //scroll down to the element and click
        actions.tap(TextFieldsbtn);
    }

    public boolean isViewsPageDisplayed(){
        wait.waitForVisibility(TextFieldsbtn);
        return driver.findElement(TextFieldsbtn).isDisplayed();
    }
    public void buttonsClick(){
        wait.waitForClickability(buttonsVp);
        actions.tap(buttonsVp);
    }

}

