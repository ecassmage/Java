import java.util.LinkedList;
import java.util.Random;

public class HashMap25402<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int n; // number of elements
    private int m; // hash table size
    private LinkedListForHash2540<Key, Value>[] st;
    // array of linked-list.

    public HashMap25402() {
        this(INIT_CAPACITY);
    }

    // used in resize.
    public HashMap25402(int m) {
        this.m = m;
        st = (LinkedListForHash2540<Key, Value>[]) new LinkedListForHash2540[m];
        for (int i = 0; i < m; i++)
            st[i] = new LinkedListForHash2540<Key, Value>();
    }

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int n) {
        HashMap25402<Key, Value> temp = new HashMap25402<Key, Value>(n);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    // hash value between 0 and m-1
    private int myhash(Key key) {
        int hash = 7;
        String k = (String) key;
        int base=31;
        for (int i = 0; i < k.length(); i++){
            hash = (int) Math.abs(base * (k.charAt(i) + hash));
        }
        return Math.abs(hash % m);
    }

    public Value get(Key key) {
        int i = myhash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val) {
        // double table size if average linked list size is 10. Note that the resize stratege is different from the Java implementation as discussed in the book.
        if (n >= 10 * m)
            resize(2 * m);
        st[myhash(key)].put(key, val);
        // Put your code here.
        // 1) get the hash value of the key i.
        // 2) then put (key, value) in the i-th linkedList implemented in LinkedListForHash254
        // 3) you need to handle the case whether n need to be increased depending on whether the key is already there.
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");
        int i = myhash(key);
        if (st[i].get(key)!=null)
            n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m)
            resize(m / 2);
    }

    public LinkedList<Key> keys() {
        LinkedList<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.add(key);
        }
        return queue;
    }
}

//13424  27183