package airport;

import airport.aircraft.Aircraft;
import airport.airport.Airport;
import airport.airport.locations.LocationManager;
import airport.airport.locations.RunwayDirection;
import airport.database.FlightRecorder;

import java.util.Arrays;
import java.util.Collections;

import static airport.aircraft.Aircraft.AirCraftName.valueOf;

public class Simulation {



    private Airport airport = Airport.instance;

    public void startSimulation() {
       initAircrafts();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
        LocationManager locationManager=airport.getLocationmanager();
        locationManager.getLocationByString("S4");

        this.firstSimulation();
        this.secondSimulation();
        this.thirdSimulation();
        this.fourthSimulation();
        this.fifthSimulation();
        this.sixthSimulation();
        this.seventhSimulation();
        this.eighthSimulation();
        this.ninthSimulation();
        this.tenthSimulation();

        FlightRecorder.instance.shutdown();
    }

    private void initAircrafts() {
        airport.registerAircraft(valueOf("F01"),airport.getLocationmanager().getLocationByString("A01"));
        airport.registerAircraft(valueOf("F02"),airport.getLocationmanager().getLocationByString("A02"));
        airport.registerAircraft(valueOf("F03"),airport.getLocationmanager().getLocationByString("A03"));
        airport.registerAircraft(valueOf("F04"),airport.getLocationmanager().getLocationByString("A04"));
        airport.registerAircraft(valueOf("F05"),airport.getLocationmanager().getLocationByString("A05"));
        airport.registerAircraft(valueOf("F06"),airport.getLocationmanager().getLocationByString("B01"));
        airport.registerAircraft(valueOf("F07"),airport.getLocationmanager().getLocationByString("B02"));
        airport.registerAircraft(valueOf("F08"),airport.getLocationmanager().getLocationByString("B03"));
        airport.registerAircraft(valueOf("F09"),airport.getLocationmanager().getLocationByString("B04"));
        airport.registerAircraft(valueOf("F10"),airport.getLocationmanager().getLocationByString("B05"));
        airport.registerAircraft(valueOf("F11"),null);
        airport.registerAircraft(valueOf("F12"),null);
        airport.registerAircraft(valueOf("F13"),null);
        airport.registerAircraft(valueOf("F14"),null);
        airport.registerAircraft(valueOf("F15"),null);
        airport.registerAircraft(valueOf("F16"),null);
        airport.registerAircraft(valueOf("F17"),null);
        airport.registerAircraft(valueOf("F18"),null);
        airport.registerAircraft(valueOf("F19"),null);
        airport.registerAircraft(valueOf("F20"),null);
    }



    private void firstSimulation() {
        this.airport.getTower().runwayclearedtoLand("F11", "L08");
        this.airport.getApronControl().holdshort("F11", "S1");
        this.airport.getApronControl().taxi("F01", "A01", Arrays.asList("O2","O3", "O4", "O5", "X9"), "S4");
        this.airport.getApronControl().holdshort("F01", "S4");
        this.airport.getApronControl().taxi("F11", "O1", Collections.emptyList(), "A01");
        this.airport.getTower().runwayClearedToTakeoff("F01", "R08");
    }

    private void secondSimulation() {
        this.airport.getTower().runwayclearedtoLand("F12", "R08");
        this.airport.getApronControl().holdshort("F12", "S3");
        this.airport.getApronControl().taxi("F02", "A02", Arrays.asList("O2","O3"), "S1");
        this.airport.getApronControl().holdshort("F02", "S1");
        this.airport.getApronControl().taxi("F12", "O6", Arrays.asList("O5", "O4", "O3"), "A02");
        this.airport.getTower().runwayClearedToTakeoff("F01", "R26");
    }

