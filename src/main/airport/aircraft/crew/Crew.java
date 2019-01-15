package airport.aircraft.crew;

import airport.aircraft.crew.Employee;

public abstract class Crew {
    private Employee employee;

    public Crew(Employee employee) {
        this.employee = employee;
    }
}
