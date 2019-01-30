package airport.airport.locations;

import airport.aircraft.Aircraft;

public class Gate extends Location
{
    private boolean isOpen;
    private GateName gateName;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }


    public void setAircraft(Aircraft aircraft) {
        super.currentAircraft = aircraft;
    }

    public enum GateName
    {
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
    public Gate(GateName name){
        gateName=name;
    }
}
