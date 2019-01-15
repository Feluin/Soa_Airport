package airport;

import airport.aircraft.Aircraft;

public class main {
    public static void main(String... args) {
        Aircraft aircraft = new Aircraft();
        aircraft.build();
        Airport airport = new Airport("BER");
        for(int i = 0; i<airport.getGates().size(); i++) {
            System.out.println(airport.getGates().get(i).toString());
        }


    }
}
