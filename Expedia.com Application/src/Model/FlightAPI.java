package Model;

import Utils.Date;

import java.util.List;

public interface FlightAPI {
    List<Flight> searchFlight(FlightSpec flightSpec);
    boolean bookFlight(User user, Flight flight);
}
