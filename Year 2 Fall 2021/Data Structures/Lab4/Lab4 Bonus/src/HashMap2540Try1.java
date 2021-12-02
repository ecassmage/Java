import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HashMap2540Try1<K, V> {

    private static final int DEFAULTINITIALCAPACITY = 524288;
    private static final double LOADFACTOR = 0.75;


    private int sizeOfMap;
    private int size;
    private DictLinkList<K, V> list[];


    public HashMap2540Try1(int Capacity){
        this.sizeOfMap = Capacity;
        this.size = 0;
        this.list = new DictLinkList[sizeOfMap];
    }
    public HashMap2540Try1(){
        this(DEFAULTINITIALCAPACITY);
    }

    private int getHash(K key){
        return Math.abs(key.hashCode());
    }

    private int hash(int key){
        return (int) (key % sizeOfMap);
    }
    private int hash(K key){
        return (int) (getHash(key) % sizeOfMap);
    }

    private boolean containsNodes(int index){
        return !(list[index] == null);
    }
    public V get(K key){
        int hash = hash(key);
        if (containsNodes(hash)) return list[hash].get(key);
        return null;
    }

    private void put(DictLinkList.Node node){
        int hash = hash(node.hash);
        if (containsNodes(hash))  list[hash].put(node);
        list[hash] = new DictLinkList<K, V>(node);
        size++;
    }
    private void put(K key, V value, int hashCode){
        int hash = hash(hashCode);
        if (containsNodes(hash))  {
            size += list[hash].put(key, value, hashCode);
            return;
        }
        list[hash] = new DictLinkList<K, V>(new DictLinkList.Node(key, value, null, hashCode));
        size++;
    }
    public void put(K key, V value){
        put(key, value, getHash(key));
    }

    public LinkedList<K> keys() {
        LinkedList<K> queue = new LinkedList<K>();
        for (int i = 0; i < sizeOfMap; i++) {
            if (!containsNodes(i)) continue;
            for (DictLinkList.Node node = list[i].getKeys(); node != null; node = node.next) {
                queue.add((K) node.key);
            }
        }
        return queue;
    }

    private void resize(){
        if (LOADFACTOR * size > sizeOfMap){
            HashMap2540Try1<K, V> temp = new HashMap2540Try1(sizeOfMap * 2);
            for (int i = 0; i < sizeOfMap; i++){
                if (containsNodes(i)) {
                    for (DictLinkList.Node node = list[i].getKeys(); node != null; node = node.next) temp.put(node);
                }
            }
            this.list = temp.list;
            this.sizeOfMap = temp.sizeOfMap;
            this.size = temp.size;
        }
    }


    private static class DictLinkList<K, V> {
        private Node<K, V> first;
        private int size = 0;

        public DictLinkList(Node node){
            this.first = node;
            this.first.next = null;
            this.size = 1;
        }

        public V get(K key){
            for (Node ptr = first; ptr != null; ptr = ptr.next) if (ptr.equals(key)) return (V) ptr.value;
            return null;
        }
        private void put(Node node){
            node.next = first;
            first = node;
            size++;
        }
        public int put(K key, V value, int hash){
            for(Node ptr = first; ptr != null; ptr = ptr.next) {
                if (ptr.equals(key)) {
                    ptr.value = value;
                    return 0;
                }
            }
            first = new Node(key, value, first, 0);
            size++;
            return 1;
        }

        public Node getKeys(){
            return first;
        }


        private static class Node<K, V>{
            private int hash;  // hash stored for quicker resizing as hash will never change just the remainder will.

            private Node next;
            private K key;
            private V value;

            public Node(K key, V value, Node next, int hash){
                this.next = next;
                this.key = key;
                this.value = value;
                this.hash = hash;
            }
            public boolean equals(String ptr){
                return key.equals((String) ptr);
            }
        }
    }

    public static AbstractMap.SimpleEntry<String, Integer> countHash(String[] tokens){
        HashMap2540Try1<String, Integer> map = new HashMap2540Try1<String, Integer>();
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
        String[] array = getArray("stringsC.txt");
        countHash(array);
    }
}
