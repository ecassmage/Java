public class Stack {
    private Element<?> Top;
    private int len = 0;

    public static void main(String[] args){
        Stack S = new Stack();
        List L = new List();
        L.append("append");
        L.append(100);
        S.add("String");
        S.add("Boolean");
        S.add("Copper");
        S.add(100);
        S.add(true);
        S.add(L);
        System.out.println(S.toList());
        System.out.println(S);
    }

    public Stack(Element<?> Ele){
        this.Top = Ele;
        len++;
    }
    public <E> Stack(E O){
        this(new Element<>(O, null));
    }
    public Stack(){
        Top = null;
    }

    public <E> void add(E obj){
        this.Top = new Element<>(obj, this.Top);
        len++;
    }

    public <E> E pop(){
        E temp = this.get();
        Top = Top.getNext();
        len--;
        return temp;
    }
    public void push(){
        Top = Top.getNext();
        len--;
    }

    public boolean isEmpty(){
        return Top == null;
    }
    public List toList(){
        List L = new List();
        Element<?> ptr = Top;
        for(int i = 0; i < len; i++){
            L.append(ptr.get());
            ptr = ptr.getNext();
        }
        return L;
    }

    @SuppressWarnings("unchecked")
    public <E> E get(){
        return (E) Top.get();
    }

    public String toString(){
        Element<?> ptr = Top;
        String str = "";
        for(int i = 0; i < len; i++){
            if (i != 0) str = str.concat(" -> ");
            str = str.concat((ptr.get()).toString());
            ptr = ptr.getNext();
        }
        return str;
    }

    private static class Element<E>{
        Element<?> next;
        E obj;
        public Element(E obj, Element<?> next){
            this.obj = obj;
            this.next = next;
        }

        public E get(){
            return obj;
        }

        public Element<?> getNext(){
            return next;
        }
    }
}
