package APIPrograms;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrudPut {
    @Test
    void putReq() {

        ValidatableResponse v;
        Response res;

        //generate token
        //setting request
        RequestSpecification req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/auth");
        req.contentType(ContentType.JSON);


        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
//sending request
        req.body(payload);
        res = req.when().post();

        //verify
        v = res.then().log().all();
        v.statusCode(200);
        String token = v.extract().body().path("token");
        System.out.println(token);


//create booking id
        String payloadCreate = "{\n" +
                "    \"firstname\" : \"suga\",\n" +
                "    \"lastname\" : \"min\",\n" +
                "    \"totalprice\" : 112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        req.basePath("/booking");
        req.body(payloadCreate);
        req.contentType(ContentType.JSON);
        res = req.when().post();
        String str =res.asString();
        System.out.println(str);
        v = res.then().statusCode(200);
        // v.statusCode(200);
        Integer bookingid = v.extract().path("bookingid");

        System.out.println(bookingid);
        //put
        String payloadPut = "{\n" +
                "    \"firstname\" : \"yoongi\",\n" +
                "    \"lastname\" : \"min\",\n" +
                "    \"totalprice\" : 112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        req.basePath("/booking/" + bookingid);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payloadPut);

        res = req.when().put();
        v = res.then().log().all().statusCode(200);
        v.body("firstname", Matchers.equalTo("yoongi"));


        //delete
        req.cookie("token",token);
        req.contentType(ContentType.JSON);
        res =req.when().delete();
        v=res.then().log().all().statusCode(201);
       System.out.println("Successfullly deleted");
       Assert.assertEquals(201,201);
        System.out.println("it is verified");
    }


}
