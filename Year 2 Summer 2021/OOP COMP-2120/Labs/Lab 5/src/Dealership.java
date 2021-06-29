import java.util.ArrayList;


public class Dealership {
    //I Am Bored
    private String[] DealerShipInformation;
    private ArrayList<Car> Cars;
    private String[] Employees;
    private String[] Managers;
    public static void main(String[] args){
        //Blargs
    }

    public Dealership(String name, String location, String[] ListOfEmployees, String[] ListOfManagers, Car[] ListOfCars){
        this.DealerShipInformation = new String[]{name, location};
        this.Cars = new ArrayList<>();
        for (Car car: ListOfCars) this.Cars.add(car);
        this.Employees = ListOfEmployees;
        this.Managers = ListOfManagers;
    }
    public Dealership(Car car){
        this(null, null, new String[0], new String[0], new Car[]{car});
    }

    public void addEmployee(String Name){
        String[] list = Employees.clone();
        Employees = new String[Employees.length + 1];
        for (int i = 0; i < list.length; i++) Employees[i] = list[i]; // Meh I am too tired to use ArrayList and It never told me I had to.
        Employees[Employees.length-1] = Name;
    }

    public void addManager(String Name){
        String[] list = Managers.clone();
        Managers = new String[Managers.length + 1];
        for (int i = 0; i < list.length; i++) Managers[i] = list[i];
        Managers[Managers.length-1] = Name;
    }

    public void addCar(Car car){
        Cars.add(car);
    }

    public void deleteEmployee(String name){
        ForElse:{
            for (String Name: Employees) if (Name.equals(name)) break ForElse;
            return;
        }
        String[] list = Employees;
        Employees = new String[list.length-1];
        int j = 0;
        for (int i = 0; i < list.length; i++){
            if (!list[i].equals(name)){
                Employees[j] = list[i];
                j++;
            }
        }
    }
    public void deleteManager(String name){
        ForElse:{
            for (String Name: Managers) if (Name.equals(name)) break ForElse;
            return;
        }
        String[] list = Managers;
        Managers = new String[list.length-1];
        int j = 0;

        for (int i = 0; i < list.length; i++){
            if (!list[i].equals(name)){
                Managers[j] = list[i];
                j++;
            }
        }
    }
    public void deleteCar(Car car){

        ForElse:{
            for (Car cars: Cars) if (cars == car) break ForElse;
            return;
        }
        Cars.remove(car);
    }

    public void setName(String name){ DealerShipInformation[0] = name; }
    public void setLocation(String location){ DealerShipInformation[1] = location; }
    public String getName(){ return DealerShipInformation[0]; }
    public String getLocation(){ return DealerShipInformation[1]; }


    public String[] getEmployees(){
        return Employees;
    }
    public String[] getManagers(){
        return Managers;
    }
    public ArrayList<Car> getCars(){
        return Cars;
    }

    public void printCars(){
        System.out.println(getName() + " Presents at the Location: " + getLocation() + " All of these Cars!!!!");
        for (Car car: getCars()){
            System.out.println(car);
            System.out.println("\tMake: " + car.getMake());
            System.out.println("\tModel: " + car.getModel());
            System.out.println("\tTransmission: " + car.getTransmission());
            System.out.println("\tType: " + car.getType());
            System.out.println("\tYear: " + car.getYear() + " AF");  // After Future
            System.out.println("\tGas: " + car.getGasTankSize() + " L");
            System.out.println("\tSeats: " + car.getSeats());
            System.out.println("\tSpeed: " + car.getMaxSpeed() + " kmh");
            System.out.println("\tWheels: " + car.getWheels());
            System.out.println("\tPrice: $" + car.getPrice());
            System.out.println("\tFuel Efficiency: " + car.getFuelEfficiency() + " l/km");
        }
    }
}
