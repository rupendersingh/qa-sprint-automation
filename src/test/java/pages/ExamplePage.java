package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExamplePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ExamplePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public void clickBtn(){
        //WebElement btn = new WebElement();
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"))));
        btn.click();
    }
    public String MessageText(){
        By message = By.id("message");
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return msg.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getHeadingText() {
        WebElement heading = driver.findElement(By.tagName("h1"));
        return heading.getText();
    }

}
