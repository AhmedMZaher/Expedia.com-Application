package Controller;

import Utils.Printer;
import Utils.Validator;
import View.AddItineraryView;
import View.CheckoutView;

public class AddItineraryController {
    public static void run(int userID) {
        int choice;
        do {
            AddItineraryView.run();
            choice = Printer.getInputInRange(1, 4);
            if (choice == 1)
                BookFlightController.addFlight();
            else if (choice == 2)
                BookHotelController.addHotel();
            else if (choice == 3)
                CheckoutController.checkout(userID);
        } while (choice != 4);


    }
}
