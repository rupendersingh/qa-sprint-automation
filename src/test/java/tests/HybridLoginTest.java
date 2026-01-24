package tests;

import base.BaseApiTest;
import base.BaseTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import base.BaseApiTest;
import utils.ApiAssertions;

import static io.restassured.path.xml.XmlPath.given;

public class HybridLoginTest extends BaseTest {
    private BaseApiTest api;

    @BeforeMethod
    public void initApiLayer() {
        api = new BaseApiTest();
        api.setup();   // initializes authenticated requestSpec
    }

    @Test
    public void loginAndValidateViaApi() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.login("rupenderchhilar.hv@gmail.com", "Test@123user");
        String LoginEmail = loginPage.getLoggedInEmail();
        Assert.assertNotNull(LoginEmail, "User not logged in");

        //BaseApiTest api = new BaseApiTest();
        Response response =
                given()
                        .spec(api.getRequestSpec())
                        .queryParam("email",LoginEmail)
                        .when()
                        .get("/getUserDetailByEmail");

        //response.then().statusCode(200);
        ApiAssertions.assertStatusCode(response,200);
        response.prettyPrint();
    }

}