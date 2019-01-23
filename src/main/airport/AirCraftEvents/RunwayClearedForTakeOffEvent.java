package airport.AirCraftEvents;

import airport.airport.RunwayDirection;
import airport.aircraft.Aircraft;

public class RunwayClearedForTakeOffEvent extends AircraftEvent
{
    private RunwayDirection runwayDirection;

    public RunwayClearedForTakeOffEvent(final Aircraft aircraft, RunwayDirection runwayDirection)
    {
        super(aircraft);
        this.runwayDirection = runwayDirection;
    }

    public RunwayDirection getRunwayDirection() {
        return runwayDirection;
    }
}
