import java.util.Arrays;

public class List {
    //private Object[] list;
    private Element<?>[] list;
    private int len;
    private int size;

    public static void main(String[] args){
        Object number = 5;
        List L = new List();
        for (int i = 0; i < 15; i++){
            L.append(i);
        }
        int Number = (int) number;
        int num = L.get(5);
        int num2 = L.getTest(6);
        L.append("all");
        System.out.println(L);
    }


    public List(){ this(10); }
    public List(int size){
        list = new Element<?>[size];
        this.len = 0;
        this.size = size;
    }

    public <E> void append(E obj){
        checkSize();
        if (list[len] != null) {
            list[len].reset();
            list[len] = null;
        }
        list[len] = new Element<>(obj);
        len++;
    }

    private void checkSize(){
        if (len == size)            increase();
        else if (len < size / 15)   decrease();
    }

    private void increase(){
        //list = Arrays.copyOf(list, size * 10);
        list = Arrays.copyOf(list, size * 10);
        size *= 10;
    }
    private void decrease(){
        //list = Arrays.copyOf(list, size / 10);
        list = Arrays.copyOf(list, size / 10);
        size /= 10;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public <E> E get(int index){
        return (E) ((List.Element) list[index]).get();
    }

    @SuppressWarnings("unchecked")
    public <E> E getTest(int index){
        return (E) (list[index].get());
    }

    @Override
    public String toString(){
        String str = "[";
        for (int i = 0; i < len; i++){
            if (i > 0) str = str.concat(", ");
            str = str.concat(get(i).toString());
        }
        return str + "]";
    }

    private static class Element<E>{
        private E ele;

        public Element(E ele){ this.ele = ele; }
        public E get(){ return ele; }
        public void reset(){ set(null); }
        public void set(E ele){ this.ele = ele; }
    }
}
