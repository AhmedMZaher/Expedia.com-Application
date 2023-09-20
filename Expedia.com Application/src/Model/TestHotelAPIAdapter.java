package Model;

import Utils.Date;

import java.util.ArrayList;
import java.util.List;

public class TestHotelAPIAdapter implements HotelAPI {
    private static final TestHotelAPIAdapter INSTANCE = new TestHotelAPIAdapter();

    public static TestHotelAPIAdapter getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Hotel> searchHotel(HotelSpec hotelSpec) {
        List<Hotel> hotels = new ArrayList<>();
        // -----------------------------------------------------
        HotelSpec h1 = new HotelSpec(new Date("2023-09-15"), new Date("2023-09-18"), "LA", "USA", 3, 2);
        hotels.add(new Hotel(h1, "Hilton", "City View", 10));
        // -----------------------------------------------------
        HotelSpec h2 = new HotelSpec(new Date("2023-03-06"), new Date("2023-03-18"), "Cairo", "Egypt", 2, 0);
        hotels.add(new Hotel(h2, "Marriott", "Private View", 20));
        // -----------------------------------------------------
        return hotels;
    }

    @Override
    public boolean bookHotel(User user, Hotel hotel) {
        return false;
    }
}
