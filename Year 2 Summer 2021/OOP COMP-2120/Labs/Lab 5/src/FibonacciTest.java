import java.util.Scanner;

public class FibonacciTest {

    public static void main(String[] args){
        Fibonacci F = new Fibonacci();
        F.printFibonacciSeq(getFib());
        System.out.println();
        F.printFibonacciSeq(getFib());
        System.out.println();
        F.printFibonacciSeq(getFib());
        System.out.println();
        F.printFibonacciSeq(getFib());
        System.out.println();
    }

    public static long getFib(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the length of the Fibonacci Sequence you want!!: ");
        return sc.nextLong();

    }
}
