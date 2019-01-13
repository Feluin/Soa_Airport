package airport;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Aircraft{
    private int id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private List<Seat> seats = new ArrayList<>();
    private List<Wing> wing = new ArrayList<>();
    private EventBus eventBus;


    public Aircraft() {

        this.eventBus = new EventBus("EB-A380");
    }

    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }

    public void build() {
        System.out.println("---Airplane.build");
        id = 0;
        manufacturer = "EB-A380";
        numberOfSeatFirstClass = 60;
        numberOfSeatBusinessClass = 100;
        numberOfSeatEconomyClass = 408;
        for(int i = 0; i<60;i++) {
            seats.add(new Seat(Bookingclass.First,i));
        }
        for(int i = 0; i<100;i++) {
            seats.add(new Seat(Bookingclass.Business,i));
        }
        for(int i = 0;i<408;i++) {
            seats.add(new Seat(Bookingclass.Economy, i));
        }
        wing.add(new Wing(WingPosition.Left,new Flap(0)));
        wing.add(new Wing(WingPosition.Right, new Flap(0)));
    }

}
