package Model;

import Controller.FlightApiController;
import Utils.Date;

import java.util.*;

// The whole class just for test
public class TestFlightAPIAdapter implements FlightAPI{
    private static final TestFlightAPIAdapter INSTANCE = new TestFlightAPIAdapter();

    public static TestFlightAPIAdapter getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Flight> searchFlight(FlightSpec flightSpec) {
        List<Flight> flights = new ArrayList<>();
        // -----------------------------------------------------
        FlightSpec f1 = new FlightSpec(new Date("2023-09-15"), new Date("2023-09-18"), "Cairo", "USA");
        flights.add(new Flight(f1, "Cairo Airport", "F17", 165));
        // -----------------------------------------------------
        FlightSpec f2 = new FlightSpec(new Date("2023-03-06"), new Date("2023-03-18"), "London", "Paris");
        flights.add(new Flight(f2, "LA Airport", "F22", 320));
        // -----------------------------------------------------
        return flights;
    }

    @Override
    public boolean bookFlight(User user, Flight flight) {
        return false;
    }

}
