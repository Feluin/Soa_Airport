package airport;

import airport.aircraft.Aircraft;

import java.util.*;

public class Airport
{
    private String name;
    private List<Gate.GateNames> gates=new ArrayList<>(Arrays.asList(Gate.GateNames.values()));
    private Map<Gate, Aircraft> gateairportmap=new HashMap<>();

}
