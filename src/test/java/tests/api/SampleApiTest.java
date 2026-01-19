package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleApiTest {

    @Test
    public void verifySingleUserApi() {

        // Step 1: Send GET request
        Response response = RestAssured
                .given()
                .header("x-api-key","reqres_8d469b8d719b48cc92180a3180eb2e0d")
                .when()
                .get("https://reqres.in/api/users/2");

        // Step 2: Assert status code
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code is not 200");

        // Step 3: Assert response body field
        int userId = response.jsonPath().getInt("data.id");
        Assert.assertEquals(userId, 2,
                "User ID does not match");

        response.prettyPrint();

    }
}
