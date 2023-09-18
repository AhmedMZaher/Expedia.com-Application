package Controller;

import Model.Flight;
import Model.FlightSpec;
import Model.ShoppingCart;
import Utils.Date;
import Utils.Printer;
import Utils.Validator;
import View.FlightDetailsView;
import View.SearchForFlightView;

import java.util.List;

public class BookFlightController {
    public static void addFlight() {
        FlightSpec flightSpec = SearchForFlightView.getFlightSpec();
        List<Flight> flights = FlightApiController.getInstance().searchFlight(flightSpec);
        FlightDetailsView.displayFlightsDetails(flights);
        int choice = Printer.getInputInRange(1, flights.size());
        if(choice == -1){
            SearchForFlightView.displayErrorMessage("Wrong input please try again");
        }
        System.out.println("TEST:  " + choice);
        Flight flight = flights.get(choice - 1);
        ShoppingCart.getINSTANCE().addItemToCart(flight);
        SearchForFlightView.displaySuccessMessage();
    }
}
