package Model;

import Utils.Date;
import java.util.Map;

public class FlightSpec {
    private Date departureDate;
    private  Date ArrivalDate;
    private String departureCity;
    private String arrivalCity;

    public FlightSpec(Date departureDate, Date arrivalDate, String departureCity, String arrivalCity) {
        this.departureDate = departureDate;
        this.ArrivalDate = arrivalDate;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }



    public Utils.Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}
