package airport.AirCraftEvents;

import airport.aircraft.Aircraft;

public class AircraftEvent implements IAirCraftEvent
{
    private Aircraft aircraft;

    public AircraftEvent(Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }

    @Override
    public Aircraft getAircraft()
    {
        return aircraft;
    }
}
