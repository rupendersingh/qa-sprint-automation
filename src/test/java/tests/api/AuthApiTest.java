package tests.api;

import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthApiTest extends BaseApiTest {
    //@Test
    public void getUserWithAuthToken() {

        Response response =
                given()
                        .spec(getAuthenticatedSpec())
                        .basePath("/api/users/2")
                        .get();

        // Assertions belong in test
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(getAuthToken());

        // Business-level validation
        Assert.assertEquals(
                response.jsonPath().getInt("data.id"),
                2
        );
    }
}
