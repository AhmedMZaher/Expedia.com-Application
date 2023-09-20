package Model;

import java.util.List;

public interface HotelAPI {
    List<Hotel> searchHotel(HotelSpec hotelSpec);
    boolean bookHotel(User user, Hotel hotel);
}
