package airport.AirCraftEvents;

import airport.aircraft.Aircraft;
import airport.airport.locations.Location;

import java.util.List;

public class TaxiEvent extends AircraftEvent
{

    private Location startpoint;
    private List<Location> junktionList;
    private Location endpoint;

    public TaxiEvent(Aircraft aircraft,
                     Location startpoint,
                     List<Location> junktionList,
                     Location endpoint)
    {
        super(aircraft);


        this.startpoint = startpoint;
        this.junktionList = junktionList;
        this.endpoint = endpoint;
    }

    public List<Location> getJunktionList() {
        return junktionList;
    }

    public Location getStartpoint() {
        return startpoint;
    }

    public Location getEndpoint() {
        return endpoint;
    }

    @Override
    public String toString() {
        return startpoint.toString() + " " + junktionList.toString() + " " + endpoint;
    }
}
