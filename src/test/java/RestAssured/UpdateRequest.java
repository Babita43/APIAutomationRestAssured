package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateRequest {
    RequestSpecification req;
    Response res;
    ValidatableResponse v;

    @BeforeMethod
    public void before() {
        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
    }

    @Test
    public void update() {

        //create token
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        req.body(payload);
        res = req.when().post();
        String token = res.jsonPath().getString("token");
        System.out.println("the token is : " + token);
        v = res.then().statusCode(200);

        //create id
        String pay = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req.basePath("/booking");
        req.body(pay);
        req.contentType(ContentType.JSON);
        res = req.when().post();
        Integer bookingid = res.jsonPath().getInt("bookingid");
        System.out.println("booking id is: " + bookingid);
        v = res.then().statusCode(200);
        //update the request
        String up = "{\n" +
                "    \"firstname\" : \"Jimin\",\n" +
                "    \"lastname\" : \"BTS\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req.basePath("/booking/" + bookingid);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(up);
        res = req.when().put();
        String updated = res.asString();
        System.out.println(updated);
       v= res.then().log().all();
       v.statusCode(200);
       v.body("firstname", Matchers.equalTo("Jimin"));
    }
}
