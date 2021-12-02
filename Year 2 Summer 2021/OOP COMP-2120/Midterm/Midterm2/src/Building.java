import java.time.Year;

public class Building {
    private int numFloors;
    private Year yearConstructed;

    public Building(){
        this.numFloors = 1;
        this.yearConstructed = Year.now();
    }

    public Building(int numFloors, Year yearConstructed){
        this.numFloors = numFloors;
        this.yearConstructed = yearConstructed;
    }
}
