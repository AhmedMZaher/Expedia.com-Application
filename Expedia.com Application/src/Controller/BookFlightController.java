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
        FlightDetailsView.displayFlightsDetails(flights);
        int choice = SearchForFlightView.getInputInRange(1, flights.size());
        if(choice == -1){
            SearchForFlightView.displayErrorMessage("Wrong input please try again");
        }

        SearchForFlightView.displaySuccessMessage();
    }
}
