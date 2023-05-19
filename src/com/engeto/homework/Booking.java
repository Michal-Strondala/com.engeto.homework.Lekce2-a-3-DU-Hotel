package com.engeto.homework;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Booking {
    //region Booking`s Attributes
    private LocalDate startOfStay;
    private LocalDate endOfStay;
    private boolean isWorking;
    private Room room;
    private ArrayList<Guest> guestList;
    //endregion

    //region Booking`s Constructors

    public Booking( ArrayList<Guest> guestList, Room room, LocalDate startOfStay, LocalDate endOfStay, boolean isWorking) {
        this.startOfStay = startOfStay;
        this.endOfStay = endOfStay;
        this.room = room;
        this.isWorking = isWorking;

        if (guestList.size() != 0) {
            this.guestList = guestList;
        } else {
            System.out.println("Pozor chybí host! Rezervaci nelze vytvořit.");
        }

    }

    //endregion

    //region Booking`s Methods

    public LocalDate getStartOfStay() {
        return startOfStay;
    }

    public void setStartOfStay(LocalDate startOfStay) {
        this.startOfStay = startOfStay;
    }

    public LocalDate getEndOfStay() {
        return endOfStay;
    }

    public void setEndOfStay(LocalDate endOfStay) {
        this.endOfStay = endOfStay;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {

        String guestsString = "";

        for (Guest guest : this.guestList) {
            guestsString = guestsString + guest + "\n";
        }

        return
                "\nHosté:\n" + guestsString +
                "\nZačátek pobytu: " + this.formatDate(startOfStay) +
                "\nKonec pobytu: " + this.formatDate(endOfStay) +
                "\nPracovní cesta: " + isWorking +
                "\n" + room +
                "\n================================="
                ;
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("cs", "CZ"));
        return date.format(formatter);
    }


    //endregion
}
