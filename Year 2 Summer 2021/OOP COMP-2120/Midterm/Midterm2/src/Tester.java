import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Tester {
    
    public static void main(String[] args) {
        // Create a 3.5 stars hotel, named "Baba-Mama", built in 2018, with two floors
        // The owners' "firstname last name"'s of the hotel are "Ali Baba" and "Alice Mama".
        ArrayList<Person> owners = new ArrayList<Person>();
        owners.add(new Person("Ali", "Baba"));
        owners.add(new Person("Alice", "Mama"));

        Hotel baba = new Hotel("Baba-Mama", owners, Year.of(2018), 2, 3.5);

        
        
        
        
        
        // Adding some rooms to this new hotel
        // SINGLE, price=$35.50, size=200, floor=1, number=101, description="Single Room without view");

        baba.addRoom(RoomType.SINGLE, 35.5, 200, 1, 101, "Single Room without view");
        
        
        
        // Double, price=$50.50, size=350, floor=1, number=102, description="Double Room without view");
        baba.addRoom(RoomType.DOUBLE, 50.5, 350, 1, 102, "Double Room without view");
        
        
        
        // Double, price=$55.00, size=400, floor=2, number=201, description="Double Room with view");
        
        baba.addRoom(RoomType.DOUBLE, 55.00, 400, 2, 201, "Double Room with view");
        
        // Suite, price=80.00, size=500, floor=2, number=202, description="Suite Room with view and balcony");

        baba.addRoom(RoomType.SUITE, 80.00, 500, 2, 202, "Suite Room with view and balcony");
        
        
        
        // Show the hotel information, including its rooms
        System.out.println(baba);
        
        
        // Reserve the room number 102 for "Joe Uncle", checkin March 6, 2021, checkout March 8, 2021
        // Print out the reservation result

        System.out.println(baba.reserve(102, Date.valueOf("2021-03-06"), Date.valueOf("2021-03-08"), new Person("Joe", "Uncle")));
        
        
        
        
        
        
        // Change the price of the room 102 to $52.00

        baba.getRoom(102).setPrice(52.00);
        
        // Reserve the room number 102 for "Mike Brother", checkin April 2, 2021, checkout April 4, 2021
        // Print out the reservation result
        
        System.out.println(baba.reserve(102, Date.valueOf("2021-04-02"), Date.valueOf("2021-04-04"), new Person("Mike", "Brother")));
        
        
        
        
        
        // Reserve the room number 101 for "Maria Aunt", checkin May 27, 2021, checkout May 28, 2021
        // Print out the reservation result

        System.out.println(baba.reserve(101, Date.valueOf("2021-05-27"), Date.valueOf("2021-05-28"), new Person("Maria", "Aunt")));
        
        
        
        
        
        
        
        // Reserve the room number 101 for "laura Sister", checkin May 25, 2021, checkout May 28, 2021
        // Print out the reservation result
        
        
       System.out.println(baba.reserve(101, Date.valueOf("2021-05-25"), Date.valueOf("2021-05-28"), new Person("Laura", "Sister")));
        
        
        
        
        // Check in the room 102
        
        baba.getRoom(102).checkin();
        // Cancel reservation number 10003 and show the cancellation result
        System.out.println(baba.cancel(10003));

        
        
        
        
        // Show all the statuses of all the rooms

        for(Room p : baba.getRooms())
        {
            System.out.println(p.status());
        }
    }
}