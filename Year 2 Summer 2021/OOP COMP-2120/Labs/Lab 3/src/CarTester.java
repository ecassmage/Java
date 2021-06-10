/**
 * Tester Class for Car Class
 *
 * @author Evan Morrison
 * @version 1.1.10
 * @since 1.1
 */
public class CarTester {

    /**
     * PUBLIC STATIC VOID MAIN[sTRING() ARGS] BLARG ;P
     * @param args This is still something that holds idk. Probably extra arguments like in C, but I dunno.
     */
    public static void main(String[] args){
        Car car = new Car("Ford", "F-150", 2016, 33429, 0.13, 136, 136);
        car.setMaxSpeed(175);
        car.turnOn();
        car.accelerate(100);
        car.drive(2);
        car.turnLeft();
        car.drive(124, 10);
        car.accelerate(25);
        car.turnLeft();
        car.printCar(false);
        car.drive(124, 10);
        car.decelerate(50);
        car.drive(25.0);
        car.stop();
        car.start();
        car.accelerate(100);
        car.stop();
        car.addGas(50, 10);
        car.turnOff();
        car.printCar(false);
    }
}
