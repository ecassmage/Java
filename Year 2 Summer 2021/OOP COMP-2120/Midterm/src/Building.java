import java.util.Calendar;

public class Building {
    private int yearOfBuilt;
    private int numberOfFloors;

    public static void main(String[] args){
        Building B = new Building(10);
    }

    public Building(){
        this(1);
    }
    public Building(int numberOfFloors){
        this.yearOfBuilt = Calendar.getInstance().get(Calendar.YEAR);
        this.numberOfFloors = numberOfFloors;
    }
    public Building(int yearOfBuilt, int numberOfFloors){
        this.yearOfBuilt = yearOfBuilt;
        this.numberOfFloors = numberOfFloors;
    }
}
