package RestAssured.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateBooking {
@Test
    public void booking() {

        Booking book = new Booking();
        book.setFirstname("Aman");
        book.setLastname("Desuza");
        book.setTotalprice(111);
        book.setDepositpaid(true);
        book.setAdditionalneeds("Books");


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-03-03");
        bookingDates.setCheckout("2024-4-02");
        book.setBookingdates(bookingDates);


        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(book).post()
                .then().log().all().statusCode(200);
    }

}
