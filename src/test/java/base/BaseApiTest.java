package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    private static String authToken;
    protected RequestSpecification requestSpec;
    private static final String BASE_URI = "https://reqres.in";     // replace
    private static final String AUTH_PATH = "/api/login";            // replace
    private static final String API_KEY_HEADER = "x-api-key";          // replace
    private static final String API_KEY_VALUE = "reqres_8d469b8d719b48cc92180a3180eb2e0d";       // replace

    @BeforeMethod
    public void setup() {
        requestSpec = getAuthenticatedSpec();
    }
    protected static String getAuthToken() {

        if (authToken != null) {
            return authToken;
        }
        Response response =
                RestAssured
                        .given()
                        .baseUri(BASE_URI)
                        .basePath(AUTH_PATH)
                        .header("Content-Type", "application/json")
                        .header(API_KEY_HEADER, API_KEY_VALUE)
                        .body("""
                                {
                                     "email": "eve.holt@reqres.in",
                                     "password": "cityslicka"
                                 }
                              """)
                        .post();

        if (response.statusCode() != 200) {
            throw new RuntimeException("Auth failed. Status: " + response.statusCode());
        }

        authToken = response.jsonPath().getString("token"); // adjust key

        if ( authToken == null ||  authToken.isEmpty()) {
            throw new RuntimeException("Token missing in auth response");
        }

        System.out.println("ReqRes token generated");
        return authToken;
    }
    protected RequestSpecification getAuthenticatedSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader(API_KEY_HEADER, API_KEY_VALUE)
                .addHeader("Authorization", "Bearer " + getAuthToken())
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
