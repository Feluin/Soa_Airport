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
    private Airport airport;
    private LocationManager manager;

    public ApronControl(String name,
                        Airport airport)
    {
        this.name = name;

        this.airport = airport;
        manager=airport.getLocationmanager();
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
        taxi(airport.getAircaft(aircaft), manager.getLocationByString(start), junktions.stream().map(s ->  manager.getLocationByString(s)).collect(Collectors.toList()), manager.getLocationByString(end));
    }

}
