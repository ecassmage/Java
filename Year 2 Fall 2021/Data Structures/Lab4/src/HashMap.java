public class HashMap<Key, Value> {
    public HashMap(int Capacity){
        list = new Link[Capacity];
        size = Capacity;
        for (int i = 0; i < size; i++)  list[i] = new Link<>();
    }
    public Link<Key, Value>[] list;
    public int size;
    private int sizeInside = 0;


    public int getHashCode(Key key) {
        int hash = 0;
        for (int i = 0; i < ((String) key).length(); i++){
            hash = hash << 5 | hash >>> 27;
            hash += ((String) key).charAt(i) * 31;
        }
        return hash;
    }
    public int getHash(Key key) {
        return Math.abs(getHashCode(key) % size);
    }

    public void put(Key key, Value value){
        sizeInside += list[getHash(key)].put(key, value);
    }

    public Value get(Key key){
        return list[getHash(key)].get(key);
    }

    public Link.Node getNode(Key key){
        return list[getHash(key)].getNode(key);
    }

    public class Link<Key, Value> {
        private Node First;
        private int size = 0;

        public Link(Key key, Value value){
            First = new Node(key, value, null);
        }
        public Link(){
            First = null;
        }

        public int put(Key key, Value value){
            Node ptr = First;
            for (; ptr != null; ptr = ptr.next){
                if (ptr.equals(key)) ptr.value = value;
                return 0;
            }
            First = new Node(key, value, First);
            size++;
            return 1;
        }

        public Value get(Key key){
            for (Node ptr = First; ptr != null; ptr = ptr.next){
                if (ptr.equals(key)) return (Value) ptr.value;
            }
            return null;
        }
        public Node getNode(Key key){
            for (Node ptr = First; ptr != null; ptr = ptr.next){
                if (ptr.equals(key)) return ptr;
            }
            return null;
        }

        public int size(){ return size; }

        public Node[] getArray(){
            Node[] arr = new Node[size];
            int i = 0;
            for (Node ptr = First; ptr != null; ptr = ptr.next, i++) arr[i] = ptr;
            return arr;
        }

        public String[] keys(){
            String[] arr = new String[sizeInside];
            for (HashMap.Link token: list){
                if (token == null) continue;
                for (HashMap.Link.Node node: token.getArray()){

                }
            }
            return arr;
        }

        public class Node<Key, Value> {
            private Key key;
            private Value value;
            private Node next;

            public Node(Key key, Value value, Node node){
                this.key = key;
                this.value = value;
                this.next = node;
            }

            public Key getKey(){ return key; }
            public Value getValue(){ return value; }

            public boolean equals(Object key){
                return this.key.equals(key);
            }

            public void setValue(){
                value = (Value) (Integer) ((int) value + 1);
            }
        }
    }
}
