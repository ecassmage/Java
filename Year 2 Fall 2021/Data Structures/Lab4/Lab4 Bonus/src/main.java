import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.StringTokenizer;

public class main {
    public static AbstractMap.SimpleEntry<String, Integer> countHash(String[] tokens){
        HashMap2540<String, Integer> map = new HashMap2540<String, Integer>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            Integer freq = map.get(token);
            if (freq == null)
                map.put(token, 1);
            else
                map.put(token, freq + 1);
        }

        int max = 0;
        String maxWord="";
        for (String k : map.keys())
            if (map.get(k) > max){
                max = map.get(k);
                maxWord=k;
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
        String[] arg = getArray("strings.txt");
        long endArg = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg));


        long startHash = System.currentTimeMillis();
        AbstractMap.SimpleEntry<String, Integer> temp = countHash(arg);
        long endHash = System.currentTimeMillis();
        System.out.println("Time For split: " + String.format("%5d", endArg - startArg) + "\tTime for Hash: " + String.format("%5d", endHash - startHash));
        System.out.println("Word: " + temp.getKey() + "\tValue: " + temp.getValue());
    }
}
