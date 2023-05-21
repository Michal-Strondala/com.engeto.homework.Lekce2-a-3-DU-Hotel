package com.engeto.homework;

import java.util.List;

public class BookingManager {

    //region Atribut třídy BookingManager
    private List<Booking> bookings;
    //endregion

    //region Metody třídy BookingManager
    //Vložení rezervace do seznamu:
    public void add(Booking newBooking) {
        bookings.add(newBooking);
    }


    //Získání seznamu rezervací:
    public List<Booking> getBookings() {
        return bookings;
    }

    //endregion
}
