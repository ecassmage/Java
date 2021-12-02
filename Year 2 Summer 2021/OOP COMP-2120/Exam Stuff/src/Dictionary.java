import java.util.ArrayList;


/**
 * Really Bad version of a Dictionary
 */
public class Dictionary {

    final static long testValue = 1000000;
    final static long iterations = 10;
    final static boolean noString = false;


    final static int initialSize = 8;

    private Node<?, ?>[] NodeList;

    private int len;
    private int size;


    private final double loadFactor = .75;  // No it can't it is much easier to find up here.

    public static void main(String[] args){
        Dictionary D = new Dictionary();
        Dictionary D2 = new Dictionary();
        ArrayList<String> Arr = new ArrayList<>();
        D2.add("Hello", "World");
        System.out.println(D2);
        D.add(D2, "Hello");
        D.add("Dictionary", D2);
        D.add("Word", 100);
        D.add("Cyanide", "String");
        D.add(new Dummy(), 100);
        D.add(true, "True");
        D.add(false, "false");
        D.add(100, 100.1);
        D.add('s', false);

        long start = System.currentTimeMillis();
        for (long i = 0; i < testValue; i++){ D.add(Long.toString(i), i); }
        System.out.println("Dictionary Time: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (long i = 0; i < testValue; i++){ Arr.add(Long.toString(i)); }
        System.out.println("ArrayList Time: " + (System.currentTimeMillis() - start));

        //System.out.println("The Array List Scored: " + ArrayListTimer(Arr));
        System.out.println("The Dictionary Scored: " + DictionaryTimer(D));

        System.out.println("Print");
        //System.out.println(D);
    }

    private static long DictionaryTimer(Dictionary D){
        long start = System.currentTimeMillis();
        for (int many = 0; many < iterations; many++){
            for (long i = 0; i < testValue; i++){
                if (!(D.get(Long.toString(i)).equals(i))){
                    System.out.println("Failed");
                    System.exit(0);
                }
            }
        }
        return System.currentTimeMillis() - start;
    }
    private static long ArrayListTimer(ArrayList<?> Arr){
        long start = System.currentTimeMillis();
        for (int many = 0; many < iterations; many++){
            for (long i = 0; i < testValue; i++){
                //long num = (long) Arr.get(Arr.indexOf(Long.toString(i)));
                if (!(Arr.get(Arr.indexOf(Long.toString(i))).equals(Long.toString(i)))){
                    System.out.println("Failed");
                    System.exit(0);
                }
            }
        }
        return System.currentTimeMillis() - start;
    }

    public Dictionary(int sizeStart){
        this.NodeList = new Node<?, ?>[sizeStart];
        this.len = 0;
        this.size = sizeStart;
    }
    public Dictionary(){ this(initialSize); }

    private <K, V> void add(Node<K, V> Node){
        if (NodeList[resizedHash(Node.getHash())] != null){
            Node<?, ?> nodeLink = NodeList[resizedHash(Node.getHash())];
            for (; nodeLink.next != null; nodeLink = nodeLink.next);
            nodeLink.next = Node;
        }
        else NodeList[resizedHash(Node.getHash())] = Node;
        len++;
    }
    public <K, V> void add(K Key, V Value){

        extendCheck();
        long Hash = hashCode(Key);
        add(new Node<>(Key, Value, Hash));
    }

    @SuppressWarnings({"unchecked"})
    public <K, V> V get(K Key){
        for(Node<?, ?> nodeLink = NodeList[resizedHash(hashCode(Key))]; nodeLink != null; nodeLink = nodeLink.next){
            if (nodeLink.getKey().equals(Key))
                return (V) nodeLink.getValue();
        }
        return null;
    }

    public long hashCode(Object Key){
        String line2 = Key.toString() + Key.getClass() + Key.toString();
        long num = 0;
        for (int i = 0; i < line2.length(); i++){
            if (i % 2 == 0) num += line2.charAt(i);
            else num *= (long) (line2.charAt(i) / 2);
        }
        return Math.abs(num * Key.toString().length());
    }

    public int resizedHash(long Hash){
        return (int) (Hash % size);
    }

    public void extendCheck(){
        if (((double) len / (double) size) >= loadFactor){
            size *= initialSize;
            len = 0;
            Node<?, ?>[] copy = this.NodeList;
            this.NodeList = new Node<?, ?>[size];
            for (Node<?, ?> node: copy){
                for (Node<?, ?> nodeLink = node, backup = null; nodeLink != null; nodeLink = backup){
                    add(nodeLink);
                    backup = nodeLink.next;
                    nodeLink.next = null;
                }
            }
        }
    }

    @Override
    public String toString(){
        if (noString) return "";
        if (len == 0) return super.toString();
        String str = "{";
        boolean comma = false;
        for (int i = 0, number = 0; i < size; i++){
            for (Node<?, ?> nodeLink = NodeList[i]; nodeLink != null; nodeLink = nodeLink.next){
                if (number > 0 && NodeList[i] != null) str = str.concat(", ");
                str = str.concat(nodeLink.toString());
                number++;
            }
        }
        return str + "}";
    }


    private static class Node<K, V>{
        private K Key;
        private V Value;
        private final long Hash;
        private Node<?, ?> next;

        public Node(K Key, V Value, long Hash){
            this.Key = Key;
            this.Value = Value;
            this.Hash = Hash;
        }
        public V getValue(){ return Value; }
        public K getKey() { return Key; }

        public String toString(){
            return Key.toString() + ": " + Value.toString();
        }

        public long getHash(){ return Hash; }
        //public void reset(){ set(null); }
        //public void set(E ele){ this.ele = ele; }
    }

    public static String format(long n){
        String newStr = n < 0 ? "-" : "";               // This Checks For if integer is negative or not.
        String numStr = Long.toString(Math.abs(n));  // This creates a string from integer. This is so I can better cut parts of the number out. It is run through Math.abs to make sure it is always a positive number.

        newStr = newStr.concat(numStr.substring(0, numStr.length() % 3));  // Concatenates the first characters. + negatives
        boolean isCommaNeeded = (newStr.length() != 0 && !(newStr.length() == 1 && newStr.charAt(0) == '-'));  // Checks if newStr needs a comma immediately
        for (int i = numStr.length() % 3; i < numStr.length(); i+= 3){
            if (isCommaNeeded) newStr = newStr.concat(",");  // I am doing this this way instead of newStr += "," since it seems to not like it and the internet seemed to agree that it is not a good idea.
            else isCommaNeeded = true;  // This is to reduce the number of calculations needed to complete so as to prevent isCommaNeeded from being given a true value after every iteration.
            newStr = newStr.concat(numStr.substring(i, i+3));  // Concats every digit, three at a time
        }
        return newStr;
    }
}
