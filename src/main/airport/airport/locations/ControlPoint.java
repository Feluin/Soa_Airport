package airport.airport.locations;

import airport.aircraft.Aircraft;

import java.util.Arrays;

public class ControlPoint extends Location
{
    private ControlPointNames name;
    private Point[] includePoints;

    public ControlPoint(ControlPointNames name,final Point[] includePoints)
    {
        this.name = name;
        this.includePoints = includePoints;
        for (Point point : includePoints
        )
        {
            point.setControlpoint(this);
            point.addPossibleLocations(Arrays.asList(includePoints));
        }
    }

    @Override
    public void setAircraft(Aircraft aircraft)
    {
        if (aircraft != null)
        {
            for (Point point : includePoints)
            {
                if (point.getAircraft() != null)
                {
                    point.setAircraft(aircraft);
                    break;
                }
            }
        }
    }

    @Override
    public void removeAircraft(Aircraft aircraft)
    {
        if (aircraft != null)
        {
            for (Point point : includePoints)
            {
                if (aircraft.equals(point.getAircraft()))
                {
                    point.removeAircraft(aircraft);
                    break;
                }
            }
        }
    }

    @Override
    public Aircraft getAircraft()
    {
        for (Point point : includePoints)
        {
            if (point.getAircraft() != null)
            {
                return point.getAircraft();
            }
        }
        return null;
    }

    public enum ControlPointNames
    {
        S1,
        S2,
        S3,
        S4,
    }
}