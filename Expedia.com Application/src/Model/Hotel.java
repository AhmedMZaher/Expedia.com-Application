package Model;

public class Hotel extends Item{
    private HotelSpec hotelSpec;
    private String hotelName;
    private String roomType;

    public Hotel(HotelSpec hotelSpec, String hotelName, String roomType) {
        this.hotelSpec = hotelSpec;
        this.hotelName = hotelName;
        this.roomType = roomType;
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
        int id = 
    }
}
