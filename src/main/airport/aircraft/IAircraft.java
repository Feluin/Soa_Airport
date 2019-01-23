package airport.aircraft;

import airport.AirCraftEvents.HoldShortEvent;
import airport.AirCraftEvents.RunwayClearedForTakeOffEvent;
import airport.AirCraftEvents.RunwayClearedToLandEvent;
import airport.AirCraftEvents.TaxiEvent;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Flow;

public interface IAircraft {
    @Subscribe
    void taxi(TaxiEvent taxiEvent);

    @Subscribe
    void holdShort(HoldShortEvent holdShortEvent);

    @Subscribe
    void takeOff(RunwayClearedForTakeOffEvent runwayClearedForTakeOffEventEvent);

    @Subscribe
    void land(RunwayClearedToLandEvent runwayClearedToLandEvent);
}
