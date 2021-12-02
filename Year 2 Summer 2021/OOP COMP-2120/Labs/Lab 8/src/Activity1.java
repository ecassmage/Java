import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Activity1 {
    public static void main(String[] args) throws IOException {
        Activity1 A = new Activity1();
        FileWriter FW = (FileWriter) A.openFile("hello.txt", true);
        FW.write("Hello, World!");  // These are some Really weird quotation marks hmm.
        FW.close();
        Object[] str = A.ReadLines((FileReader) A.openFile("hello.txt", false));
        for (Object string : str){
            System.out.println(string);
        }
    }

    // Opens a File. Dunno just more Sorted, It can Open as a Read or Write File.
    public Object openFile(String arg, boolean openWriteFile) {
        try{
            return openWriteFile ? new FileWriter(arg): new FileReader(arg);
        }// I don't like to use throw
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e.toString());
            System.exit(0);
        }
        return null;
    }

    // This Reads the Lines and adds them to an array, Like Python
    public Object[] ReadLines(FileReader FR){
        Scanner S = new Scanner(FR);
        ArrayList<String> str = new ArrayList<>();
        while (true){
            try{ str.add(S.nextLine()); } catch (NoSuchElementException e){break;}
        }
        return str.toArray();
    }
}
