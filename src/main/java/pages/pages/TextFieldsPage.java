package pages.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class TextFieldsPage {
    private AndroidDriver driver;
    private WaitUtils wait;

    // Constructor injection (required)
    public TextFieldsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver,10);
    }
    private By inputBox2 = AppiumBy.id("io.appium.android.apis:id/edit2");
    private By inputPass = AppiumBy.id("io.appium.android.apis:id/edit1");
    private By textFieldHeader = AppiumBy.xpath(("//android.widget.TextView[@text=\"Views/TextFields\"]\n"));

    public void inputBox2Click(){
        wait.waitForVisibility(inputBox2);
        driver.findElement(inputBox2).click();
    }
    public void inputPassText(){
        wait.waitForVisibility(inputPass);
        driver.findElement(inputPass).sendKeys("Testing123");
    }

    public String VerifyPasswordField(){
        //wait.waitForClickability(inputPass);
        String passText = driver.findElement(inputPass).getText();
        return passText;
    }

    public boolean textFieldHeaderText(){
        wait.waitForPresense(textFieldHeader);
       return driver.findElement(textFieldHeader).isDisplayed();
    }
}
