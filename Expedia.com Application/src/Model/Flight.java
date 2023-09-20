package Model;

import DAO.FlightDao;
import DAO.ItemDao;
import Utils.Date;
import View.FlightDetailsView;

public class Flight extends Item{
    private FlightSpec flightSpec;
    private String airline;
    private String aircraftType;

    public Flight(FlightSpec flightSpec, String airline, String aircraftType, double price) {
        this.flightSpec = flightSpec;
        this.airline = airline;
        this.aircraftType = aircraftType;
        setPrice(price);
    }

    public FlightSpec getFlightSpec() {
        return flightSpec;
    }

    public String getAirline() {
        return airline;
    }

    public String getAircraftType() {
        return aircraftType;
    }
    @Override
    public void printItem(){
        FlightDetailsView.displayFlightDetails(this);
    }

    @Override
    public int getItemIdFromDatabase(){
        // Check if this flight already exist in the date base
        int id = FlightDao.isFlightExist(this);

        // If it's not exist
        if(id == -1){
            // Add new item to Item database and get its id
            int lastID = ItemDao.addItem();

            // Then add the flight to database
            FlightDao.addFlight(this, lastID);
            return lastID;
        }
        return id;
    }
}
