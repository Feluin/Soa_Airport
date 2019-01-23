package airport.AirCraftEvents;

import airport.aircraft.Aircraft;

public class AircraftEvent implements IAirCraftEvent
{
    private Aircraft aircraft;

    AircraftEvent(Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }

    @Override
    public Aircraft getAircraft()
    {
        return aircraft;
    }
}
