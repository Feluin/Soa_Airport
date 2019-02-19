package airport.airport.locations;

import airport.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Location {

    private Set<Location> possiblelocations = new HashSet<>();

    Aircraft currentAircraft;

    void addPossibleLocations(List<Location> junktionlist) {
        possiblelocations.addAll(junktionlist);
    }

    public Set<Location> getPossiblelocations() {
        return possiblelocations;
    }

    static void createJunktion(ArrayList<Location> locations) {
        locations.forEach(location -> location.addPossibleLocations(locations));
    }

    public Aircraft getAircraft() {
        return currentAircraft;
    }

    public boolean isPossibleLocation(Location location) {
        return possiblelocations.contains(location);
    }

    public Aircraft getCurrentAircraft() {
        return currentAircraft;
    }

    public void setAircraft(final Aircraft aircraft) {
        currentAircraft = aircraft;
    }

    public void removeAircraft(final Aircraft aircraft) {
        if (currentAircraft.equals(aircraft)) {
            currentAircraft = null;
        } else {
            //TODO da war was falsch
        }
    }
}
