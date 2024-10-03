package RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBooking {
  @Test
    void test() {
    //    given
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
                .when().get()
                .then().log().all().statusCode(200);
    }
}
