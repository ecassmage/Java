import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args){
        Date D = new Date(2010, Calendar.MAY, 15);
        int date = D.getDate();
        int date2 = D.getYear();
        int date3 = D.getMonth();
        int date4 = D.getDay();
        Instant I = D.toInstant();
    }

}
