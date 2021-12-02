/**
 * A2 starter code for 2540, 2020.
 * Author: Jianguo Lu
 * The purpose is to understand sorting algorithms and their performances.
 * It prints out the frequency of the 200-th most frequent word.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


public class A22 {

    public static void selectionSort(String[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[minIndex].compareTo(data[j]) < 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex)
                swap(data, minIndex, i);

        }
    }

    public static void insertionSort(String[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            String cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1].compareTo(cur) > 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }
    }

    /** Merge two strings. See the textbook for explanation. **/
    public static void merge(String[] S1, String[] S2, String[] S) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }
    }

    public static void mergeSort(String[] S) {
        int n = S.length;
        if (n < 2)
            return;
        int mid = n / 2;
        // partition the string into two strings
        String[] S1 = Arrays.copyOfRange(S, 0, mid);
        String[] S2 = Arrays.copyOfRange(S, mid, n);
        mergeSort(S1);
        mergeSort(S2);
        merge(S1, S2, S);
    }

    private static void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static Integer count_ARRAY_SORT(String[] tokens, String sortMethod) {

        if (sortMethod.equals("SELECT"))
            selectionSort(tokens);
        else if (sortMethod.equals("INSERT"))
            insertionSort(tokens);
        else if (sortMethod.equals("MERGE"))
            mergeSort(tokens);
        else
            System.out.println(sortMethod + " sorting method does not exist.");

        int CAPACITY = 1000000;
        String[] words = new String[CAPACITY];
        int[] counts = new int[CAPACITY];
        int j = 0, k = 0;
        int len = tokens.length;
        while (j < len - 1) {
            int duplicates = 1;
            while (j < len - 2 & tokens[j].equals(tokens[j + 1])) {
                j++;
                duplicates++;
            }

            words[k] = tokens[j];
            counts[k] = duplicates;
            j++;
            k++;
        }

        String[] copyOfWords=new String[k];
        Integer[] copyOfCounts=new Integer[k];

        for (int i=0; i<k; i++) {
            copyOfCounts[i]=counts[i];
        }

        Arrays.sort(copyOfCounts);

        return copyOfCounts[k-200];
    }

    static String[] readText(String PATH) throws Exception {
        Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
        // tokenize text. any characters other than English letters(a-z and A-Z) are delimiters.
        int length = 0;
        while (doc.hasNext()) {
            doc.next();
            length++;
        }

        String[] tokens = new String[length];
        Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
        length = 0;
        while (s.hasNext()) {
            tokens[length] = s.next().toLowerCase();
            length++;
        }
        doc.close();
        return tokens;
    }

    static Integer FullCustom(String PATH) throws Exception {

//        long startTime = System.currentTimeMillis();
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);
//        System.out.println("Size of Token FullCustom: " + mapSize);
        newMap map = new newMap(mapSize);
        String line;
        while ((line = doc.readLine()) != null) {
            String[] args = line.trim().split("[^a-zA-Z]+");
            if (args[0].equals("")) continue;
            for (String Word : args) {
                map.add(Word.toLowerCase());
            }
        }
        doc.close();
//        long done = System.currentTimeMillis();
//        System.out.println(PATH + " \tTime Before Sort: " + (done - startTime));
        int[] list = map.getArray();
        Arrays.sort(list);
//        System.out.println("Time After Sort: " + (System.currentTimeMillis() - startTime) + " Difference: " + (System.currentTimeMillis() - done) + '\n');
        return list[list.length - 200];
    }
    static Integer Full(String PATH) throws Exception {
        long startTime = System.currentTimeMillis();
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int num = 1000;
        if (arg.length == 2)    num = Integer.parseInt(arg[1]);
//        System.out.println("Size of Token Full: " + num);
        HashMap<String, Integer> map = new HashMap<>(num);
        String line;
        while ((line = doc.readLine()) != null) {
            for (String Word : line.toLowerCase().split("[^a-z]+")) { // Regex only deals with a-z since it is set to lower case before it is called so A-Z is irrelevant.
                if (map.containsKey(Word)) map.put(Word, map.get(Word) + 1);
                else map.put(Word, 1);
            }
        }
        long done = System.currentTimeMillis();
//        System.out.println(PATH + " \tTime Before Sort: " + (done - startTime));
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(null);
        doc.close();
//        System.out.println("Time After Sort: " + (System.currentTimeMillis() - startTime) + " Difference: " + (System.currentTimeMillis() - done) + '\n');
        return list.toArray(new Integer[0])[list.size() - 200];
    }

    public static void main(String[] args) throws Exception {
        String PATH = "Files/Folder/dblp";
        String[] METHODS = {};
        String[] DATASETS = {"1280000"};//, "10k","100k"}; //, "5k", "10k", "100k", "1m", "" };
        // "200", "400","800","1600","3200","6400", "10000","20000","40000", "80000","160000", "320000", "640000",
        String[] tokens;
        // run the experiments on different data sets
        for (int j = 0; j < DATASETS.length; j++) {
            // run the experiments using different methods
            System.out.println("Data is " + DATASETS[j]);
            for (int i = 0; i < METHODS.length + 2; i++) {
                if (i == METHODS.length){
                    long startTime = System.currentTimeMillis();
                    Integer _200th_freq = FullCustom(PATH + DATASETS[j] + ".txt");
                    long endTime = System.currentTimeMillis();
                    String time = String.format("%12d", endTime - startTime);
                    System.out.println("FullC\t" + " method\t time=" + time + ".\t 200th freq is " + _200th_freq);
                }
                else if (i == METHODS.length + 1){
                    long startTime = System.currentTimeMillis();
                    Integer _200th_freq = Full(PATH + DATASETS[j] + ".txt");
                    long endTime = System.currentTimeMillis();
                    String time = String.format("%12d", endTime - startTime);
                    System.out.println("Full\t" + " method\t time=" + time + ".\t 200th freq is " + _200th_freq);
                }
                else{
                    tokens = readText(PATH + DATASETS[j] + ".txt");
                    long startTime = System.currentTimeMillis();
                    Integer _200th_freq= A2.messOfStuffBetter(tokens);
                    long endTime = System.currentTimeMillis();
                    String time = String.format("%12d", endTime - startTime);
                    System.out.println(METHODS[i] + "\t method\t time=" + time + ".\t 200th freq is " + _200th_freq);
                }
            }
        }
    }
}
