public class Employee extends Person{
    private int yearOfHire;
    private double annualSalary;
    private int[] vacationDays;
    public Employee(String fName, String lName, String Phone, int bMonth, int bDay, int hiringYear, double salary, int vacationDays, int unusedVacationDays)
    { this(fName + " " + lName, Phone, bMonth, bDay, hiringYear, salary, vacationDays, unusedVacationDays); }
    public Employee(String name, String Phone, int bMonth, int bDay, int hiringYear, double salary, int vacationDays, int unusedVacationDays){
        super(name, Phone, bMonth, bDay);
        this.yearOfHire = hiringYear;
        this.annualSalary = salary;
        this.vacationDays = new int[]{unusedVacationDays, vacationDays};
    }

    // I Hate Writing These SOOO Much!!!.
    public void setYearOfHire(int year){yearOfHire = year;}
    public void setAnnualSalary(double money){annualSalary = money;}
    public void setVacationDays(int vacationDays){this.vacationDays[1] = vacationDays;}
    public void setUnusedVacationDays(int unusedVacationDays){vacationDays[0] = unusedVacationDays;}

    // I Hate Writing These SOOO Much as Well!!!.
    public int getYearOfHire(){return yearOfHire;}
    public double getAnnualSalary(){return annualSalary;}
    public int getVacationDays(){return vacationDays[1];}
    public int getUnusedVacationDays(){return vacationDays[0];}
}
