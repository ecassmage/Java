import java.util.Scanner;

public class ComboLock {
    //Stuff Up Above
    private int[] Code;  // This Holds The three combination numbers
    private boolean[] Clicks; // This holds fivd booleans, for checking the combination. I set it up like my combination which needs to turn right then turn left fully then turn left to second number then turn right to third. each of these needs a true false and I for some reason added a fifth not quite sure
    private int TurnsToReset;  // This keeps track of how many turns have been made to reset, my combination lock recommends three so that what I went with.
    private char Direction; // This keeps track of current direction. so left and right.
    private int TickCircle; // This gives the current number on the circle
    private boolean workingLock;  // This is to make sure the user does not input a bad lock. so if the user tries 55 0 5 it will not work and this will be false.
    //Stuff Up Above
    //Public
    public static void main(String[] args){
        ComboLock C = new ComboLock(5, 10, 3);
        C.tryToUnlockLockLoop();
    }
    public void tryToUnlockLockLoop(){
        reset();
        Scanner scn = new Scanner(System.in);
        //help();
        System.out.println("This can be ignored I wasn't sure if this itself was necessary or not, but it kept asking for user in the assignment so I am leaving it in. Its code is shoved to the bottom of the Class.");
        while (true){
            System.out.println("Please Enter SomeThing Either: (open, reset l, r, quit, exit, enter new combination, check locks, help, showface)"); // This is New. Just Though I would say that.
            String grr = scn.nextLine();
            grr = grr.toLowerCase();
            inputSwitch(grr);
        }
    }
    public ComboLock(int secret1, int secret2, int secret3) {
        this.Code = new int[]{secret1, secret2, secret3};
        Clicks = new boolean[]{false, false, false, false, false};
        this.TickCircle = 0;
        checkIfWorkingLock();
        Direction = 'R';
        TurnsToReset = 3;
    }
    public void reset() {
        TickCircle = 0;
        TurnsToReset = 3;
        Clicks = new boolean[]{false, false, false, false, false};
        Direction = 'R';
    }
    public void turnLeft(int ticks) {
        if (!workingLock) badLockMsg();
        if (Direction != 'L' && ticks != 0 || TurnsToReset < 3) lockLock();
        int tempOld = TickCircle;
        TickCircle -= ticks;
        while (TickCircle < 0) TickCircle += 40;
        if (Clicks[0]){
            if (!Clicks[1]) {
                if (checkIfPassed(tempOld, Code[0], ticks, TickCircle, 'L')) {
                    Clicks[1] = true;
                    if (TickCircle == Code[1]) {
                        Direction = 'R';
                        Clicks[2] = true;
                    }
                }
            }
            else if (checkIfPassed(tempOld, Code[1], ticks, TickCircle, 'L')) {
                if (TickCircle == Code[1]) {
                    Direction = 'R';
                    Clicks[2] = true;
                }
                else {
                    lockLock();
                }
            }
        }
    }
    public void turnRight(int ticks) {
        if (!workingLock) badLockMsg();
        if (Direction != 'R' && ticks != 0) lockLock();
        if (TurnsToReset < 3 && TickCircle + ticks >= 40) TurnsToReset += ((TickCircle + ticks) / 40);
        int tempOld = TickCircle;
        TickCircle += ticks;
        while (TickCircle > 39) TickCircle -= 40;
        if (!Clicks[0]){
            if (checkIfPassed(tempOld, Code[0], ticks, TickCircle, 'R')){
                if (TickCircle == Code[0]){
                    Direction = 'L';
                    Clicks[0] = true;
                }
            }
        }
        else if (!Clicks[3]){
            if (checkIfPassed(tempOld, Code[2], ticks, TickCircle, 'R')){
                if (TickCircle == Code[2]){
                    Clicks[3] = true;
                }
            }
        }
    }
    public boolean open(){return open(true);}
    private boolean open(boolean showMessage) {
        if (!workingLock) badLockMsg();
        if (Clicks[4] || (Clicks[0] && Clicks[1] && Clicks[2] && Clicks[3])){
            if (showMessage) {
                Clicks[4] = true;
                System.out.println("**CLICK** Lock Unlocked");
            }
            return true;
        }
        if (showMessage) System.out.println("**SHAKE SHAKE SHAKE** Lock Still Locked");
        return false;
    }
    // This is a reset that doesn't allow continuation until you go around clockwise 3 times.
    public void lockLock() {
        Clicks = new boolean[]{false, false, false, false, false};
        Direction = 'R';
        TurnsToReset = 0;
    }
    // Prints the Current Position of the Lock.
    public void printTick(){ System.out.println("Current Tick: " + TickCircle); }
    // This is to fix the Lock should user have inputted a bad code to begin with.
    public void fixLock(int secret1, int secret2, int secret3){
        this.Code = new int[]{secret1, secret2, secret3};
        checkIfWorkingLock();
    }
    //  Gets the Current Position of the Lock
    public int getTickPosition(){return TickCircle;}
    //Public

