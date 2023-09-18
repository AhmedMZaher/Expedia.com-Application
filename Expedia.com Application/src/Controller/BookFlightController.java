package Controller;

import Model.Flight;
import Model.FlightSpec;
import Utils.Date;
import View.FlightDetailsView;
import View.SearchForFlightView;

import java.util.List;

public class BookFlightController {
    public static void addFlight() {
        FlightSpec flightSpec = SearchForFlightView.getFlightSpec();
        List<Flight> flights = FlightApiController.getInstance().searchFlight(flightSpec);
        for(Flight flight : flights)
            FlightDetailsView.displayFlightDetails(flight);
    }
}
