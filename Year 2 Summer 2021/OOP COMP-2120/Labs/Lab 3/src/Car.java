import java.io.IOException;
// I am running the Scripts through IntelliJ and the Video Through NoMachine Because NoMachine could get both the Blocks and Terminal to work correctly (probably because its Linux).
// But NoMachine Lags For me Like Crazy so I don't want to do everything in it. The Script also had a little more added since I wanted to block the printCar() from running on all but the
// two calls since it would take a lot of space bloating the script file larger then it needs to be.
/**
 * Car Class Containing methods for a Car.
 *
 * <p>
 *     This is a Class for a Car which contains methods needed for a car,
 *     like: {@link #accelerate(int)}, {@link #decelerate(int)}, {@link #turnOn()}, {@link #turnOff()}, {@link #stop()}, {@link #drive(double)},
 * </p>
 *
 * @author Evan Morrison
 * @version 1.1.10
 * @since 1.0
 */
public class Car {

    private static boolean Dev = false;  // This May cause some weird stuff to appear if not using the correct Terminal
    private static boolean disablePrinting = false;
    private String Make;
    private String Model;
    private int Year;
    private double Price;
    private int Speed;
    private int MaxSpeed;
    private boolean[] CarStates;  // {isOn, isMoving}
    private double FuelEfficiency;
    private double[] GasTank;  // {GasCurrentLevel, MaxGasLevel}
    private double[] Position;  // {North/West, East/West}
    private char Direction;

    /**
     * PUBLIC STATIC VOID MAIN[sTRING() ARGS] BLARG ;P
     * @param args This is still something that holds idk. Probably extra arguments like in C, but I dunno.
     */
    public static void main(String[] args){
        Car newCar = new Car("Hello", "Mello", 2001, 12000.12, 10, 0);
        Car newCar2 = new Car("Hello", "Mello");
        newCar2 = new Car("Hello", "Mello", 2001, 12000.12);newCar2.setPrice(100);
        newCar2 = new Car(10, 0);newCar2.setPrice(100);
        newCar2 = new Car(2001);newCar2.setPrice(100);
        newCar2 = new Car(12000.12);newCar2.setPrice(100);
        newCar2 = new Car();newCar2.setPrice(100);
        newCar.setMaxSpeed(175);
        newCar.accelerate(50);
        newCar.addGas(50);
        newCar.printCar();
        sleep(1000);
        newCar.printCar();
        sleep(1000);
        newCar.printCar();
    }
    //Constructors

    /**
     * Car constructor
     * <p>
     *     Constructs the Car. This is the Final Constructor that all the other constructors feed into.
     * </p>
     * @param make  Takes a String for the make of the Car.
     * @param model Takes a String for the model of the Car.
     * @param year Takes an int for the year of the Car.
     * @param price Takes a double for the price of the Car.
     * @param fuelEfficiency Takes a double for the fuel efficiency of the Car.
     * @param gasTank Takes a double for the fuel starting out in the gas tank of the Car.
     * @param maxGasTank Takes a double for the size of the gas tank in the Car.
     */
    public Car(String make, String model, int year, double price, double fuelEfficiency, double gasTank, double maxGasTank){
        this.Make = make;
        this.Model = model;
        this.Year = year;
        this.Price = price;
        this.CarStates = new boolean[]{false, false};
        this.FuelEfficiency = fuelEfficiency;
        this.GasTank = new double[]{gasTank, maxGasTank};
        this.Position = new double[]{0, 0};
        this.Direction = 'N';
    }

    /**
     * Car constructor
     * @param make  Takes a String for the make of the Car.
     * @param model Takes a String for the model of the Car.
     * @param year Takes an int for the year of the Car.
     * @param price Takes a double for the price of the Car.
     * @param fuelEfficiency Takes a double for the fuel efficiency of the Car.
     * @param gasTank Takes a double for the fuel starting out in the gas tank of the Car.
     */
    public Car(String make, String model, int year, double price, double fuelEfficiency, double gasTank)    { this(make, model, year, price, fuelEfficiency, gasTank, 100); }

