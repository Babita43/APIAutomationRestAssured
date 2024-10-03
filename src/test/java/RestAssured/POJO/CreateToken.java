package RestAssured.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateToken {
   @Test
    public void token(){
        Auth a= new Auth();
        a.setUsername("admin");
        a.setPassword("password123");

       RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("auth")
               .contentType(ContentType.JSON)
               .when().body(a).post()
               .then().statusCode(200);
    }
}
