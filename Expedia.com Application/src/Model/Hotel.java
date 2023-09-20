package Model;

import DAO.HotelDao;
import DAO.ItemDao;
import View.FlightDetailsView;
import View.HotelDetailsView;

public class Hotel extends Item{
    private HotelSpec hotelSpec;
    private String hotelName;
    private String roomType;

    public Hotel(HotelSpec hotelSpec, String hotelName, String roomType, double price) {
        this.hotelSpec = hotelSpec;
        this.hotelName = hotelName;
        this.roomType = roomType;
        setPrice(price);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public HotelSpec getHotelSpec() {
        return hotelSpec;
    }

    public void setHotelSpec(HotelSpec hotelSpec) {
        this.hotelSpec = hotelSpec;
    }

    @Override
    public int getItemIdFromDatabase(){
        // Check if this hotel already exist in the date base
        int id = HotelDao.isHotelExist(this);

        // If it's not exist
        if(id == -1){
            // Add new item to Item database and get its id
            int lastID = ItemDao.addItem();

            // Then add the hotel to database
            HotelDao.addHotel(this, lastID);
            return lastID;
        }
        // If it's exist return its id
        return id;
    }
    @Override
    public void printItem(){
        HotelDetailsView.displayHotelDetails(this);
    }
}