    /**
     * Car constructor
     * @param make  Takes a String for the make of the Car.
     * @param model Takes a String for the model of the Car.
     * @param year Takes an int for the year of the Car.
     * @param price Takes a double for the price of the Car.
     */
    public Car(String make, String model, int year, double price)                                           { this(make, model, year, price, 1, 10, 100); }

    /**
     * Car constructor
     * @param make  Takes a String for the make of the Car.
     * @param model Takes a String for the model of the Car.
     */
    public Car(String make, String model)                                                                   { this(make, model, 0, 0, 1, 10, 100); }

    /**
     * Car constructor
     * @param fuelEfficiency Takes a double for the fuel efficiency of the Car.
     * @param gasTank Takes a double for the fuel starting out in the gas tank of the Car.
     */
    public Car(double fuelEfficiency, double gasTank)                                                       { this(null, null, 0, 0, fuelEfficiency, gasTank, 100); }

    /**
     * Car constructor
     * @param year Takes an int for the year of the Car.
     */
    public Car(int year)                                                                                    { this(null, null, year, 0, 1, 10, 100); }
    /**
     * Car constructor
     * @param price Takes a double for the price of the Car.
     */
    public Car(double price)                                                                                { this(null, null, 0, price, 1, 10, 100); }
    /**
     * Car constructor
     */
    public Car()                                                                                            { this(null, null, 0, 0, 1, 10, 100); }
    //Constructors

    // I DON"T WANNA!!!!!!!!!!!!!

    // Public Stuff
        //Drive Stuff

    /**
     * Drives the Car Forward
     * <p>
     *     Drive the Car Forward in the direction that the car is pointing. This Direction can be changed with {@link #turnLeft()} and {@link #turnRight()}
     * </p>
     * @param distance Takes a double for the distance the car will travel.
     */
    public void drive(double distance){ drive(distance, 1); }

    /**
     * Drives the Car Forward
     * <p>
     *     Drive the Car Forward in the direction that the car is pointing. This Direction can be changed with {@link #turnLeft()} and {@link #turnRight()}
     *     This method relies on the speed the car is currently going to determine distance covered during this time.
     * </p>
     * @param seconds Takes an int for the time the car will travel.
     */
    public void drive(int seconds){ drive(((double) getSpeed() / 60) * ((double) seconds / 60), seconds);}

    /**
     * Drives the Car Forward
     * <p>
     *     Drive the Car Forward in the direction that the car is pointing. This Direction can be changed with {@link #turnLeft()} and {@link #turnRight()}
     * </p>
     * @param distance Takes a double for the distance the car will travel.
     * @param seconds Takes an int for the time the car will travel.
     */
    public void drive(double distance, int seconds){
        if (!getIsOn() || outOfFuel()) return;
        for (int i = 0; i < seconds; i++){
            if (!getIsMoving()) return;
            if (getGasInTank() - (distance * getFuelEfficiency()) <= 0){
                distanceChange(getGasInTank() / getFuelEfficiency());
            }
            else{
                distanceChange(distance / seconds);
            }
            if (useGasFromDriving(distance / seconds)){
                outOfFuel();
            }
            sleep(1000);
            printCar();
        }
    }
            //Turning Stuff

    /**
     * Turns The Car Left.
     */
    public void turnLeft(){
        if (!getIsOn()) return;
        switch(Direction){
            case 'N':
                Direction = 'W';
                break;
            case 'S':
                Direction = 'E';
                break;
            case 'E':
                Direction = 'N';
                break;
            case 'W':
                Direction = 'S';
                break;
        }
    }

    /**
     * Turns The Car Right.
     */
    public void turnRight(){
        if (!getIsOn()) return;
        switch(Direction){
            case 'N':
                Direction = 'E';
                break;
            case 'S':
                Direction = 'W';
                break;
            case 'E':
                Direction = 'S';
                break;
            case 'W':
                Direction = 'N';
                break;
        }
    }
            //Turning Stuff
        //Drive Stuff

        //Setters

    /**
     * needs a String for the Make of the Car.
     * @param make a String holding the Make of the Car.
     */
    public void setMake(String make){Make = make;}

    /**
     * Takes a String for the Model of the Car.
     * @param model a String holding the Model of the Car.
     */
    public void setModel(String model){Model = model;}

