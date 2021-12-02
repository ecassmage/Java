import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Hotel extends Building{
    private String name;
    private double rate;

    private ArrayList<Person> owners;
    private ArrayList<Room> rooms;

    public Hotel(){
        super();
    }

    public Hotel(String name, ArrayList<Person> owners, Year yearBuilt, int numFloors, double rate){
        super(numFloors, yearBuilt);
        this.name = name;
        this.owners = owners;
        this.rate = rate;
        this.rooms = new ArrayList<Room>();
    }

    //mutators

    public void addOwner(String firstName, String lastName){
        this.owners.add(new Person(firstName, lastName));
    }

    public void addRoom(RoomType rType, double pricePNight, double size, int floorNum, int roomNum, String des){
        this.rooms.add(new Room(rType, pricePNight, size, floorNum, roomNum, des));
    }

    public int reserve(int roomNum, Date startDate, Date endDate, Person guest){
        if(this.getRoom(roomNum) == null)
        {
            return 0;
        }
        else
        {
        return this.getRoom(roomNum).reserve(startDate, endDate, guest);
        }
    }

    public Boolean cancel(int resID){
        // int i = 0;
        for(Room p : rooms){
            if(p.cancel(resID))
            {
                return true;
            }
        }
        return false;
    }

    //accessors
    public String getName(){
        return this.name;
    }

    public String getOwners(){
        String temp=" ";
        for(Person p : owners){
            temp += p.toString()+", ";
        }

        return temp;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public Room getRoom(int roomNum){
        for(Room p : rooms){
            if(p.getRoomNum() == roomNum)
            {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String temp; 
        temp = "Hotel " + this.getName() + ", " + this.rate + " Stars.\nHotel Owners: " + this.getOwners() + "\nRooms:\n";
        for(Room p : rooms){
            temp += p.toString()+"\n";
        }
        return temp;
    }

    






}
