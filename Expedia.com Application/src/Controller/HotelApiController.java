package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class HotelApiController implements HotelAPI {
    private final static HotelApiController INSTANCE = new HotelApiController();

    List<HotelAPI> hotelAPIS;

    public HotelApiController() {
        if (hotelAPIS == null)
            hotelAPIS = new ArrayList<>();
        // For testing
        hotelAPIS.add(TestHotelAPIAdapter.getInstance());
    }

    public static HotelApiController getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean bookHotel(User user, Hotel hotel) {
        for(HotelAPI api : hotelAPIS){
            if(api.bookHotel(user, hotel))
                return true;
        }
        return false;
    }

    @Override
    public List<Hotel> searchHotel(HotelSpec hotelSpec) {
        List<Hotel> hotels = new ArrayList<>();
        for (HotelAPI api : hotelAPIS)
            hotels.addAll(api.searchHotel(hotelSpec));
        return hotels;
    }
}
