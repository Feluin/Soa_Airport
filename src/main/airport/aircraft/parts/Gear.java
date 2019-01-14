package airport.aircraft.parts;

import airport.Wheel;

import java.util.ArrayList;

public class Gear implements IGear
{
    private GearType gearType;
    private boolean isDown =false;
    private boolean isBrakeSet =false;
    private ArrayList<Wheel> wheels;

    public Gear(GearType gearType, ArrayList<Wheel> wheels) {
        this.gearType = gearType;
        this.wheels = wheels;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public boolean isDown() {
        return isDown;
    }

    public boolean isBrakeSet() {
        return isBrakeSet;
    }

    @Override
    public void up() {
        isDown = false;
    }

    @Override
    public void down() {
        isDown = true;
    }

    @Override
    public void setBrake() {
        isBrakeSet = true;
    }

    @Override
    public void releaseBrake() {
        isBrakeSet = false;
    }
}
