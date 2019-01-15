package airport.AirCraftEvents;

import airport.aircraft.Aircraft;
import airport.airport.Junktion;
import airport.airport.Location;

import java.util.List;

public class TaxiEvent extends AircraftEvent
{
    //das mit objekten ist scheisse
    public TaxiEvent(Aircraft aircraft,
        Location startpoint,
        List<Junktion> junktionList,
        Location endpoint)
    {
        super(aircraft);

    }
}
