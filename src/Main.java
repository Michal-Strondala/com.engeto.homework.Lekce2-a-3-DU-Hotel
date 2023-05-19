import com.engeto.homework.Booking;
import com.engeto.homework.Guest;
import com.engeto.homework.ListOfBookings;
import com.engeto.homework.Room;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

         //1.1 Vytvoř hosty a vypiš je na obrazovku:
        Guest adela = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        System.out.println(adela);
        Guest jan = new Guest("Jan", "Dvořáček", LocalDate.of(1995,5,5));
        System.out.println(jan);
        System.out.println();

        //1.2 Listy hostů
        ArrayList<Guest> guestListroom1 = new ArrayList<>();
        guestListroom1.add(adela);

        ArrayList<Guest> guestListroom3 = new ArrayList<>();
        guestListroom3.add(adela);
        guestListroom3.add(jan);


        //2.1 Vytvoř pokoje a vypiš na obrazovku jejich popis:
        Room room1 = new Room(1, 1, true, true, 1000);
        System.out.println(room1);
        System.out.println();
        Room room2 = new Room(2, 1, true, true, 1000);
        System.out.println(room2);
        System.out.println();

        //2.2
        Room room3 = new Room(3, 3, false, true, 2400);
        System.out.println(room3);
        System.out.println();



        //3.1 Připrav rezervace
        Booking booking1 = new Booking(guestListroom1, room1, LocalDate.of(2021,7,19),LocalDate.of(2021,7,26), false );
        //3.2
        Booking booking2 = new Booking(guestListroom3, room3, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14), false );



        //4.1 Plnění rezervací:
        ListOfBookings listOfBookings = new ListOfBookings();
        listOfBookings.addBooking(booking1);
        listOfBookings.addBooking(booking2);

        //4.2 Vypiš seznam všech rezervací:
        listOfBookings.getBookingList();

        //Test rezervace bez hosta:
//        ArrayList<Guest> guestListroom2 = new ArrayList<>();
//        Booking booking3 = new Booking(guestListroom2, room2, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14), false );
//        listOfBookings.addBooking(booking3);

    }
}