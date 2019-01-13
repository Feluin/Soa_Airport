package airport;

import java.util.ArrayList;

public class Fan implements IFan {
    private List<Blade> blades = new ArrayList<>();
    private int rpm;
    private boolean isStart = true;


    @Override
    public void increaseRPM(int value) {
        rpm += value;
    }

    @Override
    public void decreaseRPM(int value) {
        rpm -= value;
    }

    @Override
    public void shutdown() {
        isStart = false;
    }

    @Override
    public void start() {
        isStart = true;
    }
}
