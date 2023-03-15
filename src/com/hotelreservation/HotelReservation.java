package com.hotelreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
    Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Welcome to Hotel Reservation");
        System.out.println();
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel();
    }
    ArrayList<Hotel> hotelList = new ArrayList();

    public void addHotel(){
        System.out.println("Enter Hotel Name");
        String hotelName = scanner.next();
        System.out.println("Enter Hotel Type");
        String hotelType = scanner.next();
        System.out.println("Enter Hotel Rate");
        int rates = scanner.nextInt();

        Hotel hotel = new Hotel(hotelName, hotelType, rates);
        hotelList.add(hotel);
        System.out.println(hotelList);
    }
}
