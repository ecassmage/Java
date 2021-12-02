import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FirstLetterMap {
    HashMap<Character, ArrayList<String>> Map;

    public static void main(String[] args){
        // I missed the input file part originally so I thought we were supposed to format a string given.

        if (new File("test1.txt").exists()){
            FirstLetterMap F1 = new FirstLetterMap("test1.txt");
            System.out.println(F1);
        }
        if (new File("test3.txt").exists()){
            FirstLetterMap F2 = new FirstLetterMap("test3.txt");
            System.out.println(F2);
        }
        if (new File("test2.txt").exists()){
            FirstLetterMap F3 = new FirstLetterMap("test2.txt");
            System.out.println(F3);
        }
        else {
            // If the TA wants to test this program themselves but don't got the test files on hand this will just input a test string for them.
            FirstLetterMap F = new FirstLetterMap("She took down a jar from one of the shelves as she passed; it was labelled 'ORANGE MARMALADE', but to her great disappointment it was empty.");
            System.out.println(F);
        }

    }


    public FirstLetterMap(){ this.Map = new HashMap<>(); }
    public FirstLetterMap(String string){
        this();
        if (new File(string).exists())  ImportFile(string);
        else                            MapString(string);
    }

    public void ImportFile(String string){
        try{
            FileReader FR = new FileReader(string);
            Scanner S = new Scanner(FR);
            String str = "";
            while (S.hasNext()) str = str.concat(S.next() + " ");
            MapString(str);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    private boolean ExistsIn(ArrayList<String> list, String word){
        for (String str: list){
            if (str.equals(word)) return true;
        }
        return false;
    }

    public void MapString(String string){
        String strToRemove = "`~!@#$%^&*()-_+[{]}\\|;:'\",<.>/?\n\b\t\r\f";  // All Characters to Remove
        for (char c: strToRemove.toCharArray()) string = string.replace(Character.toString(c), " ");
        string = string.toLowerCase();
        String[] array = string.split(" ");
        for (String str: array){
            str = str.replace(" ", "");  // Make sure Spaces don't get through, Shouldn't be possible but safety is better then not.
            if (str.length() == 0) continue;  // double spaces can appear and .split will split these spaces into three with one guaranteed being empty. This is a way to fix that.
            if (Map.containsKey(str.charAt(0))) {
                if (!ExistsIn(Map.get(str.charAt(0)), str)) Map.get(str.charAt(0)).add(str);
            }
            else {
                Map.put(str.charAt(0), new ArrayList<>());
                Map.get(str.charAt(0)).add(str);
            }
        }
    }

    public String toString(){
        // Outputs the Proof This either worked or at least did something.
        String str = "";
        for (char c = 'a'; c != 'z' + 1; c++)
            if (Map.containsKey(c)) {
                Map.get(c).sort(null);
                str = str.concat(c + ": " + Map.get(c).toString() + "\n");
            }
        return str;
    }
}
