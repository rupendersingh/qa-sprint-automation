package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {

    @Test
    public void verifyExampleDotComContent() {

        ExamplePage page = new ExamplePage(driver);

        page.open();

        Assert.assertEquals(page.getTitle(), "Example Domain");
        Assert.assertEquals(page.getHeadingText(), "Example Domain");
    }
}
