public class Stack2540ArrayDynamic {

    private Node last;
    private int Size;

    public Stack2540ArrayDynamic(){
        this.last = null;
        this.Size = 0;
    }

    public boolean isEmpty(){
        return  last == null;
    }

    public int size(){
        return this.Size;
    }

    public void push(String str){
        last = new Node(last, str);
        Size++;
    }

    public String peek(){
        if (last == null) return null;
        return last.getString();
    }

    public String pop(){
        String str;
        if ((str = peek()) == null) return null;
        last = last.ahead;
        Size--;
        return str;
    }

    public boolean matchChars(String str) {
        if (this.last != null) return "({[".indexOf(this.last.getString().charAt(0)) == ")}]".indexOf(str.charAt(0));
        return false;
    }


    private static class Node{
        private Node ahead;
        private String string;

        public Node(Node ahead, String contents){
            this.string = contents;
            this.ahead = ahead;
        }

        private String getString(){
            return string;
        }
    }
}
