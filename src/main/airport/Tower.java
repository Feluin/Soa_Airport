package airport;

import airport.AirCraftEvents.HoldShortEvent;
import airport.aircraft.Aircraft;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Tower
{
    private EventBus eventBus;
    private String name;

    public Tower(String name)
    {
        this.name = name;
        eventBus=new EventBus();
    }

    public void addSubscriber(Subscribe subscriber)
    {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber)
    {
        eventBus.unregister(subscriber);
    }

    public void holdshort(Aircraft aircraft,ControlStation controlStation){
        eventBus.post(new HoldShortEvent(aircraft,controlStation));
    }

}
