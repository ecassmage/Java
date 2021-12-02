public class Employee implements Payable{
    private int workingHours;
    private double hourlyRate;

    public Employee(int workingHours, double hourlyRate){
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getPaymentAmount(){
        return workingHours * hourlyRate;
    }


    public void setWorkingHours(int hours){workingHours = hours;}
    public void setHourlyRate(double rate){hourlyRate = rate;}

    public int getWorkingHours() {return workingHours;}
    public double getHourlyRate() {return hourlyRate;}
}