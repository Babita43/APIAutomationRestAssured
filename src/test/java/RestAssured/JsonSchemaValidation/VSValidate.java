package RestAssured.JsonSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class VSValidate {
    public static void main(String[] args) {
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
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/RestAssured/JsonSchemaValidation/JSSchema.json")));

    }
}
