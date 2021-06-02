package Problem2;
public class Microwave {

    private double timer  = 0 ; 
    private String powerLvl = "low" ; 
    private String status ;
    public static void main(String[] args) {
        System.out.println("Hello World");
        TestMicrowave micro = new TestMicrowave();
    }
    public Microwave(double time , String power , String status){
        this.timer = time ; 
        this.powerLvl = power ; 
        this.status = status ; 

    }

    public void setTime(){ // this method increment the timer by 30 sec 
        timer = timer + 30 ;
    }

    public double getTime(){ // tbhis method return the time in seconds 
        return timer ; 
    }

    public void printTime( double time ){ // this method prints the time in minutes and seconds 
        double minutes = timer / 60 ;  
        double seconds = timer % 60 ; 
        System.out.print( minutes+":"+seconds);
    }

    //this method is designed in a way which can also work if we had user interface
    public void setPowerLvl(String input){
        if (input == "low" || input == "med" || input == "high" || input == "Low" || input == "Med" || input == "High" ) {
            powerLvl = input ; 
        }
        else { 
            System.out.println("Enter a vaid power option!\n|Low|Med|High|\n"); 
            setPowerLvl(input);
        }
    }

    //returns the power level
    public String getPowerLvl(){
        return powerLvl ; 
    }

    //promt a messege including the time which has been set and also the power level chosen by user
    public void start() {
        System.out.print("Cooking for "); 
        printTime(getTime());
        System.out.println(" at "+this.getPowerLvl()+ " level!");
        System.out.println("");  
        status = "ON" ; 
    }

    //stops the cooking  \\ setting the status to off // prompting a messege \\
    public void stop() {
        System.out.println("Cooking stopped!");
        status = "OFF" ; 
        timer = 0 ; 
    }

    public String getStatus(){
        return status ; 
    }

    //resets the timer and the status and sets  the power lvl to the default value(low)
    public void reset(){
        timer = 0 ; 
        System.out.println("Timer has been set to" + this.getTime()); // displays the the status of the machine and also  print a prompt 
        status = "OFF" ; 
        System.out.println("Machine status = " + this.getStatus()); 
        powerLvl = "low" ; 
    }
}