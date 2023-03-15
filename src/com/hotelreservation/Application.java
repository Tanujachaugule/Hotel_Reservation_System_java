package com.hotelreservation;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();

    public static void main (String[] args) throws ParseException {

        System.out.println("Welcome to Hotel Reservation System");

        Application application = new Application();

        application.provideUserOption();
    }

    public void provideUserOption() throws ParseException {
        while(true) {
            System.out.println("Choose Options " +
                    "\n1. Add Hotel" +
                    "\n2. Find Cheapest Hotel for weekdays and Weekends" +
                    "\n3. Find Cheapest  best rated hotel ");
            String userOption = scanner.next();
            switch (userOption) {
                case "1" :
                    addHotel();
                    break;
                case "2":
                    findCheapestHotel();
                case "10" :
                    System.exit(0);
            }
        }
    }

    public void addHotel() {
        Hotel hotel = new Hotel();
        System.out.println("Enter Hotel Name");
        String name = scanner.next();
        System.out.println("Enter weekday rate ");
        float rate = scanner.nextFloat();
        System.out.println("Enter weekend rate");
        float weekendRate = scanner.nextFloat();
        System.out.println("Enter Ratings of hotel");
        int ratings = scanner.nextInt();
        System.out.println("Enter weekday rate for Reward Customer ");
        float rateForRewardCustomer = scanner.nextFloat();
        System.out.println("Enter weekend rate for Reward Customer");
        float weekendRateForRewardCustomer = scanner.nextFloat();

        hotel.setName(name);
        hotel.setRate(rate);
        hotel.setWeekendRate(weekendRate);
        hotel.setRatings(ratings);
        hotel.setRateForRewardCustomer(rateForRewardCustomer);
        hotel.setWeekendRateForRewardCustomer(weekendRateForRewardCustomer);

        hotelManagementSystem.hotelList.add(hotel);
        System.out.println(hotelManagementSystem.hotelList);
    }


    public void findCheapestHotel() throws ParseException {

        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = hotelManagementSystem.findDayOfWeek(checkInDate);
        String Day2 = hotelManagementSystem.findDayOfWeek(checkOutDate);

        int days = hotelManagementSystem.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);

        Hotel cheapestHotel = hotelManagementSystem.findCheapestHotel(days);
        float totalRate = cheapestHotel.getRate() * days;

        Hotel cheapestHote2 = hotelManagementSystem.findCheapestHotel(days);
        float totalWeekendRate = cheapestHotel.getWeekendRate() * 2;

        if (Day1.equalsIgnoreCase("Saturday") | Day1.equalsIgnoreCase("Sunday") | Day2.equalsIgnoreCase("Saturday") | Day2.equalsIgnoreCase("Sunday")) {
            System.out.println("Best hotel availble on weekend  " + cheapestHotel.getName() + " having rate $" + totalWeekendRate);
        } else {
            System.out.println("Cheapest hotel is " + cheapestHote2.getName() + " having rate $" + totalRate);
        }
    }
    public void findBestRatedHotel() throws ParseException {

        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = hotelManagementSystem.findDayOfWeek(checkInDate);
        String Day2 = hotelManagementSystem.findDayOfWeek(checkOutDate);

        int days = hotelManagementSystem.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);
        Hotel cheapestHotel = hotelManagementSystem.findCheapestHotel(days);
        float totalRate = cheapestHotel.getRate() * days;

        ArrayList<Hotel> bestRatedList = new ArrayList<>();
        for (Hotel hotel : hotelManagementSystem.hotelList) {
            if (hotel.getRatings() >= 4) {
                bestRatedList.add(hotel);
            }
        }
        System.out.println("\n All the hotels with best rating are  :" + bestRatedList + "\n");

        System.out.println("You can choose any 1 of this Best rated hotels having cheapest cost: \n");
        bestRatedList.stream();

            bestRatedList.sort(Comparator.comparing(Hotel::getRate));
            bestRatedList.forEach((Hotel h) -> System.out.println("Hotel " + h.getName() + ", with Rating = " + h.getRatings() + ", is available at $ = " + (h.getRate() * days) ));
    }
}
