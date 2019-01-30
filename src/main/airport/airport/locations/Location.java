package airport.airport.locations;

import airport.aircraft.Aircraft;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Location
{
    private Set<Location> possiblelocations = new HashSet<>();

    protected Aircraft currentAircraft;

    public void addPossibleLocations(List<Location> junktionlist)
    {
        possiblelocations.addAll(junktionlist);
    }

    public Set<Location> getPossiblelocations()
    {
        return possiblelocations;
    }

    public static void createJunktion(List<Location> locations)
    {
        locations.forEach(location -> location.addPossibleLocations(locations));
    }

    public Aircraft getAircraft()
    {
        return currentAircraft;
    }

    public boolean moveAircraftToLocation(Location location)
    {
        if (possiblelocations.contains(location))
        {
            location.currentAircraft = this.currentAircraft;
            return true;
        }
        return false;
    }
}
