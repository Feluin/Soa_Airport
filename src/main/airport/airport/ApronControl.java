package airport.airport;

import airport.AirCraftEvents.TaxiEvent;
import airport.aircraft.Aircraft;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

public class ApronControl {
    private EventBus eventBus;
    private String name;

    public ApronControl(String name) {
        this.name = name;
    }
    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }

    public void taxi(Aircraft aircraft,Location start,
        List<Location> junktions, Location end){
        eventBus.post(new TaxiEvent(aircraft,start,junktions,end));
    }
}