    /**
     * Takes an int for the Year the Car was made.
     * @param year holds an int for Year car was Made.
     */
    public void setYear(int year){Year = year;}

    /**
     * Sets Price of car.
     * @param price Takes a floating-point for price.
     */
    public void setPrice(double price){Price = price;}

    /**
     * This sets MaxSpeed of Car.
     * @param speedMax Takes an Integer for Maximum Speed.
     */
    public void setMaxSpeed(int speedMax){MaxSpeed = speedMax;}

    /**
     * Takes Integer value for Acceleration
     * @param acceleration Takes Integer value for acceleration of Car.
     */
    public void accelerate(int acceleration){Speed += acceleration; isMoving();}

    /**
     * Takes Integer value for Deceleration.
     * @param deceleration Takes Integer value for Deceleration of Car.
     */
    public void decelerate(int deceleration){Speed -= deceleration; isMoving();}

    /**
     * Turns Car On.
     */
    public void turnOn(){CarStates[0] = true;}

    /**
     * Turns Car Off.
     */
    public void turnOff(){CarStates[0] = false;}

    /**
     * Sets the Car to start
     * <p>
     *     Can Still start the Car even if it is already started, just won't do anything useful.
     *     This sets the isMoving Variable.
     * </p>
     */
    public void start(){CarStates[1] = true;}

    /**
     * Sets the Car to stop
     * <p>
     *     If the Car is moving when this is called then the Car will {@link #decelerate(int)} to 0.
     *     This sets the isMoving Variable.
     * </p>
     */
    public void stop(){CarStates[1] = false; decelerate(Speed);}

    /**
     * Sets the Maximum Gas Tank Size.
     * @param gasTankSize Takes a double for the size of Gas Tank.
     */
    public void setMaxGasTank(double gasTankSize){ GasTank[1] = gasTankSize; }

    /**
     * Takes the amount of gas you want to add to the tank.
     * @param gas double value of gas added to tank.
     */
    public void addGas(double gas){GasTank[0] += gas; if (GasTank[0] > GasTank[1]) GasTank[0] = GasTank[1];}

    /**
     * Takes the amount of gas you want to add to the tank.
     * @param gas double value of gas added to tank.
     * @param seconds amount of time it takes to fill up tank in Seconds.
     */
    public void addGas(double gas, int seconds){
        double GasTankTrue = GasTank[0] + gas;
        for (int i = 0; i < seconds; i++){
            if (GasTank[0] + (gas / seconds) > GasTank[1]) {
                GasTank[0] = GasTank[1];
                printCar();
                return;
            }
            GasTank[0] += gas / seconds;
            printCar();
            sleep(1000);
        }
        GasTank[0] = GasTankTrue; // to avoid as much floating-point rounding error as possible
        printCar();
    }

    /**
     * Sets the Fuel Efficiency of Car
     * @param fuelEfficiency Takes a double as new Fuel Efficiency value.
     */
    public void setFuelEfficiency(double fuelEfficiency){ FuelEfficiency = fuelEfficiency; }
        //Setters

        //Getters

    /**
     * Gets the Make of the Car.
     * @return Returns a String containing the Make.
     */
    public String getMake(){return Make;}

    /**
     * Gets the Model of the Car.
     * @return Returns a String containing the Model.
     */
    public String getModel(){return Model;}

    /**
     * Gets the Year the Car was made.
     * @return Returns an Integer for the year the car was made.
     */
    public int getYear(){return Year;}

    /**
     * Gets price of the car.
     * @return returns price of the car as a double.
     */
    public double getPrice(){return Price;}

    /**
     * gets current speed of car
     * @return returns current speed of car as int
     */
    public int getSpeed(){return Speed;}

    /**
     * gets Max Speed of car
     * @return Returns max speed of car as int
     */
    public int getMaxSpeed(){return MaxSpeed;}

    /**
     * gets is on value
     * <p>
     *     will return true if the car is turned on and will return false if the car is not turned on.
     * </p>
     * @return returns boolean of if on or not
     */
    public boolean getIsOn(){return CarStates[0];}

