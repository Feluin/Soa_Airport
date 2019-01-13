package airport;

import java.util.*;

public class Airport
{
    private String name;
    List<Gate.GateNames> gates=new ArrayList<>(Arrays.asList(Gate.GateNames.values()));
    Map<Gate,Aircraft> gateairportmap=new HashMap<>();
}
