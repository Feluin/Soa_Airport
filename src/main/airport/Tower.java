package airport;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Tower {
    private EventBus eventBus;
    private String name;

    public Tower(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }
}
