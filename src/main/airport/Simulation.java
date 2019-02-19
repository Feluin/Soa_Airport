package airport;

import airport.aircraft.Aircraft;
import airport.airport.Airport;
import airport.airport.locations.LocationManager;
import airport.airport.locations.RunwayDirection;
import airport.database.FlightRecorder;

import java.util.Arrays;

import static airport.aircraft.Aircraft.AirCraftName.valueOf;

public class Simulation {



    private Airport airport = Airport.instance;

    public void startSimulation() {
       initAircrafts();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
        LocationManager locationManager=airport.getLocationmanager();
        locationManager.getLocationByString("S4");

        airport.getTower().runwayclearedtoLand("F01", "O8L");
        airport.getTower().holdshort("F11", "S1");
        airport.getApronControl().taxi("F01","O2", Arrays.asList("O3","O4", "O5", "X9"),"S04");
        airport.getTower().holdshort("F01", "S4" );
        airport.getApronControl().taxi("F11", "01", null, "A01");
        airport.getTower().runwayClearedToTakeoff("F01", "O8R" );
//
//        airport.getTower().runwayclearedtoLand(aircraft12, );
//        airport.getTower().holdshort(aircraft12, );
//        airport.getApronControl().taxi(aircraft2, );
//        airport.getTower().holdshort(aircraft2, );
//        airport.getApronControl().taxi(aircraft12, );
//        airport.getTower().runwayClearedToTakeoff(aircraft2, );




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

}
