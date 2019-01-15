package airport.AirCraftEvents;

import airport.airport.RunwayDirection;
import airport.aircraft.Aircraft;

public class RunwayClearedToLand extends AircraftEvent
{

    public RunwayClearedToLand(final Aircraft aircraft, RunwayDirection runwayDirection)
    {
        super(aircraft);
    }
}
