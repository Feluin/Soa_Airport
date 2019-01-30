package airport.airport;

import airport.aircraft.Aircraft;
import airport.airport.locations.Gate;

import java.util.*;

public class Airport
{
    private String name;
    private List<Gate.GateName> gates=new ArrayList<>(Arrays.asList(Gate.GateName.values()));
    private Map<Gate.GateName, Aircraft> gateAirportMap=new HashMap<>();


    public List<Gate.GateName> getGates() {
        return gates;
    }

    public Map<Gate.GateName, Aircraft> getGateAirportMap() {
        return gateAirportMap;
    }

    private Map<Gate, Aircraft> gateairportmap = new HashMap<>();
    private List<Aircraft> aiplaneList = new ArrayList<>();
    private Tower tower;
    private ApronControl apronControl;

    public Airport(String name)
    {
        this.name = name;
        this.tower = new Tower("BER Tower");
        this.apronControl = new ApronControl("BER ApronControl");

        createLocations();
    }

    private void createLocations() {

    }

    public Tower getTower() {
        return tower;
    }

    public ApronControl getApronControl() {
        return apronControl;
    }
}
