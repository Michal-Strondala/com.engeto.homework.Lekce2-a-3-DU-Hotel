package com.engeto.homework;

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
    private ArrayList<Guest> listOfGuests;


//endregion

    //region Booking`s Constructors

    public Booking( ArrayList<Guest> listOfGuests, Room room, LocalDate startOfStay, LocalDate endOfStay, boolean isWorking) {
        this.startOfStay = startOfStay;
        this.endOfStay = endOfStay;
        this.room = room;
        this.isWorking = isWorking;

        if (listOfGuests.size() != 0) {
            this.listOfGuests = listOfGuests;
        } else {
            System.out.println("Pozor chybí host! Rezervaci nelze vytvořit.");
        }


    }
    public Booking() {

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

    public ArrayList<Guest> getListOfGuests() {
        return listOfGuests;
    }
    public void setListOfGuests(ArrayList<Guest> listOfGuests) {
        this.listOfGuests = listOfGuests;
    }

    public int numberOfGuestsInOneBooking() {
        return listOfGuests.size();
    }

    @Override
    public String toString() {

        String guestsString = "";

        for (Guest guest : this.listOfGuests) {
            guestsString = guestsString + guest + "\n";
        }

        return
                "\nHosté:\n" + guestsString +
                "\nZačátek pobytu: " + this.formatDate(this.startOfStay) +
                "\nKonec pobytu: " + this.formatDate(this.endOfStay) +
                "\nPracovní cesta: " + (this.isWorking ? "ANO" : "NE") +
                "\n" + this.room +
                "\n================================="
                ;

    }

    //Metoda na zformátování data z anglického na české
    private String formatDate(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("cs", "CZ"));
        return date.format(formatter);
    }

    public double getNumberOfGuests() {
        return listOfGuests.size();
    }


    //endregion
}
