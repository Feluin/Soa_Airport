package airport.AirCraftEvents;

import airport.airport.ControlStation;
import airport.aircraft.Aircraft;
import airport.airport.Location;

public class HoldShortEvent extends AircraftEvent
{
    public HoldShortEvent(final Aircraft aircraft,
        final Location controlStation)
    {

        super(aircraft);
    }
}
