package tests.api;

import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PayloadBuilder;
import java.util.Map;


public class PostApiTest extends BaseApiTest {
    //@Test
    public void CheckPostApi(){
        Map<String, Object> payload = PayloadBuilder.createUserPayload();
        Response response = requestSpec
                        .body(payload)
                        .when()
                        .post("/users");

        response.then().statusCode(201);
        String expectedName = payload.get("name").toString();
        Assert.assertEquals(response.jsonPath().getString("name"),expectedName);
        System.out.println(expectedName + " Verified");

        String idValue = response.jsonPath().getString("id");
        Assert.assertNotNull(idValue,"Id is null");
        System.out.println(idValue + " Verified Successfully");

        String timeStamp = response.jsonPath().getString("createdAt");
        System.out.println("Record Created at" + timeStamp);

        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());
        System.out.println("Created record ID "+idValue);

    }
}
