import java.util.LinkedList;
/**
 A test program to reverse the entries in a linked list.
 */
public class ReverseTester
{
    public static void main(String[] args)
    {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.addLast("Dick");
        employeeNames.addLast("Harry");
        employeeNames.addLast("Romeo");
        employeeNames.addLast("Tom");
        System.out.println("Before Reversal: \t" + employeeNames);
        ListUtil.reverse(employeeNames);
        System.out.println("After Reversal: \t" + employeeNames);
        System.out.println("Expected:       \t[Tom, Romeo, Harry, Dick]");
    }
}