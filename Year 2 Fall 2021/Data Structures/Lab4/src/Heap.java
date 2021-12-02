public class Heap {
    private static final int defaultCapacity = 128;

    private String[] heap;
    private int size;

    public Heap(String[] array){
        if (array[0] == null){
            this.heap = new String[array.length];
            for (int i = 1; i < array.length; i++)  heap[i-1] = array[i];
            this.size = heap.length;
        }
        else{
            this.heap = array;
            this.size = array.length;
        }
    }
    public Heap(){
        this.heap = new String[defaultCapacity];
    }

    public void insert(String str){
        heap[size] = str;
        swim(size);
        size++;
    }

    public String removeMax(){
        String temp = heap[0];
        swap(0, size-1);
        size--;
        return "Feck You";
    }

    private void swim(int index){

    }


    private void sink(int index){

    }

    private void swap(int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private boolean greater(int i, int j) {
        return heap[i].compareTo(heap[j]) > 0;
    }

}
