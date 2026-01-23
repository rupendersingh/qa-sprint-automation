package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Expected status code " + expectedStatusCode +
                        " but found " + response.getStatusCode()
        );
    }

    public static void assertHeaderPresent(Response response, String headerName) {
        Assert.assertNotNull(
                response.getHeader(headerName),
                "Expected Header Name " + headerName +
                        " to be present but it was missing"
        );
    }

    public static void assertResponseTimeUnder(Response response, long maxMillis){
        Assert.assertTrue(
                response.getTime()< maxMillis,
                "Expected Response time less than " + maxMillis +"but it is greater" + response.getTime()
        );
    }

    public static void assertJsonFieldNotNull(Response response, String jsonPath){
        Assert.assertNotNull(
                response.jsonPath().get(jsonPath),
                "Expected Json Path" + jsonPath + "To be not NULL"
        );
    }

}



