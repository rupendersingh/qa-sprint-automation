package tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeAuthTest {
    @Test
    public void getUserWithoutAuthToken() {

        Response response =
                given()
                        .baseUri("https://reqres.in")
                        .basePath("/api/users/2")
                        .get();

        // ReqRes limitation: still returns 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Structural validation
        Assert.assertNotNull(response.jsonPath().get("data"));
    }
}
