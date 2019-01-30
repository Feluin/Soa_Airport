package airport.airport.locations;

import java.util.ArrayList;
import java.util.List;

public class LocationManager
{
    private List<Location> allLocations=new ArrayList<>();
    private List<Gate> allgates=new ArrayList<>();
    private List<Point> allpoints=new ArrayList<>();

    public LocationManager(){

        for (Gate.GateName gateName:
        Gate.GateName.values())
        {
            Gate gate=new Gate(gateName);
            allLocations.add(gate);

            allgates.add(gate);
        }
        for(Point.AllPoints pointsname:Point.AllPoints.values()){
            Point point=new Point(pointsname);
            allLocations.add(point);

            allpoints.add(point);
        }
    }

    public List<Gate> getAllgates()
    {
        return allgates;
    }

    public List<Location> getAllLocations()
    {
        return allLocations;
    }

    public List<Point> getAllpoints()
    {
        return allpoints;
    }
}
