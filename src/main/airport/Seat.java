package airport;

public class Seat
{
    private Bookingclass bookingclass;
    private int id;

    public Seat(Bookingclass bookingclass, int id) {
        this.bookingclass = bookingclass;
        this.id = id;
    }

    public Bookingclass getBookingclass() {
        return bookingclass;
    }

    public int getId() {
        return id;
    }
}
