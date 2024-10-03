package RestAssured.POJO;

public class Id {
    Id(){

    }

    private Integer bookingid;
    private Booking booking;
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Integer getBookingid(){
        return bookingid;
    }

    public void setBookingid(Integer bookingid){
        this.bookingid =bookingid;
    }
}
