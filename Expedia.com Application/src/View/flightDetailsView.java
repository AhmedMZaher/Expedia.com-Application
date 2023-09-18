package View;

import Model.Flight;
import Utils.Date;

public class FlightDetailsView {
    public static void displayFlightDetails(Flight flight){
        printAirline(flight.getAirline());
        printDepartureCity(flight.getFlightSpec().getDepartureCity());
        printDepartureDate(flight.getFlightSpec().getDepartureDate());
        printArrivalCity(flight.getFlightSpec().getArrivalCity());
        printArrivalDate(flight.getFlightSpec().getArrivalDate());
        printAircraftType(flight.getAircraftType());
        printPrice(flight.getTicketPrice());
    }
    private static void printDepartureCity(String city){
        if(!city.isEmpty()){
            System.out.println("Departure City: " + city);
        }
    }
    private static void printArrivalCity(String city){
        if(!city.isEmpty()){
            System.out.println("Arrival City: " + city);
        }
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
    private static void printAirline(String airline){
        if(!airline.isEmpty()){
            System.out.println("Airline: " + airline);
        }
    }
    private static void printAircraftType(String aircraftType){
        if(!aircraftType.isEmpty()){
            System.out.println("Aircraft Type: " + aircraftType);
        }
    }
    private static void printPrice(double price){
        System.out.println("Price: " + price);
    }
}
