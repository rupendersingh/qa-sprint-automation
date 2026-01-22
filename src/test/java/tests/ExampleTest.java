package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {

    @Test(groups = {"regression"})
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
