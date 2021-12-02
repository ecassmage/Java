import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Rondom {
    public static void main(String[] args){
        String description = "String;";
        double totalPrice = 100.15;
        ArrayList<Double> a = new ArrayList<>();
        a.add((double) 3);
        System.out.printf("%-12s%8.2f\n",description,totalPrice);
        getAge();
    }
    public static int getAge()
    {
        boolean done = false;
        Scanner console = new Scanner(System.in);
        int value = 0;
        while (!done)
        {
            try (Scanner in = new Scanner("Hello.txt"))
            {
                in.nextLine();
                System.out.print("Please enter your age in years: ");
                value = console.nextInt();

                done = true;
            }
            catch (NoSuchElementException exception) {
                System.out.println("Invalid value. Try again.");

                console.nextLine();
            }
        }
        return value;
    }
}