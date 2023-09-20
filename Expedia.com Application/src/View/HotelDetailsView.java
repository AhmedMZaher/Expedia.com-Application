package View;

import Model.Flight;
import Model.Hotel;
import Utils.Date;

import java.util.List;

public class HotelDetailsView {
    public static void displayHotelsDetails(List<Hotel> hotels){
        for(int i = 0; i < hotels.size(); i++){
            System.out.print((i + 1) + ".  ");
            HotelDetailsView.displayHotelDetails(hotels.get(i));
            System.out.println("---------------------------------");
        }
    }
    public static void displayHotelDetails(Hotel hotel){
        printDepartureDate(hotel.getHotelSpec().getDepartureDate());
        printArrivalDate(hotel.getHotelSpec().getArrivalDate());
        printHotelName(hotel.getHotelName());
        printRoomType(hotel.getRoomType());
        printPrice(hotel.getPrice());
    }
    private static void printDepartureDate(Date date){
        if(!date.toString().isEmpty()){
            System.out.println("Departure Date: " + date.toString());
        }
    }
    private static void printArrivalDate(Date date){
        if(!date.toString().isEmpty()){
            System.out.println("Arrival Date: " + date.toString());
        }
    }
    private static void printPrice(double price){
        System.out.println("Price per night: " + price);
    }
    private static void printCity(String city){
        if(!city.isEmpty()){
            System.out.println("City: " + city);
        }
    }
    private static void printCountry(String country){
        if(!country.isEmpty()){
            System.out.println("Country: " + country);
        }
    }
    private static void printHotelName(String hotelName){
        if(!hotelName.isEmpty()){
            System.out.println("Hotel Name: " + hotelName);
        }
    }
    private static void printRoomType(String roomType){
        if(!roomType.isEmpty()){
            System.out.println("Room Type: " + roomType);
        }
    }
}
