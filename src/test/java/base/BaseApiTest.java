package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    protected RequestSpecification requestSpec;

    @BeforeMethod
    public void setup() {

        RestAssured.baseURI = "https://reqres.in/api";

        requestSpec = RestAssured
                .given()
                .header("x-api-key", "reqres_8d469b8d719b48cc92180a3180eb2e0d")
                .contentType("application/json");
    }

}
