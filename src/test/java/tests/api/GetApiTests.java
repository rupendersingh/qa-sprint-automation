package tests.api;

import base.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class GetApiTests extends BaseApiTest {

    @Test
    public void chEckStatusCode () {

        Response response = requestSpec
                .when()
                        .get("/users/2");
        // Step 2: Assert status code
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code is not 200");
        int userId = response.jsonPath().getInt("data.id");
        Assert.assertEquals(userId, 2, "User ID does not match");
    }

    @Test
    public void ChecklistSize(){
        Response response = requestSpec
                .when()
                .get("/users/2");

        //int sizeOfData = response.jsonPath().getInt("data.size()");
        //Assert.assertTrue(sizeOfData>1, "Data list is empty");
        Map<String, Object> dataMap = response.jsonPath().getMap("data");
        Assert.assertNotNull(dataMap, "Data object is null");
        Assert.assertTrue(dataMap.containsKey("id"), "Key id is missing");
    }
    @Test
    public void CheckContentType(){
        Response response = requestSpec
                .when()
                .get("/users/2");
        String responseType = response.contentType();
        Assert.assertEquals(responseType,"application/json; charset=utf-8");
    }
    @Test
    public void checkQueryParam(){
        int givenPage = 2;
        Response response = requestSpec
                .queryParam("page",givenPage)
                .when()
                .get("/users");
        response
                .then()
                .statusCode(200);

        int pageNumber = response.jsonPath().getInt("page");
        Assert.assertEquals(pageNumber,givenPage);
    }

    @Test
    public void checkEdgeCase(){
        int givenPage = 10;
        Response response = requestSpec
                .queryParam("page",givenPage)
                .when()
                .get("/users");
        response
                .then()
                .statusCode(200);

        int sizeOfData = response.jsonPath().getInt("data.size()");
        //Array[] datamap = response.jsonPath().get("data");
        Assert.assertTrue(sizeOfData<1);
    }


}
