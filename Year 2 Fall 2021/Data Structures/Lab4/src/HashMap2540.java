import java.util.Arrays;
import java.util.LinkedList;

public class HashMap2540 <K, V> {
    private static final int defaultCapacity = 64;
    private final int initialCapacity;
    private static final double loadFactor = 0.75;
    private int sizeOfMap;
    private int length;

    private int[] informations;

    private NodeLinked<K, V>[] list;

    public HashMap2540(int Capacity){
        this.list = new NodeLinked[Capacity];
        this.sizeOfMap = Capacity;
        this.initialCapacity = Capacity;
        this.length = 0;
        this.informations = new int[]{0, 0};
    }

    public HashMap2540(){
        this(defaultCapacity);
    }

//    private static int hashCode(String s) {
//        int hash=0;
//        for (int i=0; i<s.length( ); i++) {
//            hash = (hash << 5) | (hash >>> 27);
//            hash += (int) s.charAt(i);
//        }
//        return hash;
//    }

    private int hashCode(String s) {
        int hash = 7;
        int base=31;
        for (int i = 0; i < s.length(); i++)
            hash = (int) Math.abs(base * (s.charAt(i) + hash));
        return hash;
    }

    private int getHash(K key){
        return Math.abs(hashCode((String) key) % sizeOfMap);
        //return Math.abs((int)(key.hashCode() % this.sizeOfMap));
    }
    public void putFast(K key, V value){
        int hash = getHash(key);
        if (containsKeys(hash)) if (list[hash].put(key, value)) length++;
        else{
            list[hash] = new NodeLinked<>(key, value);
            length++;
        }
    }

    public void put(K key, V value){
        //resize();
        if (value==null) delete(key);
        else {
            int hash = getHash(key);
            if (containsKeys(hash)){
                if (list[hash].put(key, value)) {
                    length++;
                }
            }
            else{
                list[hash] = new NodeLinked<>(key, value);
                length++;
                informations[1]++;
            }
            informations[0]++;
        }
    }

    private boolean containsKeys(int index){
        return list[index] == null ? false : true;
    }

    public boolean containsKey(K key){
        int hash = getHash(key);
        if (!containsKeys(hash)) return false;
        return list[hash].containsKey(key);
    }

    public NodeLinked.Node containsKeyCollect(K key){
        int hash = getHash(key);
        if (!containsKeys(hash)) return null;
        NodeLinked.Node temp = list[hash].containsKeyCollect(key);
        if ((int) temp.getValue() == 0) length++;
        return temp;
    }

    public V get(K key){
        return list[getHash(key)].getValue(key);
    }

    private HashMap2540<K, V> grow(){
        return new HashMap2540<>(sizeOfMap * 2);
    }
    private HashMap2540<K, V> shrink(){
        return new HashMap2540<>(sizeOfMap / 2);
    }

    private void resize(){
        HashMap2540<K, V> temp;
        if (length >= sizeOfMap * loadFactor)   temp = grow();
        else if (length > sizeOfMap && length * 4 < sizeOfMap * loadFactor) temp = shrink();
        else return;


        for (int i = 0; i < sizeOfMap; i++) {
            if (containsKeys(i))
                for (Object key : list[i].getKeys())
                    temp.put((K) key, list[i].getValue((K) key));
        }

        this.list = temp.list;
        this.length = temp.length;
        this.sizeOfMap = temp.sizeOfMap;
    }

    public void delete(K key){
        length--;
        list[getHash(key)].delete(key);
        //resize();
    }

    public LinkedList<K> keys() {
        LinkedList<K> queue = new LinkedList<>();
        for (int i = 0; i < sizeOfMap; i++) {
            if (containsKeys(i))
                for (Object key : list[i].getKeys())
                    queue.add((K) key);
        }
        return queue;
    }

    public class NodeLinked<K, V>{
        private int size = 0;

        private Node first;
        private Node last;
        
        public NodeLinked(K key, V value){
            Node newNode = new Node(null, key, value);
            this.first = newNode;
            this.last = newNode;
            size = 1;
        }

        private boolean put(K key, V value){
            if (value == null){
                delete(key);
                return false;
            }
            Node ptr = first;
            for (; ptr.next != null && ptr.key != key; ptr = ptr.next);
            if (ptr.key.equals(key)) {
                ptr.value = value;
                return false;
            }
            else{
                ptr.next = new Node(null, key, value);
                size++;
                return true;
            }
        }

        public V getValue(K key){
            Node ptr = first;
            for (; ptr.key != null && !ptr.key.equals(key); ptr = ptr.next);
            return ptr == null ? null : (V) ptr.value;
        }


        public Object[] getKeys(){
            Object[] list = new Object[size];
            Node ptr = first;
            for (int i = 0; ptr != null; ptr = ptr.next, i++)   list[i] = ptr.key;
            return list;
        }

        public <U> K[] getKeys(K[] array){
            K[] list = Arrays.copyOf(array, size);  // A little cheat I think arraylist uses for toArray.
            Node ptr = first;
            for (int i = 0; ptr != null; ptr = ptr.next, i++)   list[i] = (K) ptr.key;
            return list;
        }

        private void delete(K key){
            if (first.key.equals(key)){
                first = first.next;
                return;  // if first then do this
            }
            Node ptr = first;
            for (; ptr.next != null; ptr = ptr.next){
                if (ptr.next.key.equals(key)){
                    ptr.next = ptr.next.next;
                    size--;
                    return;  // If a match is found then this
                }
            }
            return; // Gave a none existent key
            // Tempted to crash this if something gets this far but won't
        }

        private boolean containsKey(K key){
            Node ptr = first;
            for(; ptr != null; ptr = ptr.next){
                if (ptr.key.equals(key)) return true;
            }
            return false;
        }

        public Node<K, V> containsKeyCollect(K key){
            Node ptr = first;
            for(; ptr.next != null; ptr = ptr.next){
                if (ptr.key.equals(key)) return ptr;
            }
            if (ptr.key.equals(key)) return ptr;
            else {
                ptr.next = new Node(null, key, 0);
                size++;
            }
            return ptr.next;
        }

        public class Node<K, V>{
            private K key;
            private V value;
            private Node next;

            public Node(Node node, K key, V value){
                this.key = key;
                this.value = value;
                this.next = node;
            }

            public void plusOne(){value = (V) (Integer) ((int) value + 1);}  // Annoying
            public V getValue(){return value;}
        }
    }
}