package airport.AirCraftEvents;

import airport.airport.locations.RunwayDirection;
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

    @Override
    public String toString() {
        return runwayDirection.name().toString();
    }
}
