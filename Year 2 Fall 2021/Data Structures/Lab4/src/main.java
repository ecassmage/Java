import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class main {
    public static AbstractMap.SimpleEntry<String, Integer> countHash(String[] tokens){
        //long start1 = System.currentTimeMillis();
        HashMap2540<String, Integer> map = new HashMap2540<String, Integer>((int) Math.ceil(tokens.length * 1.3));
        //int len = tokens.length;
        HashMap2540.NodeLinked.Node node = null;
        for (String str: tokens){
            //if (str.equals(tokens[1])) continue;
            if ((node = map.containsKeyCollect(str)) != null)
                node.plusOne();  // Should reduce for loop checks by a little bit.
            else    map.put(str, 1);
        }
        //long end1 = System.currentTimeMillis();
        //long start2 = System.currentTimeMillis();
        int max = 0;
        String maxWord="";
        for (String k : map.keys()){
            //System.out.println(k);
            if (map.get(k) > max){
                max = map.get(k);
                maxWord=k;
            }
        }
        //long end2 = System.currentTimeMillis();
        //System.out.println("Time1: " + String.format("%12d", end1 - start1) + " \tTime2: " + String.format("%12d", end2 - start2));
        return new AbstractMap.SimpleEntry<String, Integer>(maxWord, max);
    }

    public static AbstractMap.SimpleEntry<String, Integer> countHash2(String[] tokens){
        newHash<String, Integer> map = new newHash<String, Integer>();
        int len = tokens.length;
        for (String str: tokens){
            Integer freq = map.get(str);
            if (freq == null) freq = 0;
            map.put(str, freq + 1);
        }

        int max = 0;
        String maxWord="";
        for (String k : map.keys())
            if (map.get(k) > max){
                max = map.get(k);
                maxWord=k;
            }
        //System.out.println("Empty Ratio: " +  String.format("%2f", 100 * ((double) map.Uniques / ((double) map.sizeOfMap / 2))));
        return new AbstractMap.SimpleEntry<String, Integer>(maxWord, max);
    }

    public static AbstractMap.SimpleEntry<String, Integer> countHash3(String[] tokens){
        HashMap<String, Integer> map = new HashMap<>(tokens.length);

        for (String token: tokens){
            HashMap.Link.Node node = map.getNode(token);
            if (node == null)   map.put(token, 1);
            else    node.setValue();
        }

        int max = 0;
        String maxWord="";
        for (HashMap.Link token: map.list){
            if (token == null) continue;
            for (HashMap.Link.Node node: token.getArray()){
                if ((int) node.getValue() > max){
                    max = (int) node.getValue();
                    maxWord = (String) node.getKey();
                }
            }
        }

        return new AbstractMap.SimpleEntry<String, Integer>(maxWord, max);
    }

    public static String[] getArray(String PATH) throws Exception{
        StringBuilder SB = new StringBuilder();
        String line;

        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        while ((line = doc.readLine()) != null) SB.append(" ").append(line);  // There is a really annoying warning when these are in same append method
        doc.close();

        StringTokenizer tokens = new StringTokenizer(SB.toString());
        String[] arr = new String[tokens.countTokens()];
        for (int i = 0; tokens.hasMoreTokens(); i++){
            arr[i] = tokens.nextToken();
        }
        return arr;
    }

    public static void main(String[] args) throws Exception{

        long startArg = System.currentTimeMillis();
        String[] arg = getArray("largeFile.txt");
        long endArg = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg));

        long startHash = System.currentTimeMillis();
        AbstractMap.SimpleEntry<String, Integer> temp = countHash(arg);
        long endHash = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg) + "\tTime for Hash: " + String.format("%5d", endHash - startHash));
        System.out.println("Word: " + temp.getKey() + "\tValue: " + temp.getValue());

        startHash = System.currentTimeMillis();
        temp = countHash2(arg);
        endHash = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg) + "\tTime for Hash: " + String.format("%5d", endHash - startHash));
        System.out.println("Word: " + temp.getKey() + "\tValue: " + temp.getValue());

        startHash = System.currentTimeMillis();
        temp = countHash3(arg);
        endHash = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg) + "\tTime for Hash: " + String.format("%5d", endHash - startHash));
        System.out.println("Word: " + temp.getKey() + "\tValue: " + temp.getValue());
    }
}
