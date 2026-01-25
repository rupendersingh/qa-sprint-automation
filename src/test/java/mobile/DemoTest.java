package mobile;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.pages.*;

import java.security.PublicKey;

public class DemoTest extends BaseTest {
    private DemoPage demoPage;
    private AppPage appPage;
    private ButtonsPage buttonsPage;
    private TextFieldsPage textFieldsPage;
    private ViewsPage viewsPage;

    @BeforeMethod
    public void setUpPageObjects() {
        demoPage = new DemoPage(driver);
        viewsPage = new ViewsPage(driver);
        appPage = new AppPage(driver);
        buttonsPage = new ButtonsPage(driver);
        textFieldsPage = new TextFieldsPage(driver);
    }

    @Test(priority = 1)
    public void viewsPageAccessible(){
        demoPage.viewsBtnClick();
        Assert.assertTrue(viewsPage.isViewsPageDisplayed());
    }
    @Test(priority = 2)
    public void buttonsPageAccessible(){
        demoPage.viewsBtnClick();
        viewsPage.buttonsClick();
        Assert.assertTrue(buttonsPage.isButtonsPageVisible());
    }

    @Test(priority = 3)
    public void ClickNormalButton(){
        demoPage.viewsBtnClick();
        viewsPage.buttonsClick();
        buttonsPage.NormalBtnClick();
        Assert.assertTrue(buttonsPage.isButtonsPageVisible());
    }

    @Test(priority = 4)
    public void textFieldsPageAccessibility(){
        demoPage.viewsBtnClick();
        viewsPage.textFieldClick();
        Assert.assertTrue(textFieldsPage.textFieldHeaderText());
    }
    @Test(priority = 5)
    public void inputTestClickability(){
        demoPage.viewsBtnClick();
        viewsPage.textFieldClick();
        textFieldsPage.inputBox2Click();
        Assert.assertTrue(textFieldsPage.textFieldHeaderText());
    }
    @Test(priority = 6)
    public void enterPassword(){
        demoPage.viewsBtnClick();
        viewsPage.textFieldClick();
        textFieldsPage.inputPassText();
        Assert.assertNotNull(textFieldsPage.VerifyPasswordField());
    }

}
