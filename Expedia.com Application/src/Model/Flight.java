package Model;

import DAO.FlightDao;
import DAO.ItemDao;
import Utils.Date;
import View.FlightDetailsView;

public class Flight extends Item{
    private FlightSpec flightSpec;
    private String airline;
    private String aircraftType;

    public Flight(FlightSpec flightSpec, String airline, String aircraftType, double ticketPrice) {
        this.flightSpec = flightSpec;
        this.airline = airline;
        this.aircraftType = aircraftType;
        setPrice(ticketPrice);
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
        int id = FlightDao.isFlightExist(this);
        if(id == -1){
            int lastID = ItemDao.addItem();
            FlightDao.addFlight(this, lastID);
            return lastID;
        }
        return id;
    }
}
