package airport;

import java.util.ArrayList;
import java.util.List;

public class Aircraft implements IAircraft {
    private int id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private List<Seat> seats = new ArrayList<>();
    private List<Wing> wing = new ArrayList<>();
    private List<Crew> crew;


    public Aircraft() {

    }


    @Override
    public void taxi() {

    }

    @Override
    public void holdShort() {

    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    public void build() {
        System.out.println("---Airplane.build");
        id = 0;
        manufacturer = "EB-A380";
        numberOfSeatFirstClass = 60;
        numberOfSeatBusinessClass = 100;
        numberOfSeatEconomyClass = 408;
        for(int i = 0; i<60;i++) {
            seats.add(new Seat(Bookingclass.First,i));
        }
        for(int i = 0; i<100;i++) {
            seats.add(new Seat(Bookingclass.Business,i));
        }
        for(int i = 0;i<408;i++) {
            seats.add(new Seat(Bookingclass.Economy, i));
        }
        wing.add(new Wing(WingPosition.Left,new Flap(0)));
        wing.add(new Wing(WingPosition.Right, new Flap(0)));
        Pilot pilot = new Pilot(new Employee("Peter Mayer"), 500);
        FlightAttendant flightAttendant1 = new FlightAttendant(new Employee("Klara Mayer"), true);
        FlightAttendant flightAttendant2 = new FlightAttendant(new Employee("Kirsten Plob"), false);
        FlightAttendant flightAttendant3 = new FlightAttendant(new Employee("Hans Gustaff"), false);

        crew.add(pilot);
        crew.add(flightAttendant1);
        crew.add(flightAttendant2);
        crew.add(flightAttendant3);
    }

}
