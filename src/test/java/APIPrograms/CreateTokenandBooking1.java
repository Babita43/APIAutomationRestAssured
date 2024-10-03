package APIPrograms;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTokenandBooking1
{
    RequestSpecification req;
    Response resp;
    ValidatableResponse val;


@BeforeMethod
  public  void repeatData(){
        req = RestAssured.given();
        req = req.baseUri(
                "https://restful-booker.herokuapp.com");
        req = req.basePath("/booking");
    }
    @Test
   public void createbook(){
        String payload = "{\n" +
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
        req = req.contentType(ContentType.JSON);
        req = req.body(payload);

        resp = req.when().post();
        val = resp.then().log().all().statusCode(200);

    }
}
