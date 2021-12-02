import java.sql.Date;

public class Reservation extends Room{
    private Date startDate;
    private Date endDate;

    private double pricePNight;
    private static int reservationNum = 100001;
    private int resID;

    private Person guest;

    public Reservation(Date startDate, Date endDate, double pricePNight, Person guest)
    {
        super(pricePNight);
        this.startDate = startDate;
        this.endDate = endDate;
        // this.pricePNight = pricePNight;
        this.guest = guest;

        this.resID = ++reservationNum;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public int getResNum(){
        return this.resID;
    }

    public boolean isAvailable(Date aVstartDate, Date aVendDate){
        if(this.endDate.before(aVstartDate) && this.startDate.after(aVendDate)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Reservation Number: " + this.getResNum() + "\nFrom: " + this.getStartDate() + "To: " + this.getEndDate() + "\nGuest: " + this.guest + "\n$" + this.pricePNight + "per night\n";
    }



}
