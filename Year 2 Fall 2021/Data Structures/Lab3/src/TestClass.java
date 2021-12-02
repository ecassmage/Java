import java.io.File;
import java.util.Scanner;

public class TestClass {

    public static String getString(byte[] arr, int start, int end){
        StringBuilder sb = new StringBuilder(end - start);
        for (int i = start; i < end; i++){
            if (65 <= arr[i] && arr[i] <= 90) sb.append((char) (arr[i] + 32));
            else sb.append((char) arr[i]);
        }
        return sb.toString();
    }

    static String[] reverseDoubling(String filename) throws Exception {
        byte[] bytes = StackDoubling.getBytes(filename);
        StackDoubling stack = new StackDoubling();
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
    static String[] reverseConstant(String filename) throws Exception {
        byte[] bytes = StackConstant.getBytes(filename);
        StackConstant stack = new StackConstant();
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
        String PATH = "Files/Folder/dblp";
        String[] DATASETS = {"200", "400", "800", "1600", "3200", "6400", "10000", "20000", "40000", "80000", "160000", "320000", "640000", "1280000", "2560000"};
        boolean bool = false;
        for (String set: DATASETS){
            System.out.println("DataSet: " + PATH + set + ".txt");
            long Start = System.currentTimeMillis();
            String[] Array = reverseDoubling(PATH + set + ".txt");
            long End = System.currentTimeMillis();
            System.out.println("Doubling Dynamic: \tTime: " + String.format("%12d", End - Start));

            if (bool || set.equals("640000")) {
                bool = true;
                continue;
            }

            Start = System.currentTimeMillis();
            Array = reverseConstant(PATH + set + ".txt");
            End = System.currentTimeMillis();
            System.out.println("Constant Dynamic: \tTime: " + String.format("%12d", End - Start));
        }

    }
}
