class newMap {
    private Node[] list;
    private int size;

    private int UniqueEntries = 0;

    public newMap(int capacity){
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


    class Node{
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
            int num = 0;
            while (ptr != null){
                list[position++] = ptr.Occurrences;
                ptr = ptr.next;
                num++;
            }
            return position;
        }
    }
}
