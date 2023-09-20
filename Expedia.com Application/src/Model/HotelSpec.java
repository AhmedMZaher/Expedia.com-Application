package Model;

import Utils.Date;

public class HotelSpec {
    private Date arrivalDate;
    private Date departureDate;
    private String city;
    private String country;
    private int numberOfAdults;
    private int numberOfChildren;

    public HotelSpec(Date arrivalDate, Date departureDate, String city, String country, int numberOfAdults, int numberOfChildren) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.city = city;
        this.country = country;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}
