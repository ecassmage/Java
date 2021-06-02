public class Car {
    private String Make;
    private String Model;
    private int Year;
    private double Price;
    private int Speed;
    private int MaxSpeed;
    private boolean[] CarStates;  // {isOn, isMoving}
    public static void main(String[] args){
        Car newCar = new Car("Hello", "Mello", 2001, 12000.12);
    }

    public Car(String make, String model, int year, double price){
        this.Make = make;
        this.Model = model;
        this.Year = year;
        this.Price = price;
        this.CarStates = new boolean[]{false, false};
    }

    public Car(String make, String model){
        this(make, model, 0, 0);
    }
    public Car(int year){
        this(null, null, year, 0);
    }
    public Car(double price){
        this(null, null, 0, price);
    }
    public Car(){}
    // I DON"T WANNA!!!!!!!!!!!!!
    //Setters
    public void setMake(String make){Make = make;}
    public void setModel(String model){Model = model;}
    public void setYear(int year){Year = year;}
    public void setPrice(double price){Price = price;}
    public void setMaxSpeed(int speedMax){MaxSpeed = speedMax;}
    public void accelerate(int acceleration){Speed += acceleration; isMoving();}
    public void decelerate(int deceleration){Speed -= deceleration; isMoving();}
    public void turnOn(){CarStates[0] = true;}
    public void turnOff(){CarStates[0] = false;}
    private void isMoving(){if (Speed != 0) start(); else stop();}
    public void start(){CarStates[1] = true;}
    public void stop(){CarStates[1] = false;}
    //Setters

    //Getters
    public String getMake(){return Make;}
    public String getModel(){return Model;}
    public int getYear(){return Year;}
    public double getPrice(){return Price;}
    public int getSpeed(){return Speed;}
    public int getMaxSpeed(){return MaxSpeed;}
    public boolean IsOn(){return CarStates[0];}
    public boolean IsMoving(){return CarStates[1];}
    //Getters
}
