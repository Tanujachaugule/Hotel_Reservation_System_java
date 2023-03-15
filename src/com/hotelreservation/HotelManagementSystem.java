package com.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelManagementSystem {
    Scanner scanner = new Scanner(System.in);
    List<Hotel> hotelList = new ArrayList<>();

    public int findDateDifference(String startDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(startDate);
        Date secondDate = sdf.parse(endDate);
        long differenceInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        int days = (int) TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
        return days;
    }

    Comparator<Hotel> minComparator = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel h1, Hotel h2) {
            return h1.compareTo(h2);

        }
    };


    public Hotel findCheapestHotel(int numDays) {
        int lowestRate;
        Optional<Hotel> hotel = hotelList.stream()
                .min(minComparator);
        return hotel.get();
    }

}
