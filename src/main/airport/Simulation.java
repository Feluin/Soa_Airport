package airport;

import airport.aircraft.Aircraft;
import airport.airport.Airport;
import airport.airport.locations.Gate;
import airport.airport.locations.Location;
import airport.airport.locations.LocationManager;
import airport.airport.locations.RunwayDirection;
import airport.database.FlightRecorder;

import javax.tools.DocumentationTool;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulation {


    private Aircraft aircraft1 = new Aircraft();
    private Aircraft aircraft2 = new Aircraft();
    private Aircraft aircraft3 = new Aircraft();
    private Aircraft aircraft4 = new Aircraft();
    private Aircraft aircraft5 = new Aircraft();
    private Aircraft aircraft6 = new Aircraft();
    private Aircraft aircraft7 = new Aircraft();
    private Aircraft aircraft8 = new Aircraft();
    private Aircraft aircraft9 = new Aircraft();
    private Aircraft aircraft10 = new Aircraft();
    private Aircraft aircraft11 = new Aircraft();
    private Aircraft aircraft12 = new Aircraft();
    private Aircraft aircraft13 = new Aircraft();
    private Aircraft aircraft14 = new Aircraft();
    private Aircraft aircraft15 = new Aircraft();
    private Aircraft aircraft16 = new Aircraft();
    private Aircraft aircraft17 = new Aircraft();
    private Aircraft aircraft18 = new Aircraft();
    private Aircraft aircraft19 = new Aircraft();
    private Aircraft aircraft20 = new Aircraft();

    private Airport airport = new Airport("BER");

    public void startSimulation() {
        build(aircraft1, aircraft2, aircraft3, aircraft4, aircraft5, aircraft6, aircraft7, aircraft8, aircraft9, aircraft10);
        build(aircraft11, aircraft12, aircraft13, aircraft14, aircraft15, aircraft16, aircraft17, aircraft18, aircraft19, aircraft20);

       // airport.getGateAirportMap().put(Gate.GateName.A01, aircraft1);
       // airport.getGateAirportMap().put(Gate.GateName.A02, aircraft2);
       // airport.getGateAirportMap().put(Gate.GateName.A03, aircraft3);
        //airport.getGateAirportMap().put(Gate.GateName.A04, aircraft4);
        //airport.getGateAirportMap().put(Gate.GateName.A05, aircraft5);
       // airport.getGateAirportMap().put(Gate.GateName.B01, aircraft6);
       // airport.getGateAirportMap().put(Gate.GateName.B02, aircraft7);
       // airport.getGateAirportMap().put(Gate.GateName.B03, aircraft8);
       // airport.getGateAirportMap().put(Gate.GateName.B04, aircraft9);
       // airport.getGateAirportMap().put(Gate.GateName.B05, aircraft10);

        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();
        LocationManager locationManager=airport.getLocationmanager();
        locationManager.getLocationByString("S04");

        //airport.getTower().runwayclearedtoLand(aircraft11, locationManager.getRunwayDirection(RunwayDirection));
        airport.getApronControl().taxi("F01","E01", Arrays.asList("",""),"X04");
        airport.getTower().holdshort(aircraft11, ); ;
        airport.getTower().holdshort(aircraft1, );
        airport.getTower().runwayClearedToTakeoff(aircraft1, );

        airport.getTower().runwayclearedtoLand(aircraft12, );
        airport.getTower().holdshort(aircraft12, );
        airport.getApronControl().taxi(aircraft2, );
        airport.getTower().holdshort(aircraft2, );
        airport.getApronControl().taxi(aircraft12, );
        airport.getTower().runwayClearedToTakeoff(aircraft2, );




        FlightRecorder.instance.shutdown();
    }

    private void build(Aircraft aircraft1, Aircraft aircraft2, Aircraft aircraft3, Aircraft aircraft4, Aircraft aircraft5, Aircraft aircraft6, Aircraft aircraft7, Aircraft aircraft8, Aircraft aircraft9, Aircraft aircraft10) {
        aircraft1.build();
        aircraft2.build();
        aircraft3.build();
        aircraft4.build();
        aircraft5.build();
        aircraft6.build();
        aircraft7.build();
        aircraft8.build();
        aircraft9.build();
        aircraft10.build();
    }

}
