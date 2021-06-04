import java.util.Arrays;

public class Manager extends Employee{
    private double BonusMonthly;
    private Employee[] Employees;
    public Manager(String name, String Phone, int bMonth, int bDay, int hiringYear, double salary, int vacationDays, int unusedVacationDays, double bonusMonthly) {this(name, Phone, bMonth, bDay, hiringYear, salary, vacationDays, unusedVacationDays, bonusMonthly, null);}
    public Manager(String name, String Phone, int bMonth, int bDay, int hiringYear, double salary, int vacationDays, int unusedVacationDays, double bonusMonthly, Employee[] listOfEmployees){
        super(name, Phone, bMonth, bDay, hiringYear, salary, vacationDays, unusedVacationDays);
        this.BonusMonthly = bonusMonthly;
        this.Employees = listOfEmployees;
    }

    public void setMonthlyBonus(double bonus){BonusMonthly = bonus;}
    public void addEmployee(Employee employee){
        if (Employees == null) Employees = new Employee[0];
        Employees = Arrays.copyOf(Employees, Employees.length+1);
        Employees[Employees.length-1] = employee;
    }
    public void removeEmployee(Employee employee){
        Employee[] list = Employees;
        Employees = new Employee[Employees.length-1];
        int i = 0;
        for (Employee employeeA: list){
            if (employeeA == employee) continue;
            Employees[i++] = employeeA;
        }
    }

    public double getMonthlyBonus(){return BonusMonthly;}
    public Employee[] getEmployees(){return Employees;}
}