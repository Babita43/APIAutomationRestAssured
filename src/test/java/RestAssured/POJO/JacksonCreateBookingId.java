package RestAssured.POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;


public class JacksonCreateBookingId {
    @Test
    void createBooking() throws JsonProcessingException {

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

        ObjectMapper om = new ObjectMapper();
        String jsonString= om.writerWithDefaultPrettyPrinter().writeValueAsString(b);
        System.out.println("Jaskon String output is " + jsonString);

        RequestSpecification req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        Response res = req.when().body(jsonString).post();
        String output = res.asString();
        System.out.println(output);
        ValidatableResponse v = res.then().statusCode(200);


        Id i = new Id();

        Id getresponse = om.readValue(output, Id.class);
        System.out.println("Jackosn response id " + getresponse.getBookingid());
        System.out.println("whole output : " + getresponse.getBooking().getFirstname());
        //Assert.assertEquals(getresponse.getBooking().getFirstname(), "Ashu");
Assertions.assertThat(getresponse.getBooking().getFirstname()).isNotNull().isNotBlank().contains("Ashu");
    }
}
