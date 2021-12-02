public class Tree {
    private Node<?, ?> Root;
    //private int valuesInTree;


    public static void main(String[] args){
        Tree T = new Tree();
        T.add("Word", 100);
        T.add("Cyanide", "String");
        T.add(new Dummy(), 100);
        T.add(true, "True");
        T.add(false, "false");
        T.add(100, 100);
        List L = T.toList();
        System.out.println(L);
    }


    public Tree(){
        this.Root = null;
        //this.valuesInTree = 0;
    }


    private void add(Object Key, Object Value, Node<?, ?> node){
        String str1 = Key.toString();
        if (Key.toString().compareTo(node.getKey().toString()) < 0){
            if (node.Left == null) {
                node.Left = new Node<>(Key, Value);
                //valuesInTree++;
            }
            else add(Key, Value, node.Left);
        }
        else if (Key.toString().compareTo(node.getKey().toString()) > 0){
            if (node.Right == null) {
                node.Right = new Node<>(Key, Value);
                //valuesInTree++;
            }
            else add(Key, Value, node.Right);
        }
        else{
            node.setValue(Value);
        }
    }
    public void add(Object Key, Object Value){
        if (this.Root == null)  this.Root = new Node<>(Key, Value);
        else                    add(Key, Value, this.Root);
    }

    private List toList(List L, Node<?, ?> node){
        L.append(node);
        if (node.Left != null)  L = toList(L, node.Left);
        if (node.Right != null) L = toList(L, node.Right);
        return L;
    }
    public List toList(List L){ return toList(L, this.Root); }
    public List toList(){ return toList(new List(), this.Root); }

    private static class Node<K, V>{
        private K Key;
        private Element<?> Value;
        private long Hash;
        private Node<?, ?> Left;
        private Node<?, ?> Right;

        public Node(K Key, V Value){
            this.Key = Key;
            this.Value = new Element<V>(Value);
            this.Left = null;
            this.Right = null;
        }
        @SuppressWarnings("unchecked")
        public V getValue(){ return (V) Value.get(); }
        public K getKey() { return Key; }
        public <E> void setValue(E newValue){
            this.Value = new Element<E>(newValue);
        }
        public String toString(){
            return "{" + Key.toString() + ": " + Value.toString() + "}";
        }
        //public void reset(){ set(null); }
        //public void set(E ele){ this.ele = ele; }
    }

    private static class Element<E>{
        private E ele;

        public Element(E ele){ this.ele = ele; }
        public E get(){ return ele; }
        public void reset(){ set(null); }
        public void set(E ele){ this.ele = ele; }

        public String toString(){
            return ele.toString();
        }
    }
}
