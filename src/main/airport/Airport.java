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

    private Map<Gate, Aircraft> gateairportmap = new HashMap<>();
    private List<Aircraft> aiplaneList = new ArrayList<>();
    private Airport airport = new Airport();
    private Tower tower;
    private ApronControl apronControl;

    private Airport()
    {
        tower = new Tower("BER Tower");
        this.apronControl = new ApronControl("BER ApronControl");
    }

    public Airport getInstance()
    {
        return airport;
    }
}
