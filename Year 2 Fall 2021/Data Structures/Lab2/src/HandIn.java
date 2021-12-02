import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HandIn {

    static class MAP {

        private final Node[] list;
        private final int size;

        private int UniqueEntries = 0;

        public MAP(int capacity){
            this.size = (int) Math.ceil(capacity * 1.25);
            this.list = new Node[size];
        }

        public void add(String word){
            int hash = Math.abs(word.hashCode()) % size;

            if (list[hash] == null)  {
                list[hash] = new Node(null, word);
                UniqueEntries++;
            }
            else UniqueEntries += list[hash].add(word);

        }

        public int[] getArray(){
            int position = 0;
            int[] arr = new int[UniqueEntries];

            for (int i = 0; i < size; i++) {
                if (list[i] == null) {
                    continue;
                }
                position = list[i].addToList(arr, position);
            }
            int[] newArr = new int[position];
            System.arraycopy(arr, 0, newArr, 0, position);
            return newArr;
        }


        static class Node{
            private Node next;
            private final String word;
            private int Occurrences = 1;


            public Node(Node Connection, String word){
                this.next = null;
                if (Connection != null) Connection.next = this;

                this.word = word;
            }

            public int add(String word){
                Node ptr = this;
                while (true) {
                    if (ptr.word.equals(word)){
                        ptr.Occurrences++;
                        return 0;
                    }
                    if (ptr.next == null) break;
                    ptr = ptr.next;
                }
                new Node(ptr, word);
                return 1;
            }

            public int addToList(int[] list, int position){
                Node ptr = this;
                while (ptr != null){
                    list[position++] = ptr.Occurrences;
                    ptr = ptr.next;
                }
                return position;
            }
        }
    }

    public static int hashMapSize(String PATH){
        String[] arg = (new Scanner(PATH)).nextLine().split("[^0-9]+");
        int mapSize = 1000000;  // For if the line number is not found cleanly in PATH name
        if (arg.length == 2)    mapSize = Integer.parseInt(arg[1]);  // arg[0] will probably be "" so we skip it
        return mapSize;
    }

    public static StringTokenizer buildIterableArray(String PATH) throws Exception{
        StringBuilder SB = new StringBuilder();
        String line;

        BufferedReader doc = new BufferedReader (new FileReader(PATH));
        while ((line = doc.readLine()) != null) SB.append(" ").append(line.toLowerCase());  // There is a really annoying warning when these are in same append method
        doc.close();

        return new StringTokenizer(SB.toString());
    }

    public static int _200th_Inside_Map(MAP map){
        int[] intArray = map.getArray();
        Arrays.sort(intArray);
        return intArray[intArray.length - 200];
    }

    public static Integer countFAST(String PATH) throws Exception{
        MAP map = new MAP(hashMapSize(PATH));  // Creates a map based on hashMapSize for capacity

        StringTokenizer tokens = buildIterableArray(PATH);
        while (tokens.hasMoreTokens())  map.add(tokens.nextToken());

        return _200th_Inside_Map(map);
    }


    public static void main(String[] args) throws Exception{
        String PATH = "Files/Folder/dblp1280000.txt";
        Integer _200th_freq = countFAST(PATH);
        System.out.println(_200th_freq);
    }
}
