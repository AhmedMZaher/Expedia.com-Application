package Controller;

import Model.Hotel;
import Model.HotelSpec;
import Model.ShoppingCart;
import Utils.Printer;
import View.HotelDetailsView;
import View.SearchForHotelView;

import java.util.List;

public class BookHotelController {
    public static void addHotel(){
        HotelSpec hotelSpec = SearchForHotelView.getHotelSpec();
        List<Hotel> hotels = HotelApiController.getInstance().searchHotel(hotelSpec);
        HotelDetailsView.displayHotelsDetails(hotels);
        int choice = Printer.getInputInRange(1, hotels.size());
        if(choice == -1){
            Printer.displayErrorMessage();
        }
        Hotel hotel = hotels.get(choice - 1);
        ShoppingCart.getINSTANCE().addItemToCart(hotel);
        SearchForHotelView.displaySuccessMessage();
    }
}