    /**
     * gets if car is moving
     * <p>
     *     Will return true if the car is moving and will return false if the car is not moving.
     * </p>
     * @return returns boolean of if moving or not
     */
    public boolean getIsMoving(){return CarStates[1];}

    /**
     * gets the Fuel efficiency of car
     * <p>
     *     formatted in L/km form, can not be formatted any other way.
     * </p>
     * @return returns fuel efficiency of car as double
     */
    public double getFuelEfficiency(){ return FuelEfficiency; }

    /**
     * gets gas remaining in tank
     * @return returns get remaining is tank as double
     */
    public double getGasInTank(){ return GasTank[0]; }

    /**
     * Gets tank size
     * <p>
     *     gets tank size in Litres.
     * </p>
     * @return Returns tank size as double.
     */
    public double getGasTankSize(){ return GasTank[1]; }
        //Getters

    /**
     * Prints a Copy of the Car
     * <p>
     *     There is also a private variable in the source code that can disable this to enable this no matter what pass false in the parameter
     * </p>
     */
    public void printCar(){printCar(disablePrinting);}

    /**
     * Prints a Copy of the Car
     * <p>
     *     There is also a private variable in the source code that can disable this to enable this no matter what pass false in the parameter
     * </p>
     * @param printCarBool Takes a boolean for printing a copy of the car or not.
     */
    public void printCar(boolean printCarBool){
        if (printCarBool) return;
        clearScreen();
        System.out.println("Make: " + getMake() + ", Model: " + getModel() + ", Year: " + getYear() + ", Price: $" + getPrice());

        System.out.print("Speedometer: ");
        meterBar(100, getSpeed(), getMaxSpeed(), "ZOOM ", new String[]{Integer.toString(getSpeed()) + " km/h", Integer.toString(getMaxSpeed()) + " km/h"});

        if (getIsOn()) System.out.println("Car is on"); else System.out.println("Car is off");

        if (getIsMoving()) System.out.println("Car is moving"); else System.out.println("Car is not moving");

        System.out.println("Fuel Efficiency: " + getFuelEfficiency() + " L/km");

        System.out.print("GasTank: ");
        meterBar(100, getGasInTank(), getGasTankSize(), "#", new String[]{"FE", "FF"});
        System.out.println("Total Gas In Tank = " + format(getGasInTank(), 2));

        if (Position[0] > 0) System.out.print(format(Position[0],2) + "km North");
        else if (Position[0] < 0) System.out.print(format(Math.abs(Position[0]), 2) + "km, South");

        if (Position[0] != 0 && Position[1] != 0) System.out.print(", ");

        if (Position[1] > 0) System.out.println(format(Position[1], 2) + "km East");
        else if (Position[1] < 0) System.out.println(format(Math.abs(Position[1]), 2) + "km West");
        else System.out.println();
        System.out.println("\n\n\n\n");
        finePrint();
    }
    //Public Stuff

    //Private Stuff
    private void meterBar(int totalBoxes, double blackBoxes, double whiteBoxes, String rect, String[] startEnd){

        long BB = Math.round(blackBoxes / whiteBoxes * totalBoxes);
        if (BB == 0 && blackBoxes > 0) BB = 1;
        else if (BB > totalBoxes) BB = totalBoxes;
        long WB = totalBoxes - BB;
        MeterBar(totalBoxes, BB, WB, rect, startEnd);
    }
    private void MeterBar(int totalBoxes, long blackBoxes, long whiteBoxes, String rect, String[] startEnd){
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println This is where I figured out how to add color to Console
        // The Coloring is only on when Dev is set to true. It will not work for all consoles so I would recommend not switching it on unless your console can show both █ and color.


        if (blackBoxes + whiteBoxes != totalBoxes){
            System.out.println("The Boxes do not Match up Correctly...");
            System.exit(0);
        }
        if (Dev){            //Black       //White       //Reset
            String[] codes = {"\u001B[30m", "\u001B[37m", "\u001B[0m"};
            rect = "█";
            System.out.print(startEnd[0] + "[" + codes[0]);
            for (int i = 0; i < blackBoxes; i++){ System.out.print(rect); }
            System.out.print(codes[1]);
            for (int i = 0; i < whiteBoxes; i++){ System.out.print(rect); }
            System.out.print(codes[2] + "]" + startEnd[1]);
        }
        else{
            System.out.print(startEnd[0] + "[");
            for (int i = 0; i < blackBoxes; i++){
                System.out.print(rect.charAt(i % rect.length()));
            }
            for (int i = 0; i < whiteBoxes; i++){ System.out.print(" "); }
            System.out.print("]" + startEnd[1]);
        }
        System.out.println();
    }

