import java.sql.Date;
import java.time.Instant;

public class Reservation {
    private static int ReservationHotel = 10000;
    private Date[] laDate;  // Apparently Bad Practice to use Other Peoples Stuff.
    private double pricePerNight;
    private Person guest;
    private int reservationNumber;
    private int[][] calendar;

    public static void main(String[] args){
        Reservation R = new Reservation(new Date(2010, 5, 15), new Date(2011, 4, 1), 1000000.1, new Person("Evan", "Morrison"));
        System.out.println(R.isAvailable(new Date(2009, 5, 10), new Date(2010, 1, 1)));
        System.out.println(R.isAvailable(new Date(2009, 5, 10), new Date(2011, 9, 1)));
        System.out.println(R.isAvailable(new Date(2010, 5, 10), new Date(2010, 6, 1)));
        System.out.println(R.isAvailable(new Date(2011, 3, 10), new Date(2012, 1, 1)));
        System.out.println(R.isAvailable(new Date(2010, 6, 21), new Date(2010, 10, 15)));
        System.out.println(R.isAvailable(new Date(2011, 6, 21), new Date(2011, 10, 15)));
        System.out.println(R.isAvailable(new Date(2011, 4, 1), new Date(2011, 4, 2)));
        System.out.println(R.isAvailable(new Date(2011, 3, 30), new Date(2011, 4, 5)));
    }
    public Reservation(Date startDate, Date endDate, double price, Person guest){

        this.reservationNumber = ++ReservationHotel;
        this.laDate = new Date[]{startDate, endDate};
        this.pricePerNight = price;
        this.guest = guest;
    }

    public Date getStartDate(){
        return laDate[0];
    }
    public Date getEndDate(){
        return laDate[1];
    }
    public int getReservationNumber(){
        return reservationNumber;
    }

    public boolean isAvailable(Date sDate, Date eDate) { return (laDate[1].getTime() <= sDate.getTime() || laDate[0].getTime() > eDate.getTime()); }

    @Override
    public String toString(){
        return "Reservation Number: " + getReservationNumber() + "\nFrom: " + getStartDate() + " To: " + getEndDate() + "\nGuest: " + guest + "\n$" + pricePerNight + " per night";
    }
}
