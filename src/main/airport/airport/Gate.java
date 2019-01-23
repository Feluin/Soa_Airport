package airport.airport;

import airport.aircraft.Aircraft;

public class Gate extends Location {
    private boolean isOpen;

    private Aircraft aircraft;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public enum GateNames{
        A01,
        A02,
        A03,
        A04,
        A05,
        B01,
        B02,
        B03,
        B04,
        B05,

    }
}
