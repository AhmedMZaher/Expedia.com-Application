package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class FlightApiController implements FlightAPI {
    private static final FlightApiController INSTANCE = new FlightApiController();

    List<FlightAPI> flightAPIS;

    public FlightApiController() {
        this.flightAPIS = new ArrayList<>();
        // For testing
        flightAPIS.add(TestFlightAPIAdapter.getInstance());
    }

    public static FlightApiController getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Flight> searchFlight(FlightSpec flightSpec) {
        List<Flight> flights = new ArrayList<>();
        for(FlightAPI api : flightAPIS)
            flights.addAll(api.searchFlight(flightSpec));
        return flights;
    }

    @Override
    public boolean bookFlight(User user, Flight flight) {
        for (FlightAPI api : flightAPIS){
            if(api.bookFlight(user, flight)){
                return true;
            }
        }
        return false;
    }
}
