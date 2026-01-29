package mobile;

import base.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pages.*;

public class MobileTest extends MobileBaseTest {

    private DemoPage demoPage;
    //private AppPage appPage;
    //private ButtonsPage buttonsPage;
    //private TextFieldsPage textFieldsPage;
    private ViewsPage viewsPage;

    @BeforeMethod
    public void setUpPageObjects() {
        demoPage = new DemoPage(driver);
        viewsPage = new ViewsPage(driver);
        //appPage = new AppPage(driver);
       // buttonsPage = new ButtonsPage(driver);
        //textFieldsPage = new TextFieldsPage(driver);
    }

    @Test
    public void verifyAppLaunch() {
        System.out.println("Test Starts Successfully");
    }

    @Test
    public void viewsPageAccessible() {
        demoPage.viewsBtnClick();
        Assert.assertTrue(viewsPage.isViewsPageDisplayed());
    }
}
