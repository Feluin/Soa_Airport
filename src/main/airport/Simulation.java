package airport;

import airport.aircraft.Aircraft;
import airport.airport.Airport;
import airport.airport.locations.LocationManager;
import airport.database.FlightRecorder;

import java.util.Arrays;

public class Simulation {



    private Airport airport = new Airport("BER");

    public void startSimulation() {
       initAircrafts();
        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
        LocationManager locationManager=airport.getLocationmanager();
        locationManager.getLocationByString("S4");

        //airport.getTower().runwayclearedtoLand(aircraft11, locationManager.getRunwayDirection(RunwayDirection));
        airport.getApronControl().taxi("F01","E01", Arrays.asList("",""),"X04");
//        airport.getTower().holdshort(aircraft11, ); ;
//        airport.getTower().holdshort(aircraft1, );
//        airport.getTower().runwayClearedToTakeoff(aircraft1, );
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
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F01"),airport.getLocationmanager().getLocationByString("A01"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F02"),airport.getLocationmanager().getLocationByString("A02"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F03"),airport.getLocationmanager().getLocationByString("A03"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F04"),airport.getLocationmanager().getLocationByString("A04"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F05"),airport.getLocationmanager().getLocationByString("A05"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F06"),airport.getLocationmanager().getLocationByString("B01"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F07"),airport.getLocationmanager().getLocationByString("B02"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F08"),airport.getLocationmanager().getLocationByString("B03"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F09"),airport.getLocationmanager().getLocationByString("B04"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F10"),airport.getLocationmanager().getLocationByString("B05"));
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F11"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F12"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F13"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F14"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F15"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F16"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F17"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F18"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F19"),null);
        airport.registerAircraft(Aircraft.AirCraftName.valueOf("F20"),null);
    }

}
