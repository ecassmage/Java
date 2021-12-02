public class ComboLockTester {

    public static void main(String[] args){
        boolean isOpen;
        ComboLock C = new ComboLock(5, 10, 3);
        if (C.open()) System.exit(0);  // This will exit if this does not work  // This was added
        C.turnRight(5);
        C.printTick();
        C.open();
        C.turnLeft(40);
        C.printTick();
        C.open();
        C.turnLeft(35);
        C.printTick();
        C.open();
        C.turnRight(33);
        C.printTick();
        if (!C.open()) System.exit(0);  // This will exit if this does not work // This was added
        C.tryToUnlockLockLoop();
    }
}
