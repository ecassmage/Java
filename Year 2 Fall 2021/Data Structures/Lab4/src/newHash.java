import java.util.LinkedList;

public class newHash<K, V> {
    private static final int capInit = 400000;
    public int sizeOfMap;

    //public int Uniques = 0;

    LinkedListForHash2540<K, V>[] list;

    public newHash(int Capacity){
        sizeOfMap = Capacity;
        list = (LinkedListForHash2540<K, V>[]) new LinkedListForHash2540[sizeOfMap];
        for (int i = 0; i < sizeOfMap; i++)  list[i] = new LinkedListForHash2540<>();
    }

    public newHash(){
        this(capInit);
    }

    private int myhash(K key) {
        int hash = 7;
        String k = (String) key;
        int base=31;
        for (int i = 0; i < k.length(); i++){
            hash = (int) Math.abs(base * (k.charAt(i) + hash));
        }
        return Math.abs(hash % sizeOfMap);
    }

    public V get(K key){
        return list[myhash(key)].get(key);
    }

    public void put(K key, V value){
        list[myhash(key)].put(key, value);
    }

    public LinkedList<K> keys() {
        LinkedList<K> queue = new LinkedList<K>();
        for (int i = 0; i < sizeOfMap; i++) {
            for (K key : list[i].keys())
                queue.add(key);
        }
        return queue;
    }
}
