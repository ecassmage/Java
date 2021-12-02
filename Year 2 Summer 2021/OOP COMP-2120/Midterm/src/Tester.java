import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Tester {
    
    public static void main(String[] args) {
        // Create a 3.5 stars hotel, named "Baba-Mama", built in 2018, with two floors
        // The owners' "firstname last name"'s of the hotel are "Ali Baba" and "Alice Mama".
        Hotel hotel = new Hotel("Baba-Mama", new Person[]{new Person("Ali", "Baba"), new Person("Alice", "Mama")}, 2018, 2, 3.5);
        
        // Adding some rooms to this new hotel
        // SINGLE, price=$35.50, size=200, floor=1, number=101, description="Single Room without view");
        hotel.addRoom(new Room(RoomType.SINGLE, 35.50, 200, 1, 101, "Single Room without view"));
        
        // Double, price=$50.50, size=350, floor=1, number=102, description="Double Room without view");
        hotel.addRoom(new Room(RoomType.DOUBLE, 50.50, 350, 1, 102, "Double Room without view"));
        
        // Double, price=$55.00, size=400, floor=2, number=201, description="Double Room with view");
        hotel.addRoom(new Room(RoomType.DOUBLE, 55, 400, 2, 201, "Double Room with view"));
        
        // Suite, price=80.00, size=500, floor=2, number=202, description="Suite Room with view and balcony");
        hotel.addRoom(new Room(RoomType.SUITE, 80, 500, 2, 202, "Double Room with view and balcony"));
        
        // Show the hotel information, including its rooms
        System.out.println(hotel);  // Prints List of Rooms that Were Made.
        
        // Reserve the room number 102 for "Joe Uncle", checkin March 6, 2021, checkout March 8, 2021
        int JoeIsAReserve = hotel.reserve(102, new Date(2021, 2, 6), new Date(2021, 2, 8), new Person("Joe", "Uncle"));
        // Print out the reservation result
        reservationGood(102, JoeIsAReserve);  // Because this is needed many times and I couldn't find a specification in the midterm questions I decided to write it as a method in here.

        // Change the price of the room 102 to $52.00
        hotel.getRoom(102).setPricepernight(52.00);

        // Reserve the room number 102 for "Mike Brother", checkin April 2, 2021, checkout April 4, 2021
        int MikeIsAReserve = hotel.reserve(102, new Date(2021, 3, 2), new Date(2021, 3, 4), new Person("Mike", "Brother"));
        // Print out the reservation result
        reservationGood(102, MikeIsAReserve); // 102 is the room MikeIsAReserve is the reservation number returned, if 0 it means something went wrong.

        // Reserve the room number 101 for "Maria Aunt", checkin May 27, 2021, checkout May 28, 2021
        int MariaIsAReserve = hotel.reserve(101, new Date(2021, 4, 27), new Date(2021, 4, 28), new Person("Maria", "Aunt"));
        // Print out the reservation result
        reservationGood(101, MariaIsAReserve); // 101 is the room MariaIsAReserve is the reservation number returned, if 0 it means something went wrong.

        // Reserve the room number 101 for "Laura Sister", checkin May 25, 2021, checkout May 28, 2021
        int LauraIsAReserve = hotel.reserve(101, new Date(2021, 4, 25), new Date(2021, 4, 28), new Person("Laura", "Sister"));
        // Print out the reservation result
        reservationGood(101, LauraIsAReserve);  // 101 is the room LauraIsAReserve is the reservation number returned, if 0 it means something went wrong.

        // Check in the room 102
        hotel.getRoom(102).checkin();
        if (hotel.getRoom(102).getVacancyStatus()) System.out.println("Room " + 102 + " is not checked in.");
        else System.out.println("Room " + 102 + " is checked in.");

        // Cancel reservation number 10003 and show the cancellation result
        if (hotel.cancel(10003)) System.out.println("Reservation " + 10003 + " is canceled.");  // Will cancel if hotel.cancel(10003) returns true;
        else System.out.println("Reservation " + 10003 + " is not canceled.");                              // Will not cancel if hotel.cancel(10003) returns false;

        // Show all the statuses of all the rooms
        System.out.println("---------------\nRooms' Statuses\n---------------");
        for (Room room: hotel.getRooms()){
            System.out.print(room.status());
            // Okay My thing here diverges a little here. but the issue is that I think the Midterm Exam is wrong here since Maria currently is reserved here and
            // Since Room 102 has 2 reservations and both are being showed in this section so it obviously doesn't just want the currently Occupied reservation information.
        }
    }

    public static void reservationGood(int room, int num){
        if (num == 0) System.out.println("Sorry, Reservation was not successful. Check the room availability.");
        else System.out.println("Room " + room + " Reservation Successful. Reservation number: " + num);
    }
}
