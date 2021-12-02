import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * This is a Hotel Program which can manage and operate certain elements of a hotel
 * @author Evan Morrison
 * @version 1.0
 * @since 1.0
 */
public class Hotel extends Building{
    private String name;
    private double rate;  // I assume this is actually rating since the example toString output has 3.5 stars. Somewhat confusing since hotels can have rates.
    private ArrayList<Person> Owners;
    private ArrayList<Room> rooms;

    /**
     * This Constructs a Default Hotel
     */
    public Hotel(){
        super();
    }

    /**
     * This Constructs a new Hotel.
     * @param name takes a string for the name of the hotel
     * @param Owners Takes a list of Owners in an array setup
     * @param yearofbuilt takes the year that this hotel as a building was built
     * @param numfloors takes the number of floors this building has
     * @param rate takes the rating of the establishment
     */
    public Hotel(String name, Person[] Owners, int yearofbuilt, int numfloors, double rate){
        super(yearofbuilt, numfloors);
        this.name = name;
        this.Owners = new ArrayList<>();
        for (Person person: Owners) this.Owners.add(person);
        this.rate = rate;
        this.rooms = new ArrayList<>();
    }

    /**
     * This Constructs a new Hotel.
     * @param name takes a string for the name of the hotel
     * @param Owners Takes a list of Owners in an Arraylist setup
     * @param yearofbuilt takes the year that this hotel as a building was built
     * @param numfloors takes the number of floors this building has
     * @param rate takes the rating of the establishment
     */
    public Hotel(String name, ArrayList<Person> Owners, int yearofbuilt, int numfloors, double rate){
        super(yearofbuilt, numfloors);
        this.name = name;
        this.Owners = Owners;
        this.rate = rate;
        this.rooms = new ArrayList<>();
    }

    /**
     * retrieves the hotels name
     * @return returns the hotels name
     */
    public String getHotelName(){ return name; }

    /**
     * retrieves the List of Owners
     * @return returns an arraylist of the Owners
     */
    public ArrayList<Person> getOwnersList(){ return Owners; }

    /**
     * retrieves the rooms in the hotel
     * @return returns an arraylist of rooms
     */
    public ArrayList<Room> getRooms(){ return rooms; }

    /**
     * retrieves a specific room based on its room Number
     * @param roomNumber takes an int holding the room Number searching for
     * @return returns the Room object of the room if found else null.
     */
    public Room getRoom(int roomNumber){
        for (Room room: this.rooms){
            if (room.getRoomNumber() == roomNumber) return room;
        }
        return null;
    }

    /**
     * adds a new owner
     * @param newOwner Takes a Person of the new Owner.
     */
    public void addOwner(Person newOwner){
        Owners.add(newOwner);
    }

    /**
     * adds a new room
     * @param newRoom takes a Room object of the new room.
     */
    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }

    /**
     * Checks if these dates can be reserved for this specific room.
     * @param roomNumber takes an int for the room number
     * @param sDate Takes a Date ovbject for the starting date
     * @param eDate Takes a Date ovbject for the leaving date
     * @param guest Takes the Person Object of the person reserving room or person who will be staying in room
     * @return returns reservation number.
     */
    public int reserve(int roomNumber, Date sDate, Date eDate, Person guest){
        for (Room room: rooms){
            if (room.getRoomNumber() == roomNumber) return room.reserve(sDate, eDate, guest);
        }
        return 0;
    }

    /**
     * Cancels a reservation searches through all reservations to find reservation
     * @param reserveNumber takes an int for reservation number
     * @return returns true if successfully cancelled else false.
     */
    public boolean cancel(int reserveNumber){
        for (Room room: rooms){
            for (Reservation reserves: room.getListOfReserves()){
                if (reserves.getReservationNumber() == reserveNumber){
                    room.cancel(reserveNumber);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Converts Object to a string
     * @return returns converted String.
     */
    @Override
    public String toString(){
        String concatString = new String("Hotel " + name + ", " + rate + " stars.\nHotel Owners: ");
        for (int i = 0; i < Owners.size(); i++){
            if (i != 0) concatString += "  ";
            concatString += Owners.get(i);
        }
        concatString += "\nRooms:\n";

        for (Room room: rooms){
            concatString += room.toString();
        }
        return concatString;
    }
}
