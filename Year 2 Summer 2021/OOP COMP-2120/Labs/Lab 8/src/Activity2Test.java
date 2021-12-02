public class Activity2Test {
    public static void main(String[] args){
        Activity2 A = args.length == 0 ? new Activity2("input1.txt", "input2.txt", "input3.txt") : new Activity2(args);  // This way we will always get what we want.
        A.readAll(true);
        A.setptr(); // This Resets the pointer in Activity 2 to 0
        A.readAll(false);
    }
}
