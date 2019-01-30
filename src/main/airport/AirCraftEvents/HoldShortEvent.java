package airport.AirCraftEvents;

import airport.aircraft.Aircraft;
import airport.airport.locations.Location;

public class HoldShortEvent extends AircraftEvent
{
    private final Location location;

    public HoldShortEvent(final Aircraft aircraft,
                          final Location controlStation)
    {

        super(aircraft);
        this.location=controlStation;
    }

    public Location getLocation() {
        return location;
    }
}
