package airport;

import airport.aircraft.Aircraft;

import java.util.*;

public class Airport
{
    private String name;
    private List<Gate.GateNames> gates=new ArrayList<>(Arrays.asList(Gate.GateNames.values()));
    private Map<Gate, Aircraft> gateAirportMap=new HashMap<>();

    public Airport(String name) {
        this.name = name;
    }

    public List<Gate.GateNames> getGates() {
        return gates;
    }

    public Map<Gate, Aircraft> getGateAirportMap() {
        return gateAirportMap;
    }

}
