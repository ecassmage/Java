import java.util.LinkedList;

public class HashMap2540<K, V> {
    private static final int DEFAULTINITIALCAPACITY = 4;
    private static final double LOADFACTOR = 0.75;

    private int sizeOfMap;
    private int size;
    private Chain<K, V> list[];

    public HashMap2540(int Capacity){
        this.sizeOfMap = Capacity;
        this.size = 0;
        this.list = new Chain[sizeOfMap];
    }
    public HashMap2540(){
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

    public V get(K key){
        int hash = hash(key);
        if (list[hash] != null){
            return list[hash].get(key);
        }
        return null;
    }

    private void put(Chain.Node node){
        int hash = hash(node.hash);
        if (list[hash] != null) list[hash].put(node);
        list[hash] = new Chain(node);
        size++;
    }

    public void put(K key, V value){
        resize();
        int hash = hash(key);
        if (list[hash] != null) size += list[hash].put(key, value, hash);
        list[hash] = new Chain(key, value, hash);
    }

    public LinkedList<K> keys() {
        LinkedList<K> queue = new LinkedList<K>();
        for (int i = 0; i < sizeOfMap; i++) {
            if (list[i] == null) continue;
            for (Chain.Node node = list[i].keys(); node != null; node = node.next) {
                queue.add((K) node.key);
            }
        }
        return queue;
    }

    private void grow(){
        HashMap2540<K, V> temp = new HashMap2540<>(sizeOfMap * 2);
        for (int i = 0; i < sizeOfMap; i++){
            if (list[i] == null) continue;
            for (Chain.Node ptr = list[i].keys(); ptr != null; ptr = ptr.next){
                temp.put(ptr);
            }
        }
        this.list = temp.list;
        this.size = temp.size;
        this.sizeOfMap = temp.sizeOfMap;
    }

    private void resize(){
        if (size > LOADFACTOR * sizeOfMap){
            grow();
        }
    }

    private class Chain<K, V> {
        private Node first;

        public Chain(Node node){
            this.first = node;
            node.next = null;
        }
        public Chain(K key, V value, int hash){
            this.first = new Node<K, V>(null, key, value, hash);
        }

        public V get(K key){
            for (Node ptr = first; ptr != null; ptr = ptr.next){
                if (ptr.equals(key)){
                    return (V) ptr.value;
                }
            }
            return null;
        }
        public void put(Node node){
            node.next = first;
            first = node;
        }
        public int put(K key, V value, int hashCode){
            for (Node ptr = first; ptr != null; ptr = ptr.next){
                if (ptr.equals(key)) {
                    ptr.value = value;
                    return 0;
                }
            }
            first = new Node(first, key, value, hashCode);
            return 1;
        }

        public Node keys(){
            return first;
        }

        private class Node<K, V> {
            private K key;
            private V value;
            private Node next;
            private int hash;

            public Node(Node next, K key, V value, int hash){
                this.key = key;
                this.value = value;
                this.next = next;
                this.hash = hash;
            }
            public boolean equals(Object key){
                return this.key.equals((String) key);
            }
        }
    }
}
