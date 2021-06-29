import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;



public class ComboLock {
    //Stuff Up Above
    private boolean dev = false;
    private boolean animate = true;
    private int[] Code;
    private boolean[] Clicks;
    private int TurnsToReset;
    private char Direction;
    private int TickCircle;
    private boolean workingLock;
    private String[] ComboLockFace;
    private Canvas canvas = new Canvas(this);
    //Stuff Up Above
    //Public
    public static void main(String[] args){
        ComboLock C = new ComboLock(5, 10, 3);
        C.update();
        C.tryToUnlockLockLoop();
        //C.buildComboLockFace();
        //C.turnRight(5);
        //C.printTick();
        //C.turnLeft(40);
        //C.printTick();
        //C.turnLeft(35);
        //C.printTick();
        //C.turnRight(33);
        //C.printTick();
    }
    public void tryToUnlockLockLoop(){
        Scanner scn = new Scanner(System.in);
        help();
        while (true){
            update();
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
        canvas.moveArm(0);
        TurnsToReset = 3;
        Clicks = new boolean[]{false, false, false, false, false};
        Direction = 'R';
    }
    public void lockLock() {
        Clicks = new boolean[]{false, false, false, false, false};
        Direction = 'R';
        TurnsToReset = 0;
    }
    public void turnLeft(int ticks) {
        if (!workingLock) badLockMsg();
        if (Direction != 'L' && ticks != 0 || TurnsToReset < 3) lockLock();
        int tempOld = TickCircle;

        if (animate){
            for (int i = 0; i < ticks; i++){
                TickCircle--;
                if (TickCircle == -1)
                    TickCircle = 39;
                update();
            }
        }
        else {
            TickCircle -= ticks;
            while (TickCircle < 0) TickCircle += 40;
        }
        if (Clicks[0]){
            boolean bitch = checkIfPassed(tempOld, Code[0], ticks, TickCircle, 'L');
            boolean bitch2 = checkIfPassed(tempOld, Code[1], ticks, TickCircle, 'L');
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
        if (animate){
            for (int i = 0; i < ticks; i++){
                TickCircle++;
                if (TickCircle == 40)
                    TickCircle = 0;
                update();
            }
        }
        else {
            TickCircle += ticks;
            while (TickCircle > 39) TickCircle -= 40;
        }
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
    public void printTick(){
        System.out.println("Current Tick: " + TickCircle);
        update();
    }
    public void fixLock(int secret1, int secret2, int secret3){
        this.Code = new int[]{secret1, secret2, secret3};
        checkIfWorkingLock();
    }
    public int getTickPosition(){return TickCircle;}
    public int[] getCode(){
        System.out.println("Don't Cheat That is Disgusting, You Should be Ashamed");
        return new int[]{-1, -1, -1};
    }
    public boolean[] getClicks(){
        System.out.println("Don't Cheat That is Disgusting, You Should be Ashamed");
        return new boolean[]{false, false, false, false, false};
    }
    public void update(){
        canvas.update();
    }
    public boolean open(){return open(true);}
    //Public

    //Private
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

    private static void sleep(int millis){
        try{ Thread.sleep(millis); }
        catch(Exception InterruptedException){ System.exit(0); }
    }

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

            case "dev true":
                dev = true;
                canvas.dev = true;
                break;

            case "dev false": case "dev":
                dev = false;
                canvas.dev = false;
                break;

            default:
                int num = getNumber(str);
                char chr = getChar(str);
                if (chr == 'L') turnLeft(num);
                else if (chr == 'R') turnRight(num);
                break;
        }
    }

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
        if (dev) System.out.println("To Disable Dev Mode enter   <DEV>   " +
                "\n\nYou Are also In Breach of Some law or another by enabling this setting. Shame on you. tsk tsk tsk >:[");
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
    private char getChar(String str){
        boolean foundNumber = false;
        int num = 0;
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

    private boolean checkIfPassed(int start, int numCheck, int change, int end, char dir){
        if (change >= 40) return true;

        if (dir == 'L') return ((start < end && ((0 <= numCheck && numCheck <= start) || end <= numCheck && numCheck < 40)) || (end <= numCheck && numCheck <= start));
        else if (dir == 'R') return ((end < start) && ((0 <= numCheck && numCheck <= end || start <= numCheck && numCheck <40)) || (start <= numCheck && numCheck <= end));

        return false;
    }

    private void badLockMsg(){
        System.out.println("This lock is not working (It does not have a combination entered into it.");
    }
    private void checkIfWorkingLock(){
        for (int num: Code){
            if (!(0 <= num && num <= 39)) {
                System.out.println("This Combination Lock does not Work");
                workingLock = false;
            }
            else workingLock = true;
        }
    }
    // arg So much more difficult then python to get working.
    // I know everything below this looks nasty but in my defence I am used to pythons tkinter and pygame So I am not used to any of this.
    private static class Canvas extends java.awt.Canvas {
        private boolean dev;
        private int[] coordinates;
        private int[] circleDimensions = {0, 0, 300, 300};
        private final int padding = 50;
        private final int[] importantPoint;
        private final ComboLock CL;
        private Panel panel;
        private int[] skip = {0, 10};

        public Canvas(ComboLock CL){
            this.dev = CL.dev;
            this.CL = CL;

            JFrame frame = new JFrame();

            frame.setLayout(new BorderLayout());
            if (this.dev) {
                frame.setSize((17 + circleDimensions[2] + padding) * 2, 40 + circleDimensions[3] + padding);  // 17 and 40 are something JFrame likes adding offsetting everything idkY.
                frame.setTitle("Combination Lock:  Dev Mode Enabled");
            }
            else {
                frame.setSize(17 + circleDimensions[2] + padding, 40 + circleDimensions[3] + padding);  // 17 and 40 are something JFrame likes adding offsetting everything idkY.
                frame.setTitle("Combination Lock");
            }
            frame.add("Center", this);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            this.panel = new Panel(this);
            frame.setContentPane(panel);

            importantPoint = new int[]{(circleDimensions[2] + circleDimensions[0]) / 2 + padding/2, (circleDimensions[2] + circleDimensions[0]) / 2 + padding/2};
            circleDimensions = new int[] {circleDimensions[0] + padding / 2, circleDimensions[1] + padding / 2, 300, 300};
            this.coordinates = new int[]{importantPoint[0], importantPoint[1], 200, 50};


            moveArm(0);
        }

        public void update(){
            moveArm(CL.TickCircle);
            if (skip[0] == skip[1]) {
                //moveArm(CL.TickCircle);
                panel.update(panel.getGraphics());
                sleep(1000 / 60);
            }
            else skip[0]++;
        }

        public void moveArm(int num){
            coordinates[2] = importantPoint[0] + (int) (Math.cos(Math.toRadians(90 - 9*num)) * (((double) circleDimensions[3] / 2)));;
            coordinates[3] = (circleDimensions[2]+padding) - (importantPoint[1] + (int) (Math.sin(Math.toRadians(90 - 9*num)) * (((double) circleDimensions[3] / 2))));
        }
    }

    private static class Panel extends JPanel{
        private Canvas canvas;

        public void paintComponent(Graphics g){
                super.paintComponent(g);
                CircleObject(g);
                CircleObject(g);
                CircleObject(g);
                LineObject(g);
                if (canvas.dev) devObj(g);
                sleep(10);

        }

        private void CircleObject(Graphics g){
            g.drawOval(canvas.circleDimensions[0], canvas.circleDimensions[1], canvas.circleDimensions[2], canvas.circleDimensions[2]);
            g.setColor(Color.black);
            g.fillOval(canvas.importantPoint[0]-5, canvas.importantPoint[1]-5, 10, 10);
            g.drawString("0", 172, 22);
            g.drawString("5", 284, 69);
            g.drawString("10", 328, 180);
            g.drawString("15", 282, 293);
            g.drawString("20", 168, 340);
            g.drawString("25", 55, 293);
            g.drawString("30", 10, 175);
            g.drawString("35", 55, 67);
        }

        private void devObj(Graphics g){
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.drawString("Developer Mode is ENABLED, if you are not a", 375, 15);
            g.drawString("Developer please DISABLE this feature", 375, 30);
            g.drawString("Does Lock have a Valid Combination: " + canvas.CL.workingLock, 375, 75);
            g.drawString("Combination: [" + canvas.CL.Code[0] + ", " + canvas.CL.Code[1] + ", " + canvas.CL.Code[2] + "]", 375, 90);
            g.drawString("TickCircle: " + canvas.CL.TickCircle, 375, 105);
            g.drawString("Reset Turns Made: " + canvas.CL.TurnsToReset, 375, 120);
            g.drawString("Clicks: " + Arrays.toString(canvas.CL.Clicks), 375, 135);
            g.drawString("Is Unlocked?: " + canvas.CL.open(false), 375, 150);
        }

        private void LineObject(Graphics g){ g.drawLine(canvas.coordinates[0], canvas.coordinates[1], canvas.coordinates[2], canvas.coordinates[3]); }


        public Panel(Canvas C){
            this.canvas = C;
        }
    }
}