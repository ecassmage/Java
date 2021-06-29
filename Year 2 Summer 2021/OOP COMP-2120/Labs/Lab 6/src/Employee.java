public class Employee extends Person{
    private double Salary;
    private int[] hiringDate;

    public Employee(String name, int age, String gender, double Salary, int hiringYear){
        this(name.split(" "), age, gender, Salary, new int[]{0, 0, hiringYear});
    }
    public Employee(String name, int age, String gender, double Salary, int[] DMY){
        this(name.split(" "), age, gender, Salary, DMY);
    }
    public Employee(String[] name, int age, String gender, double Salary, int[] DMY){
        super(name, age, gender);
        this.Salary = Salary;
        this.hiringDate = DMY;
    }
    @Override
    public String toString(){
        return getName() + ", Employee, Salary = $" + Salary + "/year";
    }

    public double getSalary(){ return Salary; }
    public int[] getHiringDMY(){ return hiringDate; }
    public int getHiringYear(){ return hiringDate[2]; }
    public void setSalary(double salary) { this.Salary = salary; }
    public void setHiringDate(int Day, int Month, int Year) {
        this.hiringDate[0] = Day;
        this.hiringDate[1] = Month;
        this.hiringDate[2] = Year;
    }
}
