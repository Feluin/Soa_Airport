package airport.AirCraftEvents;

import airport.ControlStation;
import airport.aircraft.Aircraft;

public class HoldShortEvent extends AircraftEvent
{
    public HoldShortEvent(final Aircraft aircraft,
        final ControlStation controlStation)
    {
        super(aircraft);
    }
}
