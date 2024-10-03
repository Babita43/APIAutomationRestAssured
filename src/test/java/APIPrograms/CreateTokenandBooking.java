package APIPrograms;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTokenandBooking {
    @Test
    void generateToken(){
        //given uri when  content type json post payload
        // for post what do we needed
        //1. given URL but with baseuri + basepath
        //header=content type-Json
        //2. when - body that contains payload and method post
        //3. then- log, all.status
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response res = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().body(payload).post();

        JsonPath js = new JsonPath(res.getBody().asString());
        System.out.println("output" + js.getString("token") );
        String token = js.getString("token");
        Assert.assertEquals(token,"8404c52338eecb7");
       //System.out.println("output"+res.getBody());
    }
    @Test (priority = 0)
    void createBooking(){
        String payload ="{\n" +
                "    \"firstname\" : \"Cherry\",\n" +
                "    \"lastname\" : \"Brownie\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
                .then().log().all().statusCode(200);
    }
}
