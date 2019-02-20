package airport.aircraft;

import airport.AirCraftEvents.HoldShortEvent;
import airport.AirCraftEvents.RunwayClearedForTakeOffEvent;
import airport.AirCraftEvents.RunwayClearedToLandEvent;
import airport.AirCraftEvents.TaxiEvent;
import airport.Bookingclass;
import airport.aircraft.crew.Crew;
import airport.aircraft.crew.Employee;
import airport.aircraft.crew.FlightAttendant;
import airport.aircraft.crew.Pilot;
import airport.aircraft.parts.BladeMaterial;
import airport.aircraft.parts.Fan;
import airport.aircraft.parts.Flap;
import airport.aircraft.parts.Seat;
import airport.aircraft.parts.Wing;
import airport.aircraft.parts.WingPosition;
import airport.airport.Airport;
import airport.airport.locations.ControlPoint;
import airport.airport.locations.Location;
import airport.airport.locations.Point;
import airport.database.FlightRecorder;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Aircraft extends Subscriber
{
    private int id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private Location currentLocation;
    //if loc==null aircraft is in the air
    private List<Seat> seats = new ArrayList<>();
    private List<Wing> wing = new ArrayList<>();
    private List<Crew> crew = new ArrayList<>();
    private AirCraftName airCraftName;
    private Frequency frequency;

    public Aircraft(AirCraftName name,
        Location location)
    {
        build(name, location);
    }

    public void build(AirCraftName name,
        Location location)
    {

        airCraftName = name;
        currentLocation = location;
        if (currentLocation != null)
        {
            frequency = Frequency.ApronControl;
            currentLocation.setAircraft(this);
        } else
        {
            frequency = Frequency.Tower;
        }
        System.out.println("---Airplane.build");
        id = 0;
        manufacturer = "EB-A380";
        numberOfSeatFirstClass = 60;
        numberOfSeatBusinessClass = 100;
        numberOfSeatEconomyClass = 408;
        for (int i = 0; i < 60; i++)
        {
            seats.add(new Seat(Bookingclass.First, i));
        }
        for (int i = 0; i < 100; i++)
        {
            seats.add(new Seat(Bookingclass.Business, i));
        }
        for (int i = 0; i < 408; i++)
        {
            seats.add(new Seat(Bookingclass.Economy, i));
        }
        wing.add(new Wing(WingPosition.Left, new Flap(0), new Fan(BladeMaterial.Titan)));
        wing.add(new Wing(WingPosition.Right, new Flap(0), new Fan(BladeMaterial.Titan)));
        Pilot pilot = new Pilot(new Employee("Peter Mayer"), 500);
        FlightAttendant flightAttendant1 = new FlightAttendant(new Employee("Klara Mayer"), true);
        FlightAttendant flightAttendant2 = new FlightAttendant(new Employee("Kirsten Plob"), false);
        FlightAttendant flightAttendant3 = new FlightAttendant(new Employee("Hans Gustaff"), false);

        crew.add(pilot);
        crew.add(flightAttendant1);
        crew.add(flightAttendant2);
        crew.add(flightAttendant3);
        System.out.println("---Airplane has been builed!");
    }

    @Subscribe
    public void recieve(TaxiEvent taxiEvent)
    {
        if (this.equals(taxiEvent.getAircraft()) && this.currentLocation.equals(taxiEvent.getStartpoint()))
        {
            FlightRecorder.instance.insert(id, "receive: " + taxiEvent);
            if (taxiEvent.getJunktionList() != null)
            {
                taxiEvent.getJunktionList().forEach(this::moveAircraftToLocation);
            }
            moveAircraftToLocation(taxiEvent.getEndpoint());
        }
    }

    @Subscribe
    public void recieve(HoldShortEvent holdShortEvent)
    {
        if (this.equals(holdShortEvent.getAircraft()) && this.currentLocation.equals(holdShortEvent.getLocation()))
        {
            FlightRecorder.instance.insert(id, "receive: " + holdShortEvent);

            switchfrequency();
        }
    }

    @Subscribe
    public void recieve(RunwayClearedForTakeOffEvent runwayClearedForTakeOffEventEvent)
    {
        if (this.equals(runwayClearedForTakeOffEventEvent.getAircraft()))
        {
            FlightRecorder.instance.insert(id, "receive: " + runwayClearedForTakeOffEventEvent);
            if (currentLocation instanceof ControlPoint &&
                ((ControlPoint) currentLocation).getRunwayDirection().equals(runwayClearedForTakeOffEventEvent.getRunwayDirection()) ||
                currentLocation instanceof Point && ((Point) currentLocation).isControlpoint() &&
                    ((Point) currentLocation).getControlPoint().getRunwayDirection().equals(runwayClearedForTakeOffEventEvent.getRunwayDirection()))
            {

                currentLocation.setAircraft(null);
                currentLocation = null;
            } else
            {
                //TODO ERROR
            }

        }
    }

    @Subscribe
    public void recieve(RunwayClearedToLandEvent runwayClearedToLandEvent)
    {

        if (this.equals(runwayClearedToLandEvent.getAircraft()))
        {
            FlightRecorder.instance.insert(id, "receive: " + runwayClearedToLandEvent);
            if (currentLocation == null)
            {
                ControlPoint controlPoint = runwayClearedToLandEvent.getRunwaydirection().getControlPoint();
                controlPoint.setAircraft(this);
                currentLocation = controlPoint;
            } else
            {
                //TODO ERROR
            }
//TODO
        }
    }

    public void moveAircraftToLocation(Location location)
    {
        if (currentLocation.isPossibleLocation(location))
        {
            if (location.getAircraft() == null)
            {
                if (location instanceof Point && ((Point) location).isControlpoint())
                {
                    ControlPoint controlPoint = ((Point) location).getControlPoint();
                    currentLocation.removeAircraft(this);
                    controlPoint.setAircraft(this);
                    currentLocation = controlPoint;

                } else
                {
                    currentLocation.removeAircraft(this);
                    location.setAircraft(this);
                    currentLocation = location;
                }
            } else
            {
                //TODO da is ein aircraft schon
            }
        } else
        {
            //TODO operation not possible
        }
    }

    public AirCraftName getAirCraftName()
    {
        return airCraftName;
    }

    public enum AirCraftName
    {
        F01, F02, F03,
        F04, F05, F06,
        F07, F08, F09,
        F10, F11, F12,
        F13, F14, F15,
        F16, F17, F18,
        F19, F20,
    }

    private enum Frequency
    {
        Tower, ApronControl
    }

    private void switchfrequency()
    {
        if (frequency.equals(Frequency.ApronControl))
        {
            Airport.instance.getApronControl().removeSubscriber(this);
            Airport.instance.getTower().addSubscriber(this);
            frequency = Frequency.Tower;
        } else
        {
            Airport.instance.getApronControl().addSubscriber(this);
            Airport.instance.getTower().removeSubscriber(this);
            frequency = Frequency.ApronControl;
        }
    }

    @Override
    public String toString() {
        return airCraftName.toString();
    }
}
