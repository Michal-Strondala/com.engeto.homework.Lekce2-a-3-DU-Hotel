import com.engeto.homework.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

         //1.1 Vytvoř hosty a vypiš je na obrazovku:
        Guest adela = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        System.out.println(adela);
        Guest jan = new Guest("Jan", "Dvořáček", LocalDate.of(1995,5,5));
        System.out.println(jan);
        System.out.println();

        //1.2 Listy hostů
        ArrayList<Guest> listOfGuests1 = new ArrayList<>();
        listOfGuests1.add(adela);

        ArrayList<Guest> listOfGuests2 = new ArrayList<>();
        listOfGuests2.add(adela);
        listOfGuests2.add(jan);


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
        Booking booking1 = new Booking(listOfGuests1, room1, LocalDate.of(2021,7,19),LocalDate.of(2021,7,26), false );
        //3.2
        Booking booking2 = new Booking(listOfGuests2, room3, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14), false );


        //4.1 Plnění rezervací:
        ListOfBookings listOfBookings = new ListOfBookings();
        listOfBookings.addBooking(booking1);
        listOfBookings.addBooking(booking2);

        //4.2 Vypiš seznam všech rezervací:
        //listOfBookings.printOutBookings();



        //Test rezervace bez hosta:
//        ArrayList<Guest> listOfGuests3 = new ArrayList<>();
//        Booking booking3 = new Booking(listOfGuests3, room2, LocalDate.of(2021,9,1),LocalDate.of(2021,9,14), false );
//        listOfBookings.addBooking(booking3);





        //======Úkoly v lekci 3=======
        //Vlož do evidence rezervací následující rezervace.
        //Údaje, které chybí, si vymysli:

        //5.1
        // Karel Dvořák si rezervuje pokoj číslo 3 od 1. 6. 2023 do 7. 6. 2023. Bude to pracovní pobyt.

        //5.1.1
        //Vytvoření hosta Karla Dvořáka:
        Guest karel = new Guest("Karel", "Dvořák", LocalDate.of(1992,6,27));
        ArrayList<Guest> listOfGuests4 = new ArrayList<>();
        listOfGuests4.add(karel);

        //5.1.2
        //Vytvoření rezervace:
        Booking booking4 = new Booking(listOfGuests4, room3, LocalDate.of(2023,6,1), LocalDate.of(2023,6,7),true);

        //5.1.3
        //Přidání rezervace do seznamu všech rezervací:
        listOfBookings.addBooking(booking4);





        //5.2
        //Cestovní kancelář ABC Relax si rezervuje pokoj číslo 2
        //  na každý den v měsíci červnu 2023.
        //Vytvoř tedy 30 jednodenních rezervací pro rekreační pobyty.
        //Jako jediný host bude uvedena cestovní kancelář ABC Relax.

        //5.2.1
        //Vytvoření hosta ABC Relax
        Guest abcRelax = new Guest("ABC Relax");
        ArrayList<Guest> listOfGuests5 = new ArrayList<>();
        listOfGuests5.add(abcRelax);

        //5.2.2
        //Vytvoření pole bookingu pro ABC Relax a jejich vypsání
        ListOfBookings listOfBookingsABCRelax = new ListOfBookings();

        for (int i = 1; i <=30; i++) {
            if (i == 30) {
                listOfBookingsABCRelax.addBooking(new Booking(listOfGuests5, room2, LocalDate.of(2023,6, i), LocalDate.of(2023,7,1),false));
            } else {
                listOfBookingsABCRelax.addBooking(new Booking(listOfGuests5, room2, LocalDate.of(2023,6, i), LocalDate.of(2023,6, i + 1),false));
            }

        }

        //5.2.3
        //Přidání všech rezervací do společného seznamu rezervací:
        for (Booking booking : listOfBookingsABCRelax.getBookingList()) {
            listOfBookings.addBooking(booking);
        }





        //5.3
        //Alena Krásová si vytvoří 7 rezervací pokoje číslo 1
        // vždy na prvních 5 dnů v měsící počítaje 1. 6. 2023.
        // Budou to pracovní pobyty.

        //5.3.1
        //Vytvoření hosta Aleny Krásové
        Guest alenaKrasova = new Guest("Alena Krásová");
        ArrayList<Guest> listOfGuests6 = new ArrayList<>();
        listOfGuests6.add(alenaKrasova);

        //5.3.2
        //Vytvoření pole bookingu pro Alenu Krásovou
        ListOfBookings listOfBookingsAlenaKrasova = new ListOfBookings();

        //5.3.3
        //Vytvoření 7 rezervací a jejich vypsání
        for (int i = 6; i <=12; i++) {
            listOfBookingsAlenaKrasova.addBooking(new Booking(listOfGuests6, room1, LocalDate.of(2023, i, 1), LocalDate.of(2023, i, 5), true));
        }

        //5.3.4
        //Přidání všech rezervací do společného seznamu rezervací:
        for (Booking booking : listOfBookingsAlenaKrasova.getBookingList()) {
            listOfBookings.addBooking(booking);
        }





        //5.4
        //Cestovní kancelář ABC Relax si rezervuje pokoj číslo 2 na srpen 2023.
        // Bude se jednat o čtyři třídenní rezervace, které budou začínat 1., 7., 14. a 21. srpna 2023.

        //5.4.1
        //Vytvoření listu rezervace
        ListOfBookings listOfBookingsABCRelax2 = new ListOfBookings();

        for (int i = 1; i <=21; i++) {
            if (i == 1 || i % 7 == 0)
                listOfBookingsABCRelax2.addBooking(new Booking(listOfGuests5, room2, LocalDate.of(2023, 8, i), LocalDate.of(2023, 8, (i + 2)), false));
        }

        //5.4.2
        //Přidání všech rezervací do společného seznamu rezervací:
        for (Booking booking : listOfBookingsABCRelax2.getBookingList()) {
            listOfBookings.addBooking(booking);
        }

        //Vypsání všech rezervací:
        listOfBookings.printOutBookings();



        //==========METODY PRO ZJIŠTĚNÍ INFORMACÍ==========
        //6.1
        //Počet rezervací celkem:
        System.out.println("Počet rezervací celkem: " + listOfBookings.getNumberOfBookings());


        //6.2
        //Počet pracovních pobytů:
        System.out.println("Počet pracovních pobytů: " + listOfBookings.getNumberOfWorkingBookings());


        //6.3
        //Průměrný počet hostů na rezervaci:
        System.out.println("Průměrný počet hostů na rezervaci: " + (listOfBookings.getSumOfGuestsInAllBooking() / listOfBookings.getNumberOfBookings()));


        //6.4
        //Prvních osm rekreačních rezervací:
        System.out.println("\n=================================\n\nPrvních osm rekreačních rezervací:\n" + listOfBookings.first8RecreationalBookings());


        //6.5
        //Počet nocí na jeden pobyt:
        System.out.println();
        listOfBookings.getNumberOfNightsPerBooking();


        //6.6
        //Počet jednodenních (1 noc), dvoudenních (2 noci), vícedenních pobytů (více než 2 noci):
        System.out.println("\n=================================\n");
        listOfBookings.getNumberOfXNightStands();


        //6.7
        //Spočti pro každou objednávku její cenu. Znáš cenu pokoje na jednu noc a znáš datum začátku a konce rezervace.
        System.out.println("\n=================================\n");
        listOfBookings.printTotalPricePerBooking();


















    }
}