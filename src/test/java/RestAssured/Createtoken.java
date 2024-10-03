package RestAssured;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Createtoken {
    public void token(){
        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        if (RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType("application/json")
                .when().body(payload).post().then().log().all().statusCode(200) != null) {

        }


    }
}
