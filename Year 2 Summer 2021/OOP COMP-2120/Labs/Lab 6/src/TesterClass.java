import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class TesterClass {
    Random R = new Random();
    public static void main(String[] args){
        TesterClass T = new TesterClass();
        System.out.println("\n\tThis is The Persons Test Beginning\n");
        T.testingPersons();
        System.out.println("\n\tThis is The Persons Test Ending\n");
        System.out.println("\n\tThis is The Shapes Test Beginning\n");
        T.testingShapes();
        System.out.println("\n\tThis is The Shapes Test Ending\n");
    }

    public void testingPersons(){
        Manager M = new Manager("Evan Morrison", 20, "Male", 1000000, new int[]{1, 1, 1}, 1000);
        Employee E = new Employee("Connor Morrison", 23, "Male", 100, new int[]{2, 2, 2});
        Student S = new Student("John Morrison", 99, "Male", "Not a Computer Program", "Best Level, Even Higher then PH.D", 0);
        Person P = new Person("Person Morrison", 99, "Male");
        System.out.println(M);
        System.out.println(E);
        System.out.println(S);
        System.out.println(P);
    }

    public double rand(int num1, int num2){
        return R.nextDouble() + R.nextInt(num2 - num1) + num1;
    } // Python Randoms :)
    public double rand(int num){
        return rand(0, num);
    }  // Same as Above
    // My Fixation on Python is Probably Unhealthy.
    public void testingShapes(){
        Random R = new Random();
        ArrayList<Shape> BigListOfShapes = new ArrayList<>();
        Scanner S = new Scanner(System.in);
        BreakWhileLoop:{
            while (true) {
                System.out.print("Enter Something Please:\nT for Triangle\nC for Circle\nQ for Square\nO for Oval\nP for Printing List\nE for Exit\nSo What Do Ya Want??: ");
                String chars = S.nextLine();
                for (int i = 0; i < chars.length(); i++) {
                    switch (chars.charAt(i)) {
                        case 'T':
                            //Triangle
                            BigListOfShapes.add(new Triangle(rand(1000), rand(1000)));
                            break;
                        case 'C':
                            //Circle
                            BigListOfShapes.add(new Circle(rand(1000)));
                            break;
                        case 'Q':
                            //Square
                            BigListOfShapes.add(new Square(rand(1000)));
                            break;
                        case 'O':
                            //Oval
                            BigListOfShapes.add(new Oval(rand(1000), rand(1000)));
                            break;
                        case 'P':
                            //Print List
                            print(BigListOfShapes);
                            break;
                        case 'E':
                            //Exit Infinite Loop
                            break BreakWhileLoop;
                    }
                }
            }
        }
        System.out.println("\n\tThis is the Final State of the Array List");
        print(BigListOfShapes);
    }
    public static void print(ArrayList<Shape> Shapes){
        for (Shape S: Shapes) System.out.println(S);
    }
}
