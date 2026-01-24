package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String loggedinEmail;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToLogin(){
        driver.get("https://automationexercise.com/");
    }

    public void login(String email, String password){
        By loginLink = By.xpath("//a[normalize-space()='Signup / Login']");
        WebElement LoginClick = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        LoginClick.click();

        By LoginHeading = By.tagName("h2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeading));
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.click();
        EmailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='Logout']"))));

        this.loggedinEmail = email;
    }

    public String getLoggedInEmail() {
        return loggedinEmail;
    }

}
