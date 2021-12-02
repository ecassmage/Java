public class Deque {
    private static final int capacityConstant = 1000;

    private Node last;
    private Node first;
    private int Size;
    private int Capacity;

    public Deque(int Capacity){
        this.Capacity = Capacity;
        this.last = null;
        this.first = null;
        this.Size = 0;
    }

    public Deque(){
        this(capacityConstant);
    }

    public boolean isEmpty(){
        return  last == null;
    }

    public int size(){
        return this.Size;
    }

    public void pushFirst(String str){
        first = new Node(null, first, str);
        if (this.last == null) this.last = first;
        Size++;
    }

    public void push(String str){
        last = new Node(last, null, str);
        if (this.first == null) this.first = last;
        Size++;
    }

    public String peekFirst(){
        return first.getString();
    }

    public String peek(){
        return last.getString();
    }

    public String popFirst(){
        String str;
        if ((str = peekFirst()) == null) return null;
        first = first.behind;
        Size--;
        return str;
    }

    public String pop(){
        String str;
        if ((str = peek()) == null) return null;
        last = last.ahead;
        Size--;
        return str;
    }
    public static String regexAdd(String regex, String input){
        StringBuilder output = new StringBuilder();
        for (char character: input.toCharArray()) { for (char token: regex.toCharArray()) if (character == token) output.append(character); }
        return output.length() == 0 ? null : output.toString();
    }



    private static class Node{
        private Node ahead;
        private Node behind;
        private String string;

        public Node(Node ahead, Node behind, String contents){
            this.string = contents;
            this.ahead = ahead;
            if (ahead != null) ahead.behind = this;
            this.behind = behind;
        }

        private String getString(){
            return string;
        }
    }
}
