import java.util.Arrays;

public class Company {
    private String Name;
    private int StartingYear;

    private Employee[] Employees;  // Also Contains Managers as a Manager is also an employee so it wouldn't make sense to not include them here as well. I would not recommend using them through here though as you lose access to Manager specific methods.
    private Manager[] Managers;

    public Company(){this(null, 0);}
    public Company(String name, int startingYear){
        this.Name = name;
        this.StartingYear = startingYear;
    }
    public Company(String name, int startingYear, Employee[] employees, Manager[] managers){
        this(name, startingYear);
        this.Employees = employees;
        this.Managers = managers;
    }

    public void setCompanyName(String name){Name = name;}
    public void setStartingYear(int year){StartingYear = year;}
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
    public void addManager(Manager manager){
        if (Managers == null) Managers = new Manager[0];
        Managers = Arrays.copyOf(Managers, Managers.length+1);
        Managers[Managers.length-1] = manager;
    }
    public void removeManager(Manager manager){
        Manager[] list = Managers;
        Managers = new Manager[Managers.length-1];
        int i = 0;
        for (Manager managerA: list){
            if (managerA == manager) continue;
            Managers[i++] = managerA;
        }
    }

    public Employee[] getEmployees(){return Employees;}
    public Manager[] getManagers(){return Managers;}

    // GRRR DUMB BONUSES
    public Person[] sortEmployees(String code){ return sortEmployees(Employees, code); }
    public static Person[] sortEmployees(Employee[] list, String code) {
        return FriendsList.sort(list, code);
    }
    // GRRR DUMB BONUSES  I am kind of happy I procrastinated making that dumb sorting algorithm since this was easy because of it.
    // I hope it is fine that I am letting them be sent back as Person[] instead of Employee[]/Manager[]. They still retain all the information
    // but lose their methods when accessed through this Person array.
    public Person[] sortEmployeesByManager(String code) {
        Employee[] list = Employees;
        Person[] people = new Person[list.length];
        int i = 0;
        for (Manager manager: Managers){
            Person[] listOfPeeps = sortEmployees(manager.getEmployees(), code);
            people[i++] = manager;
            for (Person person: listOfPeeps){
                people[i++] = person;
            }
        }
        return people;
    }
}
