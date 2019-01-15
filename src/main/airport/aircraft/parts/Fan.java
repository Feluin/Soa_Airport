package airport.aircraft.parts;

import airport.aircraft.parts.Blade;
import airport.aircraft.parts.BladeMaterial;
import airport.aircraft.parts.IFan;

import java.util.ArrayList;
import java.util.List;

public class Fan implements IFan
{
    private List<Blade> blades = new ArrayList<>();
    private int rpm;
    private boolean isStart = false;

    public Fan(BladeMaterial bladeMaterial) {
        for(int i = 0; i<96;i++) {
            blades.add(new Blade(i, bladeMaterial));
        }
    }

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
