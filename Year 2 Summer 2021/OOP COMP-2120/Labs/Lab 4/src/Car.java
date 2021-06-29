public class Car {
    private String[] CarInfoS; // = {Make, Model, Transmission, Type};
    private int[] CarInfoI; // = {year, Gas Tank Size, seats, Maximum Speed, Wheels};
    private double[] CarInfoD; // = {Price, FuelEfficiency};
    public static void main(String[] args){
        //Glargs
    }

    public Car(String[] Str, int[] Int, double[] Double){
        if (Str != null)    CarInfoS = Str;
        else CarInfoS = new String[]{null, null, null, null};
        if (Int != null)    CarInfoI = Int;
        else CarInfoI = new int[]{0, 0, 0, 0, 0};
        if (Double != null) CarInfoD = Double;
        else CarInfoD = new double[]{0, 0};
    }
    public Car(String make, String model, String transmission, String type){
        this(new String[]{make, model, transmission, type}, null, null);
    }
    public Car(int year, int gas, int seats, int speed, int wheels){
        this(null, new int[]{year, gas, seats, speed, wheels}, null);
    }
    public Car(double price, double fuel){
        this(null, null, new double[]{price, fuel});
    }
    public Car(){
        this(null, null, null);
    }

    public String getMake(){return CarInfoS[0];}
    public String getModel(){return CarInfoS[1];}
    public String getTransmission(){return CarInfoS[2];}
    public String getType(){return CarInfoS[3];}
    public int getYear(){return CarInfoI[0];}
    public int getGasTankSize(){return CarInfoI[1];}
    public int getSeats(){return CarInfoI[2];}
    public int getMaxSpeed(){return CarInfoI[3];}
    public int getWheels(){return CarInfoI[4];}
    public double getPrice(){return CarInfoD[0];}
    public double getFuelEfficiency(){return CarInfoD[1];}

    public void setMake(String str){CarInfoS[0] = str;}
    public void setModel(String str){CarInfoS[1] = str;}
    public void setTransmission(String str){CarInfoS[2] = str;}
    public void setType(String str){CarInfoS[3] = str;}
    public void setYear(int Int){CarInfoI[0] = Int;}
    public void setGasTankSize(int Int){CarInfoI[1] = Int;}
    public void setSeats(int Int){ CarInfoI[2] = Int;}
    public void setMaxSpeed(int Int){ CarInfoI[3] = Int;}
    public void setWheels(int Int){ CarInfoI[4] = Int;}
    public void setPrice(double Double){ CarInfoD[0] = Double;}
    public void setFuelEfficiency(double Double){ CarInfoD[1] = Double;}
}
