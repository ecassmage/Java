public class ComboLockTester {

    public static void main(String[] args){
        ComboLock C = new ComboLock(5, 10, 3);
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
        C.open();
        C.tryToUnlockLockLoop();
    }
}