    private void thirdSimulation() {
        this.airport.getTower().runwayclearedtoLand("F13", "R26");
        this.airport.getApronControl().holdshort("F13", "S2");
        this.airport.getApronControl().taxi("F03", "A03", Arrays.asList("N4","N5"), "N6");
        this.airport.getApronControl().holdshort("F03", "S3");
        this.airport.getApronControl().taxi("F13", "M1", Arrays.asList("X8", "N1", "N2", "N3", "N4"), "A03");
        this.airport.getTower().runwayClearedToTakeoff("F03", "L26");
    }

    private void fourthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F14", "R08");
        this.airport.getApronControl().holdshort("F14", "S3");
        this.airport.getApronControl().taxi("F04", "A04", Arrays.asList("O5","O4", "O3", "O2"), "O1");
        this.airport.getApronControl().holdshort("F04", "S1");
        this.airport.getApronControl().taxi("F14", "N8", Arrays.asList("N5", "N4"), "A04");
        this.airport.getTower().runwayClearedToTakeoff("F04", "R26");
    }

    private void fifthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F15", "L08");
        this.airport.getApronControl().holdshort("F15", "S1");
        this.airport.getApronControl().taxi("F05", "A05", Arrays.asList("O5"), "O6");
        this.airport.getApronControl().holdshort("F05", "S3");
        this.airport.getApronControl().taxi("F15", "O1", Arrays.asList("O2", "O3", "O4", "O5"), "A05");
        this.airport.getTower().runwayClearedToTakeoff("F05", "L26");
    }

    private void sixthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F16", "L26");
        this.airport.getApronControl().holdshort("F16", "S4");
        this.airport.getApronControl().taxi("F06", "B01", Arrays.asList("L2"), "L1");
        this.airport.getApronControl().holdshort("F06", "S2");
        this.airport.getApronControl().taxi("F16", "M6", Arrays.asList("M5", "M4", "M3", "M2"), "B01");
        this.airport.getTower().runwayClearedToTakeoff("F06", "L08");
    }

    private void seventhSimulation() {
        this.airport.getTower().runwayclearedtoLand("F17", "R26");
        this.airport.getApronControl().holdshort("F17", "S2");
        this.airport.getApronControl().taxi("F07", "B02", Arrays.asList("L2","L3", "L4", "L5"), "L6");
        this.airport.getApronControl().holdshort("F07", "S4");
        this.airport.getApronControl().taxi("F17", "M1", Collections.emptyList(), "B02");
        this.airport.getTower().runwayClearedToTakeoff("F07", "R08");
    }

    private void eighthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F18", "L26");
        this.airport.getApronControl().holdshort("F18", "S4");
        this.airport.getApronControl().taxi("F08", "B03", Arrays.asList("L3","L2"), "L1");
        this.airport.getApronControl().holdshort("F08", "S2");
        this.airport.getApronControl().taxi("F18", "M6", Arrays.asList("M5", "M4"), "B03");
        this.airport.getTower().runwayClearedToTakeoff("F08", "L08");
    }

    private void ninthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F19", "R26");
        this.airport.getApronControl().holdshort("F19", "S2");
        this.airport.getApronControl().taxi("F09", "B04", Arrays.asList("M5"), "M6");
        this.airport.getApronControl().holdshort("F09", "S4");
        this.airport.getApronControl().taxi("F19", "L1", Arrays.asList("L2", "L3", "L4", "L5"), "B04");
        this.airport.getTower().runwayClearedToTakeoff("F09", "R08");
    }

    private void tenthSimulation() {
        this.airport.getTower().runwayclearedtoLand("F20", "L26");
        this.airport.getApronControl().holdshort("F20", "S4");
        this.airport.getApronControl().taxi("F10", "B05", Arrays.asList("L5","L4", "L3", "L2"), "L1");
        this.airport.getApronControl().holdshort("F10", "S2");
        this.airport.getApronControl().taxi("F20", "M6", Collections.emptyList(), "B04");
        this.airport.getTower().runwayClearedToTakeoff("F20", "L08");
    }


}
