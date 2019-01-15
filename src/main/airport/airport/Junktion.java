package airport.airport;

import java.util.List;

public class Junktion
{
 public Junktion(List<Location> locationList){
     locationList.forEach(location -> location.addPossibleLocations());
 }
}
