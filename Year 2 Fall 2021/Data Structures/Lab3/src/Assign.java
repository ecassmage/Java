import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Assign {
    static String[] reverseDynamic2(String filename) throws Exception {

        StringBuilder SB = new StringBuilder();
        String line;
        File file = new File(filename);
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic((int) file.length() / 25);
        BufferedReader doc = new BufferedReader(new FileReader(filename));
        while ((line = doc.readLine()) != null) for (String str: line.split("[^a-zA-Z]+")) stack.push(str.toLowerCase());
        doc.close();
        String[] str = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) str[i - stack.size()] = stack.pop();
        stack.resizeC(0); // Not really cheating since it doesn't work.
        return str;
    }


    static String[] reverseDynamic(String filename) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        long[] StartMem = new long[10];
        long[] EndMem   = new long[10];

        StartMem[0] = runtime.totalMemory() - runtime.freeMemory();
        StringBuilder SB = new StringBuilder();
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        EndMem[0] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[1] = runtime.totalMemory() - runtime.freeMemory();
        while ((line = doc.readLine()) != null) SB.append(" ").append(line);  // There is a really annoying warning when these are in same append method
        doc.close();
        EndMem[1] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[2] = runtime.totalMemory() - runtime.freeMemory();
        StartMem[4] = runtime.totalMemory() - runtime.freeMemory();
        StringTokenizer tokens = new StringTokenizer(SB.toString());
        EndMem[4] = runtime.totalMemory() - runtime.freeMemory();
        StartMem[5] = runtime.totalMemory() - runtime.freeMemory();
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic(tokens.countTokens());
        EndMem[5] = runtime.totalMemory() - runtime.freeMemory();
        while (tokens.hasMoreTokens())  stack.push(tokens.nextToken().toLowerCase());
        EndMem[2] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[3] = runtime.totalMemory() - runtime.freeMemory();
        String[] arr = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) arr[i - stack.size()] = stack.pop();
        EndMem[3] = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(((EndMem[0] - StartMem[0]) / 1000000) + " " + ((EndMem[1] - StartMem[1]) / 1000000) + " " + ((EndMem[2] - StartMem[2]) / 1000000) + " " + ((EndMem[3] - StartMem[3]) / 1000000));
        System.out.println(((EndMem[4] - StartMem[4]) / 1000000) + " " + ((EndMem[5] - StartMem[5]) / 1000000) + " ");
        return arr;
    }

    static String[] reverseDynamic22(String filename) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        long[] StartMem = new long[10];
        long[] EndMem   = new long[10];

        StartMem[0] = runtime.totalMemory() - runtime.freeMemory();
        StringBuilder SB = new StringBuilder();
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        EndMem[0] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[1] = runtime.totalMemory() - runtime.freeMemory();
        while ((line = doc.readLine()) != null) SB.append(" ").append(line);  // There is a really annoying warning when these are in same append method
        doc.close();
        EndMem[1] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[2] = runtime.totalMemory() - runtime.freeMemory();
        StartMem[4] = runtime.totalMemory() - runtime.freeMemory();
        StringTokenizer tokens = new StringTokenizer(SB.toString());
        EndMem[4] = runtime.totalMemory() - runtime.freeMemory();
        StartMem[5] = runtime.totalMemory() - runtime.freeMemory();
        Stack2540ArrayDynamic2 stack = new Stack2540ArrayDynamic2(tokens.countTokens());
        EndMem[5] = runtime.totalMemory() - runtime.freeMemory();
        while (tokens.hasMoreTokens())  stack.push(tokens.nextToken().toLowerCase());
        EndMem[2] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[3] = runtime.totalMemory() - runtime.freeMemory();
        String[] arr = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) arr[i - stack.size()] = stack.pop();
        EndMem[3] = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(((EndMem[0] - StartMem[0]) / 1000000) + " " + ((EndMem[1] - StartMem[1]) / 1000000) + " " + ((EndMem[2] - StartMem[2]) / 1000000) + " " + ((EndMem[3] - StartMem[3]) / 1000000));
        System.out.println(((EndMem[4] - StartMem[4]) / 1000000) + " " + ((EndMem[5] - StartMem[5]) / 1000000) + " ");
        return arr;
    }

    static String[] reverseDynamicNE(String filename) throws Exception {

        StringBuilder SB = new StringBuilder((int) new File(filename).length() + 10);
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));

        while ((line = doc.readLine()) != null) SB.append(" ").append(line);  // There is a really annoying warning when these are in same append method
        doc.close();
        StringTokenizer tokens = new StringTokenizer(SB.toString());
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic(tokens.countTokens());
        while (tokens.hasMoreTokens())  stack.push(tokens.nextToken().toLowerCase());


        String[] arr = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) arr[i - stack.size()] = stack.pop();
        return arr;
    }

    static String[] tryReverse(String filename) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        long[] StartMem = new long[10];
        long[] EndMem   = new long[10];

        StartMem[0] = runtime.totalMemory() - runtime.freeMemory();
        StringBuilder SB = new StringBuilder();
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        EndMem[0] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[1] = runtime.totalMemory() - runtime.freeMemory();
        while ((line = doc.readLine()) != null) SB.append(" ").append(line.toLowerCase());  // There is a really annoying warning when these are in same append method
        doc.close();
        EndMem[1] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[2] = runtime.totalMemory() - runtime.freeMemory();
        StringTokenizer tokens = new StringTokenizer(SB.toString());
        int tokenSize = tokens.countTokens();
        String[] str = new String[tokenSize];
        EndMem[2] = runtime.totalMemory() - runtime.freeMemory();

        StartMem[3] = runtime.totalMemory() - runtime.freeMemory();
        while (tokens.hasMoreTokens()) str[--tokenSize] = tokens.nextToken();
        EndMem[3] = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(((EndMem[0] - StartMem[0]) / 1000000) + " " + ((EndMem[1] - StartMem[1]) / 1000000) + " " + ((EndMem[2] - StartMem[2]) / 1000000) + " " + ((EndMem[3] - StartMem[3]) / 1000000));
        return str;
    }

    public static String[] tryThis(String filename) throws Exception{
            // Stack Initialization
        long numRand;
        BufferedReader docLength = new BufferedReader(new FileReader(filename));
        long Start = System.currentTimeMillis();
        for (numRand = 0; docLength.readLine() != null; numRand++);
        long End = System.currentTimeMillis();
        docLength.close();
        long numNeeded = ((new File(filename).length() / (numRand))) * numRand / 6;
        // ^ This guesses very quickly generally how many words there will be. It gets it pretty accurate but will be off.

        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic((int) numNeeded);
        System.out.println("Time: " + String.format("%12d", End - Start));
            // Stack Initialization

            // Read From File Then Write to Stack
        String line;
        Start = System.currentTimeMillis();

        BufferedReader doc = new BufferedReader (new FileReader(filename));
        while ((line = doc.readLine()) != null){
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) stack.push(tokens.nextToken().toLowerCase());
        }
        End = System.currentTimeMillis();
        System.out.println("Time: " + String.format("%12d", End - Start));
            // Read From File Then Write to Stack

            // Sort stack backwards
        Start = System.currentTimeMillis();
        String[] str = new String[stack.size()];
        for (int i = 0; stack.size() > 0; i++){
            str[i] = stack.pop();
        }
        End = System.currentTimeMillis();
        System.out.println("Time: " + String.format("%12d", End - Start));
            // Sort stack backwards
        return str;
    }

    static String[] cheddarCheese(String filename) throws Exception{
        StringBuilder SB = new StringBuilder();
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));

        while ((line = doc.readLine()) != null) SB.append(" ").append(line);
        doc.close();

        StringTokenizer tokens = new StringTokenizer(SB.toString());
        Stack2540ArrayDynamicCop stack = new Stack2540ArrayDynamicCop(tokens.countTokens(), true);

        while (tokens.hasMoreTokens())  stack.push(tokens.nextToken().toLowerCase());
        return stack.stack;
    }

    static String[] cheddarCheese2(String filename) throws Exception{
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic(13202283);
        while ((line = doc.readLine()) != null){
            for (String str: line.toLowerCase().split("[^a-z]+")){
                stack.push(str);
            }
        }
        for (int i = 0; i < (stack.size() / 2); i++){
            String temp = stack.stack[stack.size() - i - 1];
            stack.stack[stack.size() - i - 1] = stack.stack[i];
            stack.stack[i] = temp;
        }
        return stack.stack;
    }

    static String[] reverseDynamicBad(String filename) throws Exception{
        Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic();
        while (scanner.hasNext())
            stack.push(scanner.next().toLowerCase());

        int n=stack.size();
        String[] rev = new String[n];
        for (int i = 0; i < n; i++) {
            rev[i] = stack.pop();
        }
        return rev;
    }


    public static void main(String[] args) throws Exception{
        //String file = "Text.txt";
        String file = "dblp1280000.txt";
        Runtime runtime = Runtime.getRuntime();
        long Start = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        String[] rev = tryThis(file);
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long End = System.currentTimeMillis();
        long numSize = usedMemoryAfter - usedMemoryBefore;
        //for (String temp: rev)  numSize += (long) temp.length();
        String[] sizes = new String[]{"b", "kb", "mb", "gb", "tb"};
        long numSizeCopy = numSize;
        int bytes = 2;
        numSize /= 1000000;
//        while (numSize > 1024){
//            numSize /= 1024;
//            bytes++;
//        }
        System.out.println("Output: " + numSize + sizes[bytes] + " \tTime: " + String.format("%12d", End - Start));



        Start = System.currentTimeMillis();
        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        rev = tryThis(file);
        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        End = System.currentTimeMillis();
        numSize = usedMemoryAfter - usedMemoryBefore;
        //for (String temp: rev)  numSize += (long) temp.length();
        sizes = new String[]{"b", "kb", "mb", "gb", "tb"};
        numSizeCopy = numSize;
        bytes = 2;
        numSize /= 1000000;
        System.out.println("Output: " + numSize + sizes[bytes] + " \tTime: " + String.format("%12d", End - Start));

//        for (String str: rev){
//            System.out.print(str + " ");
//        }
//        System.out.println();


        Start = System.currentTimeMillis();
        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        rev = tryThis(file);
        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        End = System.currentTimeMillis();
        numSize = usedMemoryAfter - usedMemoryBefore;
        //for (String temp: rev)  numSize += (long) temp.length();
        sizes = new String[]{"b", "kb", "mb", "gb", "tb"};
        numSizeCopy = numSize;
        bytes = 2;
        numSize /= 1000000;
        System.out.println("Output: " + numSize + sizes[bytes] + " \tTime: " + String.format("%12d", End - Start));
    }
}
