package airport.airport;

import airport.AirCraftEvents.TaxiEvent;
import airport.aircraft.Aircraft;
import airport.airport.locations.Location;
import airport.airport.locations.LocationManager;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;
import java.util.stream.Collectors;

public class ApronControl
{
    private EventBus eventBus;
    private String name;
    private LocationManager manager;

    public ApronControl(String name,
        LocationManager manager)
    {
        this.name = name;
        this.manager = manager;
    }

    public void addSubscriber(Subscribe subscriber)
    {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber)
    {
        eventBus.unregister(subscriber);
    }

    public void taxi(Aircraft aircraft,
        Location start,
        List<Location> junktions,
        Location end)
    {
        eventBus.post(new TaxiEvent(aircraft, start, junktions, end));
    }

    public void taxi(String aircaft,
        String start,
        List<String> junktions,
        String end)
    {
        //TODO getAircaft
        taxi(new Aircraft(), manager.getLocationByString(start), junktions.stream().map(s ->  manager.getLocationByString(s)).collect(Collectors.toList()), manager.getLocationByString(end));
    }

}
