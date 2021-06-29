import java.util.Hashtable;
import java.util.ArrayList;

public class Fibonacci {

    private Hashtable<Long, Long> FibonacciList;

    public static void main(String[] args){
        Fibonacci F = new Fibonacci();
        System.out.println(F.getFibonacci(10));
        F.printFibonacciSeq(10);
        F.printFibonacciSeq(90);
    }

    public Fibonacci(){
        FibonacciList = new Hashtable<>(); // I Didn't See a Point to using a List over a HashTable.
        FibonacciList.put(0L, 0L);
        FibonacciList.put(1L, 1L);
    }

    public long getFibonacci(long num){return FibonacciCalc(num-1);}

    public void printFibonacciSeq(long num){
        if (FibonacciList.size() < num){
            System.out.println("The Number you entered is Invalid, So We are going to extend the fibonacci sequence a little if possible");
            getFibonacci(num);
        }
        System.out.print("[");
        for (long i = 0; i < num; i++){
            if (i > 0) System.out.print(", ");
            System.out.print(FibonacciList.get(i));
        }
        System.out.println("]");
    }

    private long FibonacciCalc(long num){
        if (FibonacciList.containsKey(num)) return FibonacciList.get(num);
        long  num2 = FibonacciCalc((num - 1)) + FibonacciCalc(num - 2);
        FibonacciList.put(num, num2);
        return num2;
    }

}
