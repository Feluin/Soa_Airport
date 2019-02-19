package airport.airport.locations;

import airport.airport.locations.Gate.GateName;
import airport.airport.locations.Point.PointName;

import java.util.ArrayList;
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
        final ControlPoint controlPoint1 =
            new ControlPoint(ControlPoint.ControlPointNames.S1, new Point[]{getPoint(Point.PointName.O1), getPoint(Point.PointName.N1)},
                RunwayDirection.R26);
        controlpoints.put(ControlPoint.ControlPointNames.S1, controlPoint1);

        allLocations.put(ControlPoint.ControlPointNames.S1.name(), controlPoint1);

        final ControlPoint controlPoint2 =
            new ControlPoint(ControlPoint.ControlPointNames.S2, new Point[]{getPoint(Point.PointName.L1), getPoint(Point.PointName.M1)},
                RunwayDirection.L08);
        controlpoints.put(ControlPoint.ControlPointNames.S2, controlPoint2);
        allLocations.put(ControlPoint.ControlPointNames.S2.name(), controlPoint2);

        final ControlPoint controlPoint3 =
            new ControlPoint(ControlPoint.ControlPointNames.S3, new Point[]{getPoint(Point.PointName.O6), getPoint(PointName.N6)},
                RunwayDirection.L26);
        controlpoints.put(ControlPoint.ControlPointNames.S3, controlPoint3);
        allLocations.put(ControlPoint.ControlPointNames.S3.name(), controlPoint3);

        final ControlPoint controlPoint4 = new ControlPoint(ControlPoint.ControlPointNames.S4, new Point[]{getPoint(
            PointName.L6), getPoint(PointName.M6)}, RunwayDirection.R08);
        controlpoints.put(ControlPoint.ControlPointNames.S4, controlPoint4);
        allLocations.put(ControlPoint.ControlPointNames.S4.name(), controlPoint4);

        createJunktion("S1", "O2", "N2");
        createJunktion("A01", "O1", "O2");
        createJunktion("A01", "N1", "N2");
        createJunktion("A02", "O2", "O3");
        createJunktion("A02", "N2", "N3");
        createJunktion("A03", "O3", "O4");
        createJunktion("A03", "N3", "N4");
        createJunktion("A04", "O4", "O5");
        createJunktion("A04", "N4", "N5");
        createJunktion("A05", "O5", "O6");
        createJunktion("A05", "N5", "N6");
        createJunktion("S3", "O5", "N5");

        createJunktion("S3", "M2", "L2");
        createJunktion("B01", "M1", "M2");
        createJunktion("B01", "L1", "L2");
        createJunktion("B02", "M2", "M3");
        createJunktion("B02", "L2", "L3");
        createJunktion("B03", "M3", "M4");
        createJunktion("B03", "L3", "L4");
        createJunktion("B04", "M4", "M5");
        createJunktion("B04", "L4", "L5");
        createJunktion("B05", "M5", "M6");
        createJunktion("B05", "L5", "L6");
        createJunktion("S4", "M5", "L5");

        createJunktion("O2", "M1", "X1");
        createJunktion("N2", "M1", "X2");
        createJunktion("O2", "L1", "X3");
        createJunktion("N2", "L1", "X4");
        createJunktion("L2", "N1", "X5");
        createJunktion("M2", "O1", "X7");
        createJunktion("M2", "N1", "X8");
        createJunktion("O5", "M6", "X9");
        createJunktion("N5", "M6", "X10");
        createJunktion("O5", "L6", "X11");
        createJunktion("N5", "L6", "X12");
        createJunktion("L5", "O6", "X13");
        createJunktion("L5", "N6", "X14");
        createJunktion("M5", "O6", "X15");
        createJunktion("M5", "N6");
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

    public void createJunktion(String... locationnames)
    {
        ArrayList<Location> locations = new ArrayList<>();
        for (String l : locationnames)
        {
            locations.add(getLocationByString(l));
        }
        Location.createJunktion(locations);
    }
}