    //Private
    private void checkIfWorkingLock(){
        for (int num: Code){
            if (!(0 <= num && num <= 39)) {
                System.out.println("This Combination Lock does not Work");
                workingLock = false;
            }
            else workingLock = true;
        }
    }
    private boolean checkIfPassed(int start, int numCheck, int change, int end, char dir){
        if (change >= 40) return true;

        if (dir == 'L') return ((start < end && ((0 <= numCheck && numCheck <= start) || end <= numCheck && numCheck < 40)) || (end <= numCheck && numCheck <= start));
        else if (dir == 'R') return ((end < start) && ((0 <= numCheck && numCheck <= end || start <= numCheck && numCheck <40)) || (start <= numCheck && numCheck <= end));

        return false;
    }
    // This manages inputs by the user you can ignore this if you want.
    private void inputSwitch(String str){
        switch(str){
            case "open":
                open();
                break;

            case "reset":
                reset();
                break;

            case "l":
                turnLeft(1);
                break;

            case "r":
                turnRight(1);
                break;

            case "quit": case "exit":
                System.out.println("Thank you for quitting this lock");
                System.exit(0);
                break;

            case "enter new combination": case "enternewcombination": case "enc":
                newCombination();
                break;

            case "check locks": case "checklocks":
                checkIfWorkingLock();
                break;

            case "help":
                help();
                break;

            case "showface":
                System.out.println("The Combo Lock is currently pointing to: " + getTickPosition());
                break;

            default:
                int num = getNumber(str);
                char chr = getChar(str);
                if (chr == 'L') turnLeft(num);
                else if (chr == 'R') turnRight(num);
                break;
        }
    }

    private char getChar(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'L' || str.charAt(i) == 'l'){
                return 'L';
            }
            else if (str.charAt(i) == 'R' || str.charAt(i) == 'r'){
                return 'R';
            }
        }
        return ' ';
    }

    private int getNumber(String str){
        boolean foundNumber = false;
        int num = 0;
        for (int i = 0; i < str.length(); i++){
            if (48 <= str.charAt(i) && str.charAt(i) < 58){
                num = (num * 10) + (str.charAt(i) - 48);
                foundNumber = true;
            }
            else if (foundNumber) return num;
        }
        return num;
    }

    // This is Just for explaining stuff
    private void help(){
        System.out.println("Hello and welcome to the grand game of opening a gym lock!!!\n");

        System.out.println("\tTo Unlock this Combination you need to first have it set by either reseting the lock or turning it fully around three times. Default is set properly.");
        System.out.println("\tNext step is to turn the lock ClockWise until you hit the first combination number.");
        System.out.println("\tNext Step is to turn the lock Counter ClockWise until you reach the complete a full rotation to relative to the first number");
        System.out.println("\tNext Step is to turn the lock Counter ClockWise until you reach the second Combination number");
        System.out.println("\tNext Step is to turn the lock ClockWise until you hit the final combination number.");
        System.out.println("\tLast Step is to attempt to open the lock. IF and only IF you followed these instructions properly will the lock unlock, else it won't.\n");

        System.out.println("Remember that this program is not case sensitive so OpEn is the same as oPeN, open and OPEN");
        System.out.println("The <> surrounding the codes are not necessary.");
        System.out.println("To Turn the Lock Clockwise there are 2 way: " +
                "\n\tFirst way is to input just an   <R>,   This will turn the lock ClockWise by 1 position" +
                "\n\tSecond way is to input an   <R + number>   (The < + > is not necessary), This will turn the lock ClockWise by the number you inputted");
        System.out.println("To Turn the Lock Counter-Clockwise there are 2 way: " +
                "\n\tFirst way is to input just an   <L>,   This will turn the lock Counter-Clockwise by 1 position" +
                "\n\tSecond way is to input an   <L + number>   (The < + > is not necessary), This will turn the lock Counter-Clockwise by the number you inputted ");
        System.out.println("To Attempt to open the lock you need to input the word   <OPEN>   this will return a message saying either the lock unlocked or it didn't");
        System.out.println("If you want to reset the lock you may input   <RESET>.   This will reset all the Combination Disc, Combination Dial, Combination Cam, Locking Latch and Shackle Collar");
        System.out.println("To Enter a new Combination there are 3 ways: " +
                "\n\tFirst way is to input   <ENTER NEW COMBINATION>   " +
                "\n\tSecond way is to input   <ENTERNEWCOMBINATION>   " +
                "\n\tThird way is to input   <ENC>   " +
                "\n\t\tThese will then allow you to enter on a new line the new combination, just enter like this 10 15 20. The numbers will need to be between 0-39 or the lock will stop functioning");
        System.out.println("If you break your lock you may attempt to enter a new lock combination and should it be good will fix the lock, to check the locks state you may enter 2 different codes" +
                "\n\tFirst code is   <CHECK LOCK>   " +
                "\n\tSecond code is   <CHECKLOCK>   ");
        System.out.println("To Quit this process you may enter one of two different codes" +
                "\n\tFirst code is   <QUIT>   " +
                "\n\tSecond code is   <EXIT>   ");
        System.out.println("If you wish to review this help page you can enter:   <HELP>   ");
        System.out.println();
        System.out.println();
    }

    private void newCombination(){
        if (!open(false)){
            System.out.println("You May Not change the Combination if the Lock is still Locked You Cheat");
            System.out.println("If you Wish to change it anyways you may call my number and I will ignore it.");
            return;
        }
        Scanner scn = new Scanner(System.in);
        Code = new int[]{scn.nextInt(), scn.nextInt(), scn.nextInt()};
        Clicks = new boolean[]{false, false, false, false, false};
        checkIfWorkingLock();
        Direction = 'R';
        TurnsToReset = 0;
    }

    private void badLockMsg(){
        System.out.println("This lock is not working (It does not have a combination entered into it.");
    }

}