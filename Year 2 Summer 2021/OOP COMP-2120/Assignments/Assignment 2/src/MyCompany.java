public class MyCompany {
    public static void main(String[] args){
        Company company = new Company("This is My Company Deal With it Corporation", 0 /* 0 UST (Universe Standard Time) */);
        Manager[] Managers = {
                new Manager("Evan Morrison", "666 666 6666", 4, 10, 0, 2147483647, 365, 365, 2147483647),
                new Manager("Evan EvilMorrison", "333 333 3333", 2, 5, 100, 1073741823, 182, 182, 1073741823)
        };
        Managers[0].setCellFormat("XXX XXX XXX", "666 666 666");
        Managers[1].setCellFormat("XXX XXX XXX", "333 333 333");
        Employee[] Employees = {
                new Employee("Joe Schnitzel", "519 666-6666", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel2", "519 666-6667", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel3", "519 666-6668", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel4", "519 666-6669", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel5", "519 666-6670", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel6", "519 666-6671", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel7", "519 666-6672", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel8", "519 666-6673", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel9", "519 666-6674", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel10", "519 666-6675", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel11", "519 666-6676", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel12", "519 666-6677", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel13", "519 666-6678", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel14", "519 666-6679", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel15", "519 666-6680", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel16", "519 666-6681", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel17", "519 666-6682", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel18", "519 666-6683", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel19", "519 666-6684", 1, 1, 1812, 12.99, 1, 1),
                new Employee("Joe Schnitzel20", "519 666-6685", 1, 1, 1812, 12.99, 1, 1),
        };
        for (Employee employee: Employees){
            company.addEmployee(employee);
        }
        int j = 0;
        for (Manager manager: Managers){
            int i = 0;
            for (; i < Employees.length / 2; i++){
                manager.addEmployee(Employees[i+j]);
            }
            company.addManager(manager);
            company.addEmployee(manager);
            j = i;
        }
        Person[] Hello = company.sortEmployees("LastNames");
        FriendsList.printList(Hello, "Name");
        Person[] NextList = company.sortEmployeesByManager("LastNames");
        FriendsList.printList(NextList, "Name");
    }
}
