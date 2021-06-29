import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class TestDealership {
    //The Internet is beautiful that they have lists of anything up.
    private final String[] Makes = {"Acura","Alfa Romeo","AM General","AMC","Aston Martin","Audi","Bentley","BMW","Bricklin","Buick","Cadillac","Chevrolet","Chrysler","Daewoo","Datsun","Dodge","Eagle","Ferrari","Fiat","Ford","Geo","GMC","Honda","HUMMER","Hyundai","Infiniti","Isuzu","Jaguar","Jeep","Kia","Land Rover","Lexus","Lincoln","Lamborghini","Lotus","Maserati","Mazda","Mercedes-Benz","Mercury","MG","MINI","Mitsubishi","Nissan","Oldsmobile","Plymouth","Pontiac","Porsche","RAM","Renault","Rolls Royce","Saab","Saturn","Scion","Shelby","Smart","Subaru","Suzuki","Toyota","Triumph","Volkswagen","Volvo"};
    private final String[] Types = {"Sedan", "Coupe", "Sports Car", "Station Wagon", "HatchBack", "Convertible", "SUV", "MiniVan", "Pickup Truck"};
    private final String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String[] words = {"Alpha", "Beta", "Jacobin", "Napoleon", "Panzer", "Tank", "Rhine", "Alsace", "Bismarck", "Yamato", "Hood", "Omega", "Verdun", "Thermopylae", "Caesar", "Bonaparte"}; // 16
    private final Random rand = new Random();
    private Dealership[] DS;
    public static void print(String str){
        System.out.println(str);
    }
    public static void main(String[] args){
        TestDealership TD = new TestDealership();
        TD.addDealership(new Dealership(TD.buildCar()));
        TD.addDealership(new Dealership(TD.buildCar()));
        TD.addDealership(new Dealership(TD.buildCar()));
        TD.DS[0].setName("Cars Which Are Definitely Good");
        TD.DS[0].setLocation("123 Not Illegal Rd");
        TD.DS[1].setName("Competitive Cars Not Competitive Prices");
        TD.DS[1].setLocation("7424 People Boulevard");
        TD.DS[2].setName("Car Street Bets");
        TD.DS[2].setLocation("2482646 Avenue");
        TD.addCars(TD.DS[0], 10);
        TD.addEmployees(TD.DS[0], 10);
        TD.addManagers(TD.DS[0], 10);
        TD.addCars(TD.DS[1], 10);
        TD.addEmployees(TD.DS[1], 10);
        TD.addManagers(TD.DS[1], 10);
        TD.addCars(TD.DS[2], 1000);
        TD.addEmployees(TD.DS[2], 100);
        TD.addManagers(TD.DS[2], 10);
        print(Arrays.toString(TD.DS[1].getCars()));
        print(Arrays.toString(TD.DS[0].getEmployees()));
        print(Arrays.toString(TD.DS[0].getManagers()));
        print(Arrays.toString(TD.DS[1].getEmployees()));
        print(Arrays.toString(TD.DS[1].getManagers()));
        print(Arrays.toString(TD.DS[2].getCars()));
        print(Arrays.toString(TD.DS[2].getEmployees()));
        print(Arrays.toString(TD.DS[2].getManagers()));
        Scanner scn = new Scanner(System.in);
        System.out.print("Do You Want all Cars to Be Printing Out???: This is a lot of cars so you might not want this: ");
        String str = scn.nextLine().toLowerCase();
        if (str.equals("yes")){
            printCars(TD.DS[0]);
            printCars(TD.DS[1]);
            printCars(TD.DS[2]);
        }
    }

    public static void printCars(Dealership Dealer){
        System.out.println(Dealer.getName() + " Presents at the Location: " + Dealer.getLocation() + " All of these Cars!!!!");
        for (Car car: Dealer.getCars()){
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

    public TestDealership(){
        this.DS = new Dealership[0];
    }

    public void addDealership(Dealership ds){
        DS = Arrays.copyOf(DS, DS.length + 1);
        DS[DS.length-1] = ds;
    }

    public Car buildCar(){
        return new Car(new String[]{makeMake(), makeModel(), makeTransmission(), makeType()}, new int[]{getYear(), getGas(), getSeats(), getSpeed(), getWheels()}, new double[]{getPrice(), getFuelEfficiency()});
    }
    public void addCars(Dealership DS, int num){
        for (int i = 0; i < num; i++){
            DS.addCar(buildCar());
        }
    }
    public void addEmployees(Dealership DS, int num){
        int numero = 0;
        int largestNumero = 0;
        for (String name: DS.getEmployees()){
            for (int i = 0; i < name.length(); i++){
                if (48 <= name.charAt(i) && name.charAt(i) < 58){
                    numero = (numero * 10) + (name.charAt(i) - 48);
                }
            }
            if (numero > largestNumero) largestNumero = numero;
        }
        largestNumero++;
        for (int i = 0; i < num; i++){
            DS.addEmployee("Drone " + (i + largestNumero));
        }
    }
    public void addManagers(Dealership DS, int num){
        int numero = 0;
        int largestNumero = 0;
        for (String name: DS.getManagers()){
            for (int i = 0; i < name.length(); i++){
                if (48 <= name.charAt(i) && name.charAt(i) < 58){
                    numero = (numero * 10) + (name.charAt(i) - 48);
                }
            }
            if (numero > largestNumero) largestNumero = numero;
        }
        largestNumero++;
        for (int i = 0; i < num; i++){
            DS.addManager("ManagerDrone " + (i + largestNumero));
        }
    }
    public String makeMake(){
        return Makes[rand.nextInt(Makes.length)];
    }
    public String makeModel(){
        return Character.toString(Alpha.charAt(rand.nextInt(26))) + "-" + Integer.toString(rand.nextInt(1000));
    }
    public String makeTransmission() {
        return "Type " + Character.toString(Alpha.charAt(rand.nextInt(Alpha.length()))) + "-" + Integer.toString(rand.nextInt(200)) + " " + words[rand.nextInt(words.length)];
    }
    public String makeType(){
        return Types[rand.nextInt(Types.length)];
    }
    public int getYear(){
        return rand.nextInt(2022);
    }
    public int getGas(){
        return rand.nextInt(200);
    }
    public int getSeats(){
        return rand.nextInt(15) + 1;
    }
    public int getSpeed(){
        return rand.nextInt(100) + 100;
    }
    public int getWheels(){
        return rand.nextInt(18) + 1;
    }
    public double getPrice(){
        return (double) Math.round((rand.nextDouble() + rand.nextInt(100000) + 10000) * 100) / 100;
    }
    public double getFuelEfficiency(){
        return (double) Math.round((rand.nextDouble() / 4 + 0.01) * 100) / 100;
    }
}
