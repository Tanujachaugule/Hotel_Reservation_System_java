package com.hotelreservation;

public class Hotel implements Comparable<Hotel>{
    private String name;
    private float rate;

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



    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rate=" + rate + '}';
    }


    @Override
    public int compareTo(Hotel h) {
        return (int) (this.rate - h.rate);
    }


}
