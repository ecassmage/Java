import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

    public static String[] test(String filename) throws Exception{
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

    public static String getString(byte[] arr, int start, int end){
        StringBuilder sb = new StringBuilder(end - start);
        for (int i = start; i < end; i++){
            if (65 <= arr[i] && arr[i] <= 90) sb.append((char) (arr[i] + 32));
            else sb.append((char) arr[i]);
        }
        return sb.toString();
    }

    public static String[] reverseDynamic(String filename) throws Exception{
        byte[] bytes = Stack2540ArrayDynamic.getBytes(filename);
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic((int) new File(filename).length() / 7);
        int start = 0;
        int end = 0;
        for (int i = 0; i < bytes.length; i++){
            end = i;
            if (bytes[i] == 32 || bytes[i] == 10){
                if (start < end)    stack.push(getString(bytes, start, end));
                start = i+1;
            }
        }
        if (start < end+1) stack.push(getString(bytes, start, end));

        String[] arr = new String[stack.size()];
        int i = stack.size();
        while (stack.size() > 0) arr[i - stack.size()] = stack.pop();

        return arr;
    }
    
    public static void main(String[] args) throws Exception{
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        //String[] str1 = test("dblp1280000.txt");
        String[] str2 = reverseDynamic("dblp1280000.txt");

//        for (int i = 0; i < str1.length; i++){
//            if (!(str1[i].equals(str2[i]))){
//                System.out.println(str1[i] + " " + str2[i]);
//            }
//        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long numSize = usedMemoryAfter - usedMemoryBefore;
        numSize /= 1000000;
        System.out.println("Output: " + numSize + "Mb");
    }
}
