package RestAssured.POJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GsonCreateBookingId {
   @Test
    void createBooking(){

        Booking b = new Booking();
        b.setFirstname("Ashu");
        b.setLastname("shrivastav");
        b.setTotalprice(500);
        b.setDepositpaid(false);
        b.setAdditionalneeds("lunch");

        BookingDates bd = new BookingDates();
        bd.setCheckin("2024-5-8");
        bd.setCheckout("2024-4-5");

        b.setBookingdates(bd);

        Gson gson = new Gson();
        String obToStr= gson.toJson(b);

        RequestSpecification req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
      Response res= req.when().body(obToStr).post();
      String output =res.asString();
        System.out.println(output);
        ValidatableResponse v= res.then().statusCode(200);



        Id i = new Id();

    Id getresponse =  gson.fromJson(output,Id.class);
       System.out.println("gson response id " + getresponse.getBookingid());
       System.out.println("whole output : "+ getresponse.getBooking().getFirstname());   ;
       Assert.assertEquals(getresponse.getBooking().getFirstname(), "Ashu");
    }
}
