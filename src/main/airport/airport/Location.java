package airport.airport;

import java.util.ArrayList;
import java.util.List;

public class Location {
     public  List<Location> possiblelocations=new ArrayList<>();

    public void addPossibleLocations(List<Location> junktionlist) {
        possiblelocations.addAll(junktionlist);
    }

    public enum Locations {
        M1, O1, N1, L1,
        M2, O2, N2, L2,
        M3, O3, N3, L3,
        M4, O4, N4, L4,
        M5, O5, N5, L5,
        M6, O6, N6, L6,
        S1, S2, S3, S4,
    }

}
