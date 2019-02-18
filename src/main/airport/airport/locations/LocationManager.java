package airport.airport.locations;

import airport.airport.locations.Gate.GateName;
import airport.airport.locations.Point.PointName;

import java.util.HashMap;
import java.util.Map;

public class LocationManager
{
    private Map<String, Location> allLocations = new HashMap<>();
    private Map<GateName, Gate> allgates = new HashMap<>();
    private Map<Point.PointName, Point> allpoints = new HashMap<>();
    private Map<ControlPoint.ControlPointNames, ControlPoint> controlpoints = new HashMap<>();

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
        final ControlPoint controlPoint1 = controlpoints.put(ControlPoint.ControlPointNames.S1,
            new ControlPoint(ControlPoint.ControlPointNames.S1, new Point[]{getPoint(Point.PointName.O1), getPoint(Point.PointName.N1)}));
        allLocations.put(ControlPoint.ControlPointNames.S1.name(), controlPoint1);
        final ControlPoint controlPoint2 = controlpoints.put(ControlPoint.ControlPointNames.S2,
            new ControlPoint(ControlPoint.ControlPointNames.S2, new Point[]{getPoint(Point.PointName.L1), getPoint(Point.PointName.M1)}));
        allLocations.put(ControlPoint.ControlPointNames.S2.name(), controlPoint2);
        final ControlPoint controlPoint3 = controlpoints.put(ControlPoint.ControlPointNames.S3,
            new ControlPoint(ControlPoint.ControlPointNames.S3, new Point[]{getPoint(Point.PointName.O6), getPoint(PointName.N6)}));
        allLocations.put(ControlPoint.ControlPointNames.S3.name(), controlPoint3);
        final ControlPoint controlPoint4 = controlpoints.put(ControlPoint.ControlPointNames.S4,
            new ControlPoint(ControlPoint.ControlPointNames.S4, new Point[]{getPoint(Point.PointName.L6), getPoint(PointName.M6)}));
        allLocations.put(ControlPoint.ControlPointNames.S4.name(), controlPoint4);
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
        Location.createJunktion(getLocationByString("S1"),getLocationByString("O2"),getLocationByString("N2"));
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

    public Point getPoint(Point.PointName pointName)
    {
        return allpoints.get(pointName);
    }

    public ControlPoint getControlpoint(ControlPoint.ControlPointNames name)
    {
        return controlpoints.get(name);
    }

    public Gate getGate(Gate.GateName gateName)
    {
        return allgates.get(gateName);
    }
}
