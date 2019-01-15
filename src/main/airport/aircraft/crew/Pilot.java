package airport.aircraft.crew;

import airport.aircraft.crew.Crew;
import airport.aircraft.crew.Employee;

public class Pilot extends Crew {
    private int flightExperienceInMiles;

    public Pilot(Employee employee, int flightExperienceInMiles) {
        super(employee);
        this.flightExperienceInMiles = flightExperienceInMiles;
    }
}
