import java.sql.Date;
import java.util.ArrayList;

enum RoomType {SINGLE, DOUBLE, STUDIO, SUITE}

public class Room {
    private RoomType roomtype;
    private double pricepernight;
    private int roomsize;
    private int floornumber;
    private int roomnumber;
    private String description;
    private boolean vacancystatus;
    private ArrayList<Reservation> theReserves;


    public Room(RoomType roomtype, double pricepernight, int roomsize, int floornumber, int roomnumber, String description){
        this.roomtype = roomtype;
        this.pricepernight = pricepernight;
        this.roomsize = roomsize;
        this.floornumber = floornumber;
        this.roomnumber = roomnumber;
        this.description = description;
        this.vacancystatus = true;
        this.theReserves = new ArrayList<>();
    }

    public boolean getVacancyStatus(){ return vacancystatus; }
    public int getRoomNumber(){ return roomnumber; }
    public double getPrice(){ return pricepernight; }
    public ArrayList<Reservation> getListOfReserves(){ return theReserves; }

    public void setPricepernight(double prices) { pricepernight = prices; }

    public int reserve(Date sDate, Date eDate, Person guest){
        for (Reservation reserve: theReserves){
            if(!reserve.isAvailable(sDate, eDate)) return 0;
        }
        Reservation ptr = new Reservation(sDate, eDate, pricepernight, guest);
        theReserves.add(ptr);
        return ptr.getReservationNumber();
    }

    public void cancel(int reserveNumber){
        loopdyDo:{
            for (Reservation reserve: theReserves){
                if (reserve.getReservationNumber() == reserveNumber) {
                    theReserves.remove(reserve);
                    break loopdyDo;  // Should break before anything bad happens
                }
            }
            System.out.println("Didn't Find ReservationNumber for this Room");
        }
    }

    public void checkin(){
        vacancystatus = false;
    }
    public void checkOut(){
        vacancystatus = true;
    }

    public String status(){
        String concatString = new String("Reservation list of room number " + roomnumber + ": " + (vacancystatus ? "Vacant":"Occupied") + "\n");
//        for (int i = 0; i < theReserves.size(); i++){
//            if (i!=theReserves.size()-1) concatString += '\n';
//        }
        for (Reservation reserve: theReserves){
            concatString += reserve.toString() + "\n";
        }
        return concatString;
    }

    @Override
    public String toString(){
        return roomtype + ", price=$" + pricepernight + ", Size=" + roomsize + ", Number=" + roomnumber + ", Floor=" + floornumber + "\nDescription: " + description;
    }
}