    private static void sleep(int millis){
        try{ Thread.sleep(millis); }
        catch(Exception InterruptedException){ System.exit(0); }
    }

    private void finePrint(){
        System.out.println(
                        "This car and all parts of it are owned by the Evan Morrison Cars Incorporated Inc Conglomerate MegaCorp(Trademark) (Copyright).\n" +
                        "Misuse of this Car for any reason is severely prohibited and will face serious consequences... Probably.\n" +
                        "If this car Runs out of Fuel while driving, Evan Morrison Cars incorporated inc Conglomerate MegaCorp(Trademark) (Copyright) is not Responsible.\n" +
                        "Evan Morrison Cars incorporated inc Conglomerate MegaCorp(Trademark) (Copyright) are also not responsible for any damages caused by driving this vehicle\n" +
                        "and any accidental explosions are not our fault. Any Similarities between names and other company products are purely coincidental and in no way copying.\n" +
                        "Should you break any of these rules, you will be liable for upwards of $100,000,000,000,000 in Canadian Dollars.\n" +
                        "As a side not this if run through a proper terminal should print some fancy stuff and wipe the terminal when a new car display is printed.\n" +
                        "This might not work depending on stuff like the console you are using to run this. \n" +
                        "\tNoMachine seems to work for terminal wiping and Dev mode, \n" +
                        "\tCygwin Seems to work for the terminal wiping\n" +
                        "\tCommand Prompt seems to also work for the terminal wiping\n" +
                        "\tThe IntelliJ IDE does not work for Terminal Wiping (Will make The Boxes appear) though using the terminal in IntelliJ for me worked in getting the terminal to Wipe (Boxes Don't Work), probably because it connected with another terminal like CMD\n" +
                        "\tBitvise I feel like would probably work since it connects to the same server as NoMachine but I never tested it so I am not sure about it.\n" +
                        "\n\n\n"
        );
    }

    private static void clearScreen(){
        // Not My own code but since this has literally nothing to do with the actual lab and was instead just something fun I wanted to do I felt like it was fine to use.
        //https://intellipaat.com/community/294/java-clear-the-console The link I found the code at. Windows stuff doesn't seem to wipe the Terminal with the flush and ansi code so I needed something else
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    private static double format(double number, int roundPoint){
        int num = 1;
        for (int i = 0; i < roundPoint; i++) num *= 10;
        return (double) Math.round(number * num) / num;
    }
    private boolean useGasFromDriving(double distance){
        GasTank[0] -= distance * getFuelEfficiency();
        return (GasTank[0] <= 0);
    }

    private boolean outOfFuel(){
        if (getGasInTank() <= 0) {
            System.out.println("You have run out of Fuel.");
            stop();
            return true;
        }
        return false;
    }

    /**
     * Private so Just Checks if Car is Moving and matches car speed.
     * I can Write Anything here and it will not be recorded through JavaDoc.
     * <p>
     *     This is stuff I really think is important and am not just writing
     *     because I am Bored!!!!.
     * </p>
     */
    private void isMoving(){
        if (!getIsOn()) {
            Speed = 0;
            CarStates[1] = false;
        }
        else {
            if (Speed != 0) start();
            else {
                Speed = 0;
                CarStates[1] = false;
            }
        }
        if (Speed > MaxSpeed) Speed = MaxSpeed;
    }

    private void distanceChange(double distance){
        switch (Direction){
            case 'N':
                Position[0] += distance;
                break;
            case 'S':
                Position[0] -= distance;
                break;
            case 'E':
                Position[1] += distance;
                break;
            case 'W':
                Position[1] -= distance;
                break;
        }
    }
}
