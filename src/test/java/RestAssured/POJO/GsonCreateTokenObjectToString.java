package RestAssured.POJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GsonCreateTokenObjectToString {
    @Test
    public void token() {
        Auth a = new Auth();
        a.setUsername("admin");
        a.setPassword("password123");

        // as above payload is object, convert it into string because it is lightweight (serialization process)
        Gson gson = new Gson();
        String stringPayloadConvert = gson.toJson(a);


        RequestSpecification req = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("auth");
        req.contentType(ContentType.JSON);
        Response res = req.when().body(stringPayloadConvert).post();
        String response = res.jsonPath().getString("token");
        System.out.println("The string output : " + response);
        ValidatableResponse v = res.then().statusCode(200);
    }
@Test
public void verifyResponse() {
        String response = "{\n" +
                "    \"token\": \"abc123\"\n" +
                "}";
            Gson gson1 = new Gson();
//now the output will is string will convert it to object
            BookingResponse resp = gson1.fromJson(response, BookingResponse.class);
            String s = resp.getToken();
            System.out.println(s);
        }

    }

