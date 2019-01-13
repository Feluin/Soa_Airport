package airport;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class ApronControl {
    private EventBus eventBus;
    public void addSubscriber(Subscribe subscriber) {
        eventBus.register(subscriber);
    }

    public void removeSubscriber(Subscribe subscriber) {
        eventBus.unregister(subscriber);
    }
}
