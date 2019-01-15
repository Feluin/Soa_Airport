package airport.AirCraftEvents;

import airport.airport.RunwayDirection;
import airport.aircraft.Aircraft;

public class RunwayClearedForTakeOff extends AircraftEvent
{
    public RunwayClearedForTakeOff(final Aircraft aircraft, RunwayDirection runwayDirection)
    {
        super(aircraft);
    }
}
