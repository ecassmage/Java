import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    static String[] temp(String PATH) throws Exception{
        Scanner s = new Scanner(new File(PATH));
        StringBuilder SB = new StringBuilder();
        while (s.hasNext()){
            SB.append(s.nextLine().trim());
        }
        return SB.toString().trim().split("[^a-zA-Z]+");
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

    static Integer FullCustom(String PATH) throws Exception {

        class newMap {
            private Node[] list;
            private int size;

            private int UniqueEntries = 0;

            public newMap(int capacity){
                this.size = (int) Math.ceil(capacity * 1.2);
                this.list = new Node[size];
            }

            public void add(String word){
                long hash = Math.abs(word.hashCode());
                if (list[(int) (hash % size)] == null)  {
                    list[(int) (hash % size)] = new Node(null, word);
                    UniqueEntries++;
                }
                else UniqueEntries += list[(int) (hash % size)].add(word);
            }

            public int[] getArray(){
                int position = 0;
                int[] arr = new int[UniqueEntries];

                for (int i = 0; i < size; i++) {
                    if (list[i] == null) continue;
                    position = list[i].addToList(arr, position);
                }

                return arr;
            }


            class Node{
                private Node next;
                private String word;
                private int Occurrences;


                public Node(Node Connection, String word){
                    this.next = null;
                    if (Connection != null) Connection.next = this;

                    this.word = word;
                    this.Occurrences = 1;
                }

                public int add(String word){
                    Node ptr = this;
                    while (ptr.next != null) {
                        if (ptr.word.equals(word)){
                            ptr.Occurrences++;
                            return 0;
                        }
                        ptr = ptr.next;
                    }
                    new Node(ptr, word);  // the New node should get saved to ptr
                    return 1;
                }

                public int addToList(int[] list, int position){
                    Node ptr = this;
                    while (ptr.next != null){
                        list[position++] = ptr.Occurrences;
                        ptr = ptr.next;
                    }
                    return position;
                }
            }
        }

//        long startTime = System.currentTimeMillis();
        BufferedReader doc = new BufferedReader(new FileReader(PATH));
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);
//        System.out.println("Size of Token FullCustom: " + mapSize);
        newMap map = new newMap(mapSize);
        String line;
        while ((line = doc.readLine()) != null) {
            for (String Word : line.toLowerCase().split("[^a-z]+"))  // Regex only deals with a-z since it is set to lower case before it is called so A-Z is irrelevant.
                map.add(Word);
        }
        doc.close();
//        long done = System.currentTimeMillis();
//        System.out.println(PATH + " \tTime Before Sort: " + (done - startTime));
        int[] list = map.getArray();
        Arrays.sort(list);
//        System.out.println("Time After Sort: " + (System.currentTimeMillis() - startTime) + " Difference: " + (System.currentTimeMillis() - done) + '\n');
        return list[list.length - 200];
    }

    public static void main(String[] args) throws Exception{
        String PATH = "Files/Folder/dblp1280000.txt";
        int numFull = Full(PATH);
        int numFullCustom = FullCustom(PATH);
        int read = A2.read(PATH);
        System.out.println("Answers = " + numFull + " " + numFullCustom + " " + read);
        long startTime = System.currentTimeMillis();
        String[] tokens = temp(PATH);
        System.out.println("Size of Token String Array: " + tokens.length);
        Integer _200th_freq = A2.messOfStuffSlow(tokens);
        long endTime = System.currentTimeMillis();
        String time = String.format("%12d", endTime - startTime);
        System.out.println("time=" + time + ".\t 200th freq is " + _200th_freq);

    }
}
