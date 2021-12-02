import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class Airport {
    private Queue<String> TakeOff;
    private Queue<String> Landing;
    private ArrayList<String> log;


    public Airport(){
        TakeOff = new LinkedList<>();
        Landing = new LinkedList<>();
        log = new ArrayList<>();
    }

    public void addTakeOff(String newTakeOff){
        TakeOff.add(newTakeOff);
    }
    public void addLanding(String newLanding){
        Landing.add(newLanding);
    }

    public String handleNextAction(){
        if (TakeOff.size() == 0 && Landing.size() == 0) return "No plane is waiting to land or take-off.";
        String str;
        if (Landing.isEmpty()) {
            str = TakeOff.poll();
            if (str != null) {
                log.add("Flight " + str + " taken-off.");
            }
            return "Flight " + str + " is Taking off.";
        }
        else {
            str = Landing.poll();
            if (str != null) {
                log.add("Flight " + str + " Landed.");
            }
            return "Flight " + str + " is Landing.";
        }
    }

    public String waitingPlanes(){
        if (TakeOff.size() == 0 && Landing.size() == 0) return "No plane is in the landing and take-off queues.";
        String str = "Planes waiting for take-off\n---------------------------\n";
        Object[] ptr = TakeOff.toArray();
        Object[] ptr2 = Landing.toArray();
        for(Object Str: ptr2){
            str = str.concat(Str.toString() + "\n");
        }
        for(Object Str: ptr){
            str = str.concat(Str.toString() + "\n");
        }
        return str;
    }

    public String log(){
        if (log.size() == 0) return "No activity exists";
        String Str = "List of the landing/take-off activities\n---------------------------------------\n";
        for (String str: log){
            Str = Str.concat(str + "\n");
        }
        return Str;
    }
}
