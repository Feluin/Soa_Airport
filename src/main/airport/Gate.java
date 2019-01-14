package airport;

import airport.aircraft.Aircraft;

public class Gate {
    private boolean isOpen;

    private Aircraft aircraft;

    public enum GateNames {
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
