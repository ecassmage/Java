import java.util.ArrayList;
import java.sql.Date;

enum RoomType { SINGLE, DOUBLE, STUDIO, SUITE }

public class Room extends Hotel{
    
    private RoomType rtype;

    private double pricePNight;
    private double size;

    private int floorNum;
    private int roomNum;

    private String des;

    private boolean isVaccant;

    private ArrayList<Reservation> rezs;

    public Room(double pricePNight){
        // super(pricePNight);
        this.pricePNight = pricePNight;

        this.isVaccant = true;
        this.rezs = new ArrayList<Reservation>();
    }

    public Room(RoomType rType, double pricePNight, double size, int floorNum, int roomNum, String des){
        this.rtype = rType;
        this.pricePNight = pricePNight;
        this.size = size;
        this.floorNum = floorNum;
        this.roomNum = roomNum;
        this.des = des;

        this.isVaccant = true;

        this.rezs = new ArrayList<Reservation>();
    }

    


    //accessors
    public boolean isVaccant(){
        return this.isVaccant;
    }

    public int getRoomNum(){
        return this.roomNum;
    }

    public double getPrice(){
        return this.pricePNight;
    }

    public ArrayList<Reservation> getReservations(){
        return this.rezs;
    }

    // @Override
    public int reserve(Date startDate, Date endDate, Person guest){
        for(Reservation p : rezs){
            if(p.isAvailable(startDate, endDate) && isVaccant){
                this.rezs.add(new Reservation(startDate, endDate, this.pricePNight, guest));
                return this.rezs.get(this.rezs.size()-1).getResNum();
            }
        }
        return 0;
    }

    public String status(){
        String temp = "Reservation list of room number " + this.getRoomNum() + ": ";
        if(this.isVaccant()){
            temp += "Vacant.\n";
        }
        else
        {
            temp += "Occupied.\n";
        }

        for(Reservation r : rezs){
            temp += r.toString()+"\n";
        }

        return temp;
    }

    @Override
    public String toString(){
        return this.rtype.toString() + ", price=$" + this.getPrice()+", Size=" + this.size + ", Number=" + this.getRoomNum() + ", Floor=" + this.floorNum + "\nDescription: " + this.des; 
    }

    //Mutators
    public void setPrice(double price){
        this.pricePNight = price;
    }

    // @Override
    public Boolean cancel(int resID){
        for(Reservation r : rezs){
            if(r.getResNum() == resID)
            {
                rezs.remove(r);
                return true;
            }
        }
        return false;
    }

    public void checkin(){
        if(this.isVaccant){
            this.isVaccant = false;
        }
    }

    public void checkout(){
        if(!this.isVaccant){
            this.isVaccant = true;
        }
    }



}
