package APIPrograms;

import io.restassured.RestAssured;

public class RestAssuredHello {

    public static void main(String[] args) {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking").when().get().then().log().all().statusCode(200);
    }
}
