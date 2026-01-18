package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {

    @Test
    public void verifyExampleDotComContent() {

        ExamplePage page = new ExamplePage(driver);
        //SoftAssert soft = new SoftAssert();
        page.open();
        page.clickBtn();
        Assert.assertEquals(page.MessageText(),"It's gone!", "Message not found");
        Assert.assertEquals(driver.getTitle(), "The Internet");
        /*String link = driver.getCurrentUrl();
        //System.out.println(link);

        soft.assertEquals(page.getHeadingText(), "Example Domain");

        soft.assertTrue(driver.findElement(By.linkText("Learn more")).isDisplayed(), "String not present");
        Assert.assertTrue(driver.getCurrentUrl().contains("example"), "url incorrect");
         */
    }
}
