package com.engeto.homework;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class ListOfBookings {


    private ArrayList<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {

        this.bookingList.add(booking);

    }

    public Collection<? extends Booking> getBookingList() {
        return bookingList;
    }

    public void printOutBookings() {
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }


    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    //==========METODY PRO ZJIŠTĚNÍ INFORMACÍ==========
    //6.1
    //Počet rezervací celkem:
    public double getNumberOfBookings() {
        double  numberOfBookings = 0;
        for (Booking booking : bookingList) {
            numberOfBookings = numberOfBookings + 1;
        }
        return numberOfBookings;
    }

    //6.2
    //Počet pracovních pobytů:
    public int getNumberOfWorkingBookings() {
        int numberOfWorkingBookings = 0;
        for (Booking booking : bookingList) {
            if (booking.isWorking()) {
                numberOfWorkingBookings = numberOfWorkingBookings + 1;
            }
        }
        return numberOfWorkingBookings;
    }

    //6.3
    //Průměrný počet hostů na rezervaci:
    public double getSumOfGuestsInAllBooking() {
        double sumOfGuestsInAllBooking = 0;
        for (Booking booking : bookingList) {
            sumOfGuestsInAllBooking += booking.getNumberOfGuests();
        }
        return sumOfGuestsInAllBooking;

    }

    //6.4
    //Prvních osm rekreačních rezervací:
    public String first8RecreationalBookings() {
        String first8 = "";
        int i=1;
        for (Booking booking : bookingList) {
            if (!booking.isWorking() && i < 9) {
                first8 = first8 + booking.toString();
                i++;
            }
        }
        return first8;
    }

    //6.5
    //Počet nocí na jeden pobyt:
    public void getNumberOfNightsPerBooking() {
        for (Booking booking : bookingList)
            System.out.println("Počet nocí na pobyt: " + ChronoUnit.DAYS.between(booking.getStartOfStay(), booking.getEndOfStay()));
    }

    //6.6
    //Počet jednodenních (1 noc), dvoudenních (2 noci), vícedenních pobytů (více než 2 noci):
    public void getNumberOfXNightStands() {
        int numberOfOneNightStands = 0;
        int numberOfTwoNightStands = 0;
        int numberOfMultipleNightStands = 0;
        for (Booking booking : bookingList) {
                if (ChronoUnit.DAYS.between(booking.getStartOfStay(), booking.getEndOfStay()) == 1) {
                    numberOfOneNightStands += 1;
                } else if (ChronoUnit.DAYS.between(booking.getStartOfStay(), booking.getEndOfStay()) == 2) {
                    numberOfTwoNightStands += 1;
                } else if (ChronoUnit.DAYS.between(booking.getStartOfStay(), booking.getEndOfStay()) > 2) {
                    numberOfMultipleNightStands += 1;
                }
        }
        System.out.println("Počet jednodenních pobytů: " + numberOfOneNightStands + "\nPočet dvoudenních pobytů: " + numberOfTwoNightStands + "\nPočet vícedenních pobytů: " + numberOfMultipleNightStands);
    }

    //Metoda na zformátování data z anglického na české
    private String formatDate(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("cs", "CZ"));
        return date.format(formatter);
    }

    //6.7
    //Spočti pro každou objednávku její cenu. Znáš cenu pokoje na jednu noc a znáš datum začátku a konce rezervace.
    public void printTotalPricePerBooking() {
        for (Booking booking : bookingList) {
            long numberOfNights = ChronoUnit.DAYS.between(booking.getStartOfStay(), booking.getEndOfStay());
            long totalPrice = numberOfNights * booking.getRoom().getPricePerNight();
            if (numberOfNights == 1) {
                System.out.println(booking.getListOfGuests() + " (pokoj " + booking.getRoom().getRoomNumber() + "): " + numberOfNights + " noc od " + formatDate(booking.getStartOfStay()) + " za " + totalPrice + " Kč");
            } else if (numberOfNights > 1 && numberOfNights < 5) {
                System.out.println(booking.getListOfGuests() + " (pokoj " + booking.getRoom().getRoomNumber() + "): " + numberOfNights + " noci od " + formatDate(booking.getStartOfStay()) + " za " + totalPrice + " Kč");
            } else {
                System.out.println(booking.getListOfGuests() + " (pokoj " + booking.getRoom().getRoomNumber() + "): " + numberOfNights + " nocí od " + formatDate(booking.getStartOfStay()) + " za " + totalPrice + " Kč");
            }
        }
    }


}
