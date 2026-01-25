package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import utils.WaitUtils;


public class DemoPage {

    private AndroidDriver driver;
    private WaitUtils wait;

    // Constructor injection (required)
    public DemoPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver,10);
    }
    private By viewsBtn = AppiumBy.accessibilityId("Views");
    private By applink = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"App\"]");

    public void viewsBtnClick(){
        wait.waitForPresense(viewsBtn);
        driver.findElement(viewsBtn).click();
    }

    public void appLinkClick(){
        wait.waitForClickability(applink);
        driver.findElement(applink).click();
    }

}
