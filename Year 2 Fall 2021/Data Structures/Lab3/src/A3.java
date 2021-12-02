import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A3 {
    public static boolean matchChars(String str, Stack2540Array stack) {
        return (stack.top() != null && stack.top() != null) ? "({[".indexOf(stack.top().charAt(0)) == ")}]".indexOf(str.charAt(0)) : false;
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        String[] temp = expression.replace(" ", "").split("[^(){}\\[\\]]?");
        Stack2540Array Stack = new Stack2540Array();
        if (temp == null) return true;  // True because it didn't break any of the rules.
        for (String str: temp){
            if (str.equals("")) continue;
            if (opening.contains(str)) Stack.push(str);
            else{
                if (matchChars(str, Stack)) Stack.pop();
                else return false;
            }
        }
        return !(Stack.size() > 0);
    }



    static String[] reverse (String filename) throws Exception {
        Scanner scanner = new Scanner (new File(filename)).useDelimiter("[^a-zA-Z]+");

        Stack2540Array stack = new Stack2540Array((int) new File(filename).length() / 6);
        while(scanner.hasNext())
            stack.push(scanner.next().toLowerCase());
        String[] rev = new String[stack.size()];
        int startSize = stack.size();
        while (stack.size() > 0) rev[startSize - stack.size()] = stack.pop();
        return rev;
    }

    static String[] reverseDynamic(String filename) throws Exception {
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic();
        StringBuilder SB = new StringBuilder();
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));

        while ((line = doc.readLine()) != null) SB.append(line.toLowerCase());
        StringTokenizer tokens = new StringTokenizer(SB.toString());

        while (tokens.hasMoreTokens())  stack.push(tokens.nextToken().toLowerCase());

        String[] rev = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) rev[i - stack.size()] = stack.pop();
        return rev;
    }

    static String[] revers(String filename) throws Exception{
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic();
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        String line;
        while ((line = doc.readLine()) != null) {
            for (String str: line.split(" "))
            stack.push(str.toLowerCase());
        }
        String[] rev = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) rev[i - stack.size()] = stack.pop();
        return rev;
    }

    public static void main(String[] args) throws Exception{
        Stack2540Array stack = new Stack2540Array();
        stack.push("Hello World");
        stack.push("Bye");
        String a1 = stack.pop();
        String a2 = stack.pop();
        String a3 = stack.pop();
        System.out.println(a1 + ", " + a2 + ", " + a3);
        System.out.println(isMatched("( ) ( ( ) ) {( [ ( ) ] ) } "));
        System.out.println(isMatched(") (() ) {([() ])}"));
        System.out.println(isMatched(" (3) (3 + (4 - 5) ) {( [ ( ) ] ) } "));
        System.out.println(isMatched(" ({[]) }"));
        System.out.println(isMatched(" ((() (() ) {([() ]) }))"));
        System.out.println(isMatched("("));
        System.out.println(isMatched(" [(5+ x) -(y+z)]"));
        String[] rev = reverseDynamic("Text.txt");

        for (String temp: rev){
            System.out.print(temp + " ");
        }
    }
}
