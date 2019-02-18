package airport.airport.locations;

import airport.airport.locations.Gate.GateName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocationManager
{
    private Map<String, Location> allLocations = new HashMap<>();
    private Map<GateName, Gate> allgates = new HashMap<>();
    private Map<Point.PointName, Point> allpoints = new HashMap<>();
    private Map<ControlPoint.ControlPointNames,ControlPoint> controlpoints=new HashMap<>();

    public LocationManager()
    {

        for (GateName gateName :
            GateName.values())
        {
            Gate gate = new Gate(gateName);
            allLocations.put(gateName.name(), gate);

            allgates.put(gateName, gate);
        }
        for (Point.PointName pointsname : Point.PointName.values())
        {
            Point point = new Point(pointsname);
            allLocations.put(pointsname.name(), point);

            allpoints.put(pointsname, point);
        }

        Location.createJunktion(allLocations.get(GateName.A01),allLocations.get(GateName.A02));
    }

    public Map<GateName, Gate> getAllgates()
    {
        return allgates;
    }

    public Map<String, Location> getAllLocations()
    {
        return allLocations;
    }

    public Map<Point.PointName, Point> getAllpoints()
    {
        return allpoints;
    }

    public Location getLocationByString(final String locationname)
    {
        return allLocations.get(locationname);
    }
    public Point getPoint(Point.PointName pointName){
        return allpoints.get(pointName);
    }
    public ControlPoint getControlpoint(ControlPoint.ControlPointNames name){
        return controlpoints.get(name);
    }
    public Gate getGate(Gate.GateName gateName){
        return allgates.get(gateName);
    }
}
