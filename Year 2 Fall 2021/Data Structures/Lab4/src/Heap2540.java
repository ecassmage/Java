public class Heap2540 {
    private static final int defaultCapacity = 128;
    private String[] heap;
    private int n = 0;


    public Heap2540(String[] a) {
        // define the constructor for a heap from an array
        // Why Do I have to follow this annoying Way of doing it.
        this.heap = new String[a.length + 1]; // this(a.length + 1); if Using My Code
        for (String str: a) insert(str);
    }

    public Heap2540(int capacity){
        this.heap = new String[capacity];
    }

    public Heap2540() {
        this(defaultCapacity);
    }

    private void recursPrint(int index, int recurse, boolean lesser){
        if (index > n || heap[index] == null) return;
        for (int i = 0; i < recurse; i++){
            System.out.print("\t");
        }
        String val = lesser ? "Lesser:  " : "Greater: ";
        System.out.println(val + heap[index]);
        recursPrint((index * 2), recurse+1, true);
        recursPrint((index * 2) + 1, recurse+1, false);
    }

    public void print(){
        System.out.println(heap[1]);
        recursPrint((1 * 2), 1, true);
        recursPrint((1 * 2) + 1, 1, false);
    }

    public String removeMax() {
        String max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        return max;
    }

    public void insert(String x) {
        // add resize
        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less((int) (k / 2), k)){
            swap((int) k / 2, k);
            k = (int) k / 2;
        }
        // add swim
    }

    private void swap(int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void sink(int k) {
        while (k * 2 <= n){
            if (k*2 < n && heap[k*2] != null && less(k, k*2)) {
                swap(k, k*2);
            }
            if (k*2 + 1 < n && heap[k*2 + 1] != null && less(k, k*2 + 1)){
                swap(k, k*2 + 1);
            }
            k = k * 2;
        }
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    public static void main(String[] args){
        String[] a = "abcdefghijklmnopqrstuvwxyz".split("");
        Heap2540 heap = new Heap2540(a);
        heap.print();
        System.out.println();
        Heap2540 pq = new Heap2540(a);
        int n = a.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = pq.removeMax();
        }
        heap.print();
        for (String str: result){
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}