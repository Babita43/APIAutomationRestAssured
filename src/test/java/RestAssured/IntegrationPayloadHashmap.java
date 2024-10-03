package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegrationPayloadHashmap {
    @Test
    public void IntegrateDelete() {
        RequestSpecification req;
        Response res;
        ValidatableResponse v;

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");

//create token
        Map<String, Object> jsonMapA = new LinkedHashMap<>();
        jsonMapA.put("username", "admin");
        jsonMapA.put("password", "password123");

        System.out.println(jsonMapA);

        req.basePath("/auth");
        req.contentType(ContentType.JSON);
        res = req.when().body(jsonMapA).post();
        String token = res.jsonPath().getString("token");
        System.out.println(token);
        v = res.then().statusCode(200);

        //create booking
        Map<String, Object> jsonMap = new LinkedHashMap<>();
        jsonMap.put("firstname", "Jim");
        jsonMap.put("lastname", "Brown");
        jsonMap.put("totalprice", 111);
        jsonMap.put("depositpaid", true);
        jsonMap.put("additionalneeds", "Breakfast");

        Map<String, Object> jsonMap1 = new LinkedHashMap();
        jsonMap1.put("checkin", "2018-01-01");
        jsonMap1.put("checkout", "2019-01-01");
        jsonMap.put("bookingdates", jsonMap1);

        System.out.println(jsonMap);

        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        res = req.when().body(jsonMap).post();
        Integer bookingid = res.jsonPath().getInt("bookingid");
        System.out.println(bookingid);
        v = res.then().statusCode(200);

        //update the booking
        Map<String, Object> jsonPatch = new LinkedHashMap();
        jsonPatch.put("firstname", "James");
        jsonPatch.put("lastname", "Brown");
        System.out.println(jsonPatch);

        req.basePath("/booking/" + bookingid);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        res = req.when().body(jsonPatch).patch();
        String updated = res.asString();
        System.out.println("Updated output is :" + updated);
        v = res.then().statusCode(200);

       // delete the booking

        req.basePath("/booking/" + bookingid);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        res = req.when().body(jsonPatch).delete();
        String output = res.asString();
        System.out.println("Deleted output is :" + output);
        v = res.then().statusCode(201);
    }

}


