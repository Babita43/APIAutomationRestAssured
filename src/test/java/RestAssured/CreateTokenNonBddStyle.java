package RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateTokenNonBddStyle {
    @Test
    public void token()
    {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com").basePath("/auth");
        req.contentType("application/json");
        Response res = req.when().body(payload).post();
        String respo = res.jsonPath().toString();
        System.out.println("the respo is : " + respo);
        ValidatableResponse v= res.then().log().all().statusCode(200);
    }
}
