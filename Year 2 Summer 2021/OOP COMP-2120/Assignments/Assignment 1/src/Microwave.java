public class Microwave {
    private byte power;  // 0: Low, 1: Medium, 2: High
    private int time;
    private boolean On;
    private void print(String line){
        System.out.println(line);
    }
    public Microwave(){
        this.power = 0;
        this.time = 0;
        this.On = false;
    }

    public void button1(){
        time += 30;
    }

    public void button1(int num){
        if (num % 30 == 0) time = num;
        else print("Not a valid time allowed.");
    }

    public void button2(){
        // For the Easy People Out There
        if (power == 2) power = 0;
        else power += 1;
    }

    public void button2(byte newLevel){
        // Bytes, for the Bytey People Out There
        if (0 <= newLevel && newLevel <= 2) power = newLevel;
        else print("This is not a valid power Level");
    }

    public void button2(String newLevel){
        //Strings for the Stringy People Out There
        switch (newLevel){
            case "Low":
                power = 0;
                break;
            case "Medium":
                power = 1;
                break;
            case "High":
                power = 2;
                break;
            default:
                print("This is not a valid power Level");
        }
    }

    public void button3(){
        On = false;
        print("Cooking Stopped");
    }

    public void button4(){
        power = 0;
        time = 0;
        On = false;
    }

    public void button5(){
        String[] cheaty = {"Low", "Medium", "High"};  // hehehe why do it this way, dunno.
        On = true;
        print("Cooking for " + time +" seconds at level " + cheaty[power]);
    }

    public int getTime(){
        return time;
    }
    public boolean getOn(){
        return On;
    }
    public String getPower(){
        String[] cheaty = {"Low", "Medium", "High"};  // hehehe why do it this way, dunno.
        return cheaty[power];
    }

}
