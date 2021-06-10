import java.util.Scanner;

public class PrimePrinter {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        int limit = in.nextInt(), n;
        PrimeGenerator PG = new PrimeGenerator();
        while ((n = PG.nextPrime()) <= limit) System.out.println(n);
    }
}