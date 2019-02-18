package airport.airport;

import airport.aircraft.Aircraft;
import airport.airport.locations.Gate;
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

    private Map<Gate, Aircraft> gateairportmap = new HashMap<>();
    private List<Aircraft> aiplaneList = new ArrayList<>();
    private Tower tower;
    private ApronControl apronControl;

    public Airport(String name)
    {
        this.name = name;
        this.tower = new Tower("BER Tower");
        this.apronControl = new ApronControl("BER ApronControl",manager);

        createLocations();
    }

    public LocationManager getLocationmanager()
    {
        return manager;
    }

    private void createLocations()
    {

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
