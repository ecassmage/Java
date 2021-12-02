import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class newSplicer {
    public static String[] tryThis(String filename) throws Exception{
        long numRand;
        BufferedReader docLength = new BufferedReader(new FileReader(filename));
        for (numRand = 0; docLength.readLine() != null; numRand++);
        docLength.close();
        long num = new File(filename).length();
        long numNeeded = (num / numRand) * (numRand / 6);
        numRand = 10;
        double numNeeded2 = ( (double) num / numRand) * ((double) numRand / 6);
        double numNeeded3 = ( (double) num / 6);
        //System.out.println((int) numNeeded + " " + (int) (num / 6) + " " + numNeeded2 + " " + numNeeded3);
        System.out.println((int) (num / 5));
        System.out.println((int) (num / 6));
        System.out.println((int) (num / 7));
        System.out.println((int) (num / 7.3));
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic((int) numNeeded);
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        while ((line = doc.readLine()) != null){
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) stack.push(tokens.nextToken().toLowerCase());
        }
        String[] str = new String[stack.size()];
        for (int i = 0; stack.size() > 0; i++)  str[i] = stack.pop();

        return str;
    }
    public static String[] tryThis2(String filename) throws Exception{
        int num = (int) (((new File(filename).length())) / 5);
        BufferedReader docLength = new BufferedReader(new FileReader(filename));
        docLength.close();
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic(num);
        String line;
        BufferedReader doc = new BufferedReader (new FileReader(filename));
        while ((line = doc.readLine()) != null){
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) stack.push(tokens.nextToken().toLowerCase());
        }
        String[] str = new String[stack.size()];
        for (int i = 0; stack.size() > 0; i++)  str[i] = stack.pop();

        return str;
    }

    public static void main(String[] args) throws Exception {
        //String file = "Text.txt";
        String file = "dblp1280000.txt";
        Runtime runtime = Runtime.getRuntime();
        long Start = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        tryThis(file);
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long End = System.currentTimeMillis();
        long numSize = usedMemoryAfter - usedMemoryBefore;
        numSize /= 1000000;
        System.out.println("Output: " + numSize + "MB \tTime: " + String.format("%12d", End - Start));
    }
}
