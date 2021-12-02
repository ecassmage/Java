import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * * * Java Files needed for this Tester.
 * FormatTester.java
 * DefaultFormatter.java
 * DecimalFormatter.java
 * AccountingFormatter.java
 * BaseFormatter.java
 * NumberFormatter.java

 * * *  Files wanted by program
 * Numbers.txt
 */


public class FormatTester {
    public static void main(String[] args) throws IOException{
        DefaultFormatter D = new DefaultFormatter();
        DecimalSeparatorFormatter DS = new DecimalSeparatorFormatter();
        AccountingFormatter A = new AccountingFormatter();
        BaseFormatter B = new BaseFormatter(8);
        File file = new File("Numbers.txt");
        FileWriter newFile = new FileWriter("FormattedNumbers.txt");
        Scanner scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine()) {  // checks for a next Line
            String[] nums = scan.nextLine().split(" ");  // This will split the numberer up into a list of Strings
            DefaultFormatter(D, newFile, nums);             // This Manages the DefaultFormatter
            DecimalFormatter(DS, newFile, nums);            // This Manages the DecimalFormatter
            AccountingFormatter(A, newFile, nums);          // This Manages the AccountingFormatter
            BaseFormatter(B, newFile, nums, 8);             // This Manages the Base 8 BaseFormatter
            BaseFormatter(B, newFile, nums, 2);             // This Manages the Base 2 BaseFormatter
            newFile.write("\n");  // Adds a new Line at the end of each section for easier deciphering of each block
        }
        newFile.close();
    }

    public static void DefaultFormatter(DefaultFormatter D, FileWriter F, String[] arr) throws IOException{
        F.write("Default Format: ");
        for (String num: arr){
            F.write(D.format(Integer.parseInt(num)) + " ");  // This Will turn the Values back into Integers.
            // I am doing it this way because it is easier to split them by the " " instead of going 1 number at a time for an unknown time frame.
            // It is build so as to take as many lines as needed for stress testing purposes.
        }
        F.write("\n");
    }
    public static void DecimalFormatter(DecimalSeparatorFormatter DS, FileWriter F, String[] arr) throws IOException{
        F.write("Decimal Format: ");
        for (String num: arr){
            F.write(DS.format(Integer.parseInt(num)) + " ");
        }
        F.write("\n");
    }
    public static void AccountingFormatter(AccountingFormatter A, FileWriter F, String[] arr) throws IOException{
        F.write("Accounting Format: ");
        for (String num: arr){
            F.write(A.format(Integer.parseInt(num)) + " ");
        }
        F.write("\n");
    }
    public static void BaseFormatter(BaseFormatter B, FileWriter F, String[] arr, int number) throws IOException{
        F.write("Base " + number + " Format: ");
        B.setBase(number);
        for (String num: arr){
            F.write(B.format(Integer.parseInt(num)) + " ");
        }
        F.write("\n");
    }
}
