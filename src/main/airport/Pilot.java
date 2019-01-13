package airport;

public class Pilot extends Crew{
    private int flightExperienceInMiles;

    public Pilot(Employee employee, int flightExperienceInMiles) {
        super(employee);
        this.flightExperienceInMiles = flightExperienceInMiles;
    }
}
