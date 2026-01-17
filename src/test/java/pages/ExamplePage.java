package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExamplePage {

    private WebDriver driver;

    public ExamplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://example.com");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getHeadingText() {
        WebElement heading = driver.findElement(By.tagName("h1"));
        return heading.getText();
    }
}
