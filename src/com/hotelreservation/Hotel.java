package com.hotelreservation;

public class Hotel implements Comparable<Hotel>{
    private String name;
    private float rate;
    private float weekendRate;
    private int ratings;


    public Hotel(String hotelName, String hotelType, int rates) {
    }

    public Hotel() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public float getRate() {

        return rate;
    }

    public void setRate(float rate) {

        this.rate = rate;
    }
    public float getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(float weekendRate) {
        this.weekendRate = weekendRate;
    }
    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }



    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", weekendRate=" + weekendRate +
                ", ratings=" + ratings +
                '}';
    }


    @Override
    public int compareTo(Hotel h) {
        return (int) (this.rate - h.rate);
    }


}
