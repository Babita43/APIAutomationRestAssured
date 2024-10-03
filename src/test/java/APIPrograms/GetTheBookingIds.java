package APIPrograms;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetTheBookingIds {

  @Test (groups = {"positive"})
  void bookingID(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking/1728")
                .when().get().then().log().all().statusCode(200);
        System.out.println("It is postive case, 200 is status");
    }
@Test (groups = {"negative"})
    void bookingIDNegative(){
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking/1728")
                .when().get().then().log().all().statusCode(400);
        System.out.println("It is negative case, 200 is not status");
    }
}
