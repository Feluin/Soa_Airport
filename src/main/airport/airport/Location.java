package airport.airport;

import java.util.ArrayList;
import java.util.List;

public abstract class Location
{
    private List<Location> possiblelocations=new ArrayList<>();

    public void addPossibleLocations(List<Location> junktionlist) {
        possiblelocations.addAll(junktionlist);
    }

    public List<Location> getPossiblelocations()
    {
        return possiblelocations;
    }
}
