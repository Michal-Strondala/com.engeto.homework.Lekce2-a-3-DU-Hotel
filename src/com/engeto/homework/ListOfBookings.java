package com.engeto.homework;

import java.util.ArrayList;

public class ListOfBookings {
    private ArrayList<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    public void getBookingList() {
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
