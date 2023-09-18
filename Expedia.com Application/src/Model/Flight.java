package Model;

import Utils.Date;

public class Flight extends Item{
    private FlightSpec flightSpec;
    private String airline;
    private String aircraftType;

    public Flight(FlightSpec flightSpec, String airline, String aircraftType, double ticketPrice) {
        this.flightSpec = flightSpec;
        this.airline = airline;
        this.aircraftType = aircraftType;
        this.ticketPrice = ticketPrice;
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

}
