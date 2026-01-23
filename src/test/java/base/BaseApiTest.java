package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    protected RequestSpecification requestSpec;

    private static String authToken;

    private static final String BASE_URI = "https://reqres.in";
    private static final String AUTH_PATH = "/api/login";
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String API_KEY_VALUE = "reqres_8d469b8d719b48cc92180a3180eb2e0d";

    @BeforeMethod
    public void setup() {
        requestSpec = getAuthenticatedSpec();
    }

    // ---------- AUTH TOKEN GENERATION ----------
    protected static String getAuthToken() {

        if (authToken != null) {
            return authToken;
        }

        RequestSpecification authSpec =
                new RequestSpecBuilder()
                        .setBaseUri(BASE_URI)
                        .setBasePath(AUTH_PATH)
                        .addHeader("Content-Type", "application/json")
                        .addHeader(API_KEY_HEADER, API_KEY_VALUE)
                        .setBody("""
                            {
                                "email": "eve.holt@reqres.in",
                                "password": "cityslicka"
                            }
                        """)
                        .build();

        Response response = authSpec
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        authToken = response.jsonPath().getString("token");

        if (authToken == null || authToken.isEmpty()) {
            throw new RuntimeException("Token missing in auth response");
        }

        System.out.println("ReqRes token generated");
        return authToken;
    }

    // ---------- AUTHENTICATED REQUEST SPEC ----------
    protected RequestSpecification getAuthenticatedSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader(API_KEY_HEADER, API_KEY_VALUE)
                .addHeader("Authorization", "Bearer " + getAuthToken())
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
