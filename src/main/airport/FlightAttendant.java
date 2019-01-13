package airport;

public class FlightAttendant extends Crew{
    private boolean isPurser;

    public FlightAttendant(Employee employee, boolean isPurser) {
        super(employee);
        this.isPurser = isPurser;
    }
}
