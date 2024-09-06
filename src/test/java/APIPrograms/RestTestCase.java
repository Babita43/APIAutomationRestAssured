package APIPrograms;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RestTestCase {
    @Test
    public void getReq(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking")
                .when().get()
                .then().log().all().statusCode(200);


    }
}
