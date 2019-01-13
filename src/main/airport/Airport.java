package airport;

import java.util.*;

public class Airport
{
    private String name;
    List<Gate.GateNames> gates=new ArrayList<>(Arrays.asList(Gate.GateNames.values()));
    Map<Gate,Aircraft> gateairportmap=new HashMap<>();
    List<Aircraft> aircrafts=new ArrayList<>();
    private static Airport airport=new Airport();
    private Tower tower;
    private ApronControl apronControl;

    private Airport(){
        tower=new Tower();
        apronControl= new ApronControl();
    }

    public static Airport getInstance() {
        return airport;
    }

}
