import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//2200ms fileReading, 1300ms for hashing
public class TestReadSpeeds {

    public static void FirstTest(String PATH) throws Exception{
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = doc.readLine()) != null){
            String[] args = line.trim().split(" ");

            if (args[0].equals("")) continue;
            for (String Word : args) { }
        }
        doc.close();
    }

    public static void SecondTest(String PATH) throws Exception{
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);
        newMap map = new newMap(mapSize);
        String line;
        while ((line = doc.readLine()) != null){
            String[] args = line.trim().split(" ");

            if (args[0].equals("")) continue;
            for (String Word : args) map.add(Word.toLowerCase());

        }
        doc.close();
    }

    public static void ThirdTest(String PATH) throws Exception{
        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        StringBuilder SB = new StringBuilder();
        String line = "";
        while ((line = doc.readLine()) != null)
            SB.append(line);
        String[] temp = SB.toString().split(" ");
    }

    public static void FourthTest(String PATH) throws Exception{
        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        StringBuilder SB = new StringBuilder();
        String line = "";
        while ((line = doc.readLine()) != null)
            SB.append(line);
        doc.close();
        String[] temp = SB.toString().split(" ");
        newMap map = new newMap(temp.length);
        for (String tkn: temp) {
            if (tkn.equals("")) continue;
            map.add(tkn.toLowerCase());
        }

    }

    public static Integer FifthTest(String PATH) throws Exception{
        // Not Problem < 5ms
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);
        newMap map = new newMap(mapSize);
        String line;

        // Problem Split Between reading file and writing to map.
        while ((line = doc.readLine()) != null){
            String[] args = line.split(" ");

            for (String Word : args) {
                if (Word.equals("")) continue;
                map.add(Word.toLowerCase());
            }

        }
        // Not the Problem < 100 ms
        doc.close();
        int[] intArray = map.getArray();
        Arrays.sort(intArray);
        return intArray[intArray.length - 200];
    }

    public static Integer SixthTest(String PATH) throws Exception{

        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        StringBuilder SB = new StringBuilder();
        String line;
        while ((line = doc.readLine()) != null)
            SB.append(" " + line);
        doc.close();
        StringTokenizer st = new StringTokenizer(SB.toString());
        String[] temp = SB.toString().split(" ");
        newMap map = new newMap(temp.length);
        for (String tkn: temp) {
            if (tkn.equals("")) continue;
            map.add(tkn.toLowerCase());
        }
        int[] intArray = map.getArray();
        Arrays.sort(intArray);
        return intArray[intArray.length - 200];
    }

    public static Integer SeventhTest(String PATH) throws Exception{
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);
        newMap map = new newMap(mapSize);

        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        StringBuilder SB = new StringBuilder();
        String line;

        while ((line = doc.readLine()) != null)
            SB.append(" " + line);
        doc.close();
        StringTokenizer st = new StringTokenizer(SB.toString());
        while (st.hasMoreTokens()){
            map.add(st.nextToken().toLowerCase());
        }
        int[] intArray = map.getArray();
        Arrays.sort(intArray);
        return intArray[intArray.length - 200];
    }

    public static void main(String[] args) throws Exception{
        String PATH = "Files/Folder/dblp2560000.txt";
        long startTime;
        long endTime;
        String time;
        int Answer;

        startTime = System.currentTimeMillis();
        FirstTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("FirstTest:  \ttime=" + time + ".");


        startTime = System.currentTimeMillis();
        SecondTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("SecondTest: \ttime=" + time + ".");


        startTime = System.currentTimeMillis();
        Answer = FifthTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("FifthTest:  \ttime=" + time + ". \tAnswer: " + Answer + "\n");


        startTime = System.currentTimeMillis();
        ThirdTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("ThirdTest:  \ttime=" + time + ".");


        startTime = System.currentTimeMillis();
        FourthTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("FourthTest: \ttime=" + time + ".");


        startTime = System.currentTimeMillis();
        Answer = SixthTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("SixthTest:  \ttime=" + time + ". \tAnswer: " + Answer + "\n");


        startTime = System.currentTimeMillis();
        Answer = SeventhTest(PATH);
        endTime = System.currentTimeMillis();
        time = String.format("%12d", endTime - startTime);
        System.out.println("SeventhTest: \ttime=" + time + ". \tAnswer: " + Answer + "\n");
    }
}
