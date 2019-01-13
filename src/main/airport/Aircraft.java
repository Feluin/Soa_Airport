package airport;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;

public class Aircraft{
    private int id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private ArrayList<Seat> seats;
    private ArrayList<Wing> wing;
    private EventBus eventBus;


    public Aircraft(int id, String manufacturer, int numberOfSeatFirstClass, int numberOfSeatBusinessClass, int numberOfSeatEconomyClass, ArrayList<Seat> seats, ArrayList<Wing> wing) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.numberOfSeatFirstClass = numberOfSeatFirstClass;
        this.numberOfSeatBusinessClass = numberOfSeatBusinessClass;
        this.numberOfSeatEconomyClass = numberOfSeatEconomyClass;
        this.seats = seats;
        this.wing = wing;
        this.eventBus = new EventBus("EB-A380");
    }

    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }

}
