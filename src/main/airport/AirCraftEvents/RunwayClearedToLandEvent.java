package airport.AirCraftEvents;

import airport.airport.RunwayDirection;
import airport.aircraft.Aircraft;

public class RunwayClearedToLandEvent extends AircraftEvent
{

    private final RunwayDirection runwaydirection;

    public RunwayClearedToLandEvent(final Aircraft aircraft, RunwayDirection runwayDirection)
    {
        super(aircraft);
        this.runwaydirection=runwayDirection;
    }

    public RunwayDirection getRunwaydirection() {
        return runwaydirection;
    }
}
