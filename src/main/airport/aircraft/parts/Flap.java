package airport.aircraft.parts;

import airport.aircraft.parts.IFlap;

public class Flap implements IFlap
{
    private int id;
    private int degree;

    public Flap(int id) {
        this.id = id;
    }

    @Override
    public void neutral() {
        degree=0;
    }

    @Override
    public void levelOne() {
        degree = 5;
    }

    @Override
    public void levelTwo() {
        degree = 15;
    }

    @Override
    public void levelThree() {
        degree = 25;
    }

    public int getId() {
        return id;
    }

    public int getDegree() {
        return degree;
    }
}
