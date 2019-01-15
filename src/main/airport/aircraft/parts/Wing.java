package airport.aircraft.parts;

public class Wing
{
    private WingPosition wingPosition;
    private Flap flap;
    private Fan fan;

    public Wing(WingPosition wingPosition, Flap flap, Fan fan) {
        this.wingPosition = wingPosition;
        this.flap = flap;
        this.fan = fan;
    }

    public void setWingPosition(WingPosition wingPosition) {
        this.wingPosition = wingPosition;
    }

    public void setFlap(Flap flap) {
        this.flap = flap;
    }
}
