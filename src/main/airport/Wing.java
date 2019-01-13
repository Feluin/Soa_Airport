package airport;

public class Wing
{
    private WingPosition wingPosition;
    private Flap flap;

    public Wing(WingPosition wingPosition, Flap flap) {
        this.wingPosition = wingPosition;
        this.flap = flap;
    }

    public void setWingPosition(WingPosition wingPosition) {
        this.wingPosition = wingPosition;
    }

    public void setFlap(Flap flap) {
        this.flap = flap;
    }
}
