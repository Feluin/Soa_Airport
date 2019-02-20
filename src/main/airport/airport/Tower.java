package airport.airport;

import airport.AirCraftEvents.HoldShortEvent;
import airport.AirCraftEvents.RunwayClearedForTakeOffEvent;
import airport.AirCraftEvents.RunwayClearedToLandEvent;
import airport.aircraft.Aircraft;
import airport.aircraft.Subscriber;
import airport.airport.locations.Location;
import airport.airport.locations.RunwayDirection;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Tower
{
    private EventBus eventBus;
    private String name;

    public Tower(String name)
    {
        this.name = name;
        eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber)
    {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber)
    {
        eventBus.unregister(subscriber);
    }

    public void runwayclearedtoLand(Aircraft aircraft,
        RunwayDirection runwayDirection)
    {
        eventBus.post(new RunwayClearedToLandEvent(aircraft, runwayDirection));
    }

    public void runwayclearedtoLand(String aircraft,
        String runwayDirection)
    {
        runwayclearedtoLand(Airport.instance.getAircaft(aircraft), RunwayDirection.valueOf(runwayDirection));
    }

    public void runwayClearedToTakeoff(Aircraft aircraft,
        RunwayDirection runwayDirection)
    {
        eventBus.post(new RunwayClearedForTakeOffEvent(aircraft, runwayDirection));
    }
    public void runwayClearedToTakeoff(String aircraft,
        String  runwayDirection)
    {
        runwayClearedToTakeoff(Airport.instance.getAircaft(aircraft), RunwayDirection.valueOf(runwayDirection));
    }
    public void holdshort(Aircraft aircraft,
        Location location)
    {
        eventBus.post(new HoldShortEvent(aircraft, location));
    }

    public void holdshort(String aircraft,
        String location)
    {
        holdshort(Airport.instance.getAircaft(aircraft), Airport.instance.getLocationmanager().getLocationByString(location));
    }

}
