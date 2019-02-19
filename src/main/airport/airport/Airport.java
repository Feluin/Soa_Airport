package airport.airport;

import airport.aircraft.Aircraft;
import airport.airport.locations.Gate;
import airport.airport.locations.Location;
import airport.airport.locations.LocationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airport
{
    private String name;
    private LocationManager manager = new LocationManager();

    public static Airport instance=new Airport("BER");
    private Map<String,Aircraft> aircraftHashMap =new HashMap<>();
    private Tower tower;
    private ApronControl apronControl;

    private Airport(String name)
    {
        this.name = name;
        this.tower = new Tower("BER Tower");
        this.apronControl = new ApronControl("BER ApronControl",this);

    }

    public void registerAircraft(Aircraft.AirCraftName name, Location location){
        Aircraft aircraft= new Aircraft(name,location);
        aircraftHashMap.put(name.name(),aircraft);
        if(location==null){
            tower.addSubscriber(aircraft);
        }else {
            apronControl.addSubscriber(aircraft);
        }

    }
    public Aircraft getAircaft(String s){
         return aircraftHashMap.get(s);
    }

    public LocationManager getLocationmanager()
    {
        return manager;
    }

    public Tower getTower()
    {
        return tower;
    }

    public ApronControl getApronControl()
    {
        return apronControl;
    }
}
