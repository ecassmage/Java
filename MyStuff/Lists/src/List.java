import java.util.Arrays;

public class List {
    private Object[] arr;
    private int lengthMax;
    private int length;

    public static void main(String[] args){
        List L = new List();
        TestClass TT = new TestClass();
        List two = new List();
        List three = new List();
        two.append("This is Number two");
        three.append("This is Number three");
        L.append(TT);
        L.append(new TestClass());
        L.append(new TestClass());
        L.append(new TestClass());
        L.append('a');
        L.append("Hello World: 1");
        L.append(100);
        System.out.println("" + L.get(4));
        L.pop(2);
        TestClass Testy = L.get(2);
        Testy.string = "This Has Been Changed";
        System.out.println(L.index(100));
        System.out.println(L.index("Hello World: 1"));
        System.out.println(L.index(TT));
        String str = L.getClass().toString();
        System.out.println(L.getClass());
        System.out.println(TT.getClass());
        System.out.println(str);
        System.out.println(L);
        L.append(two);
        two.append(three);
        two.append(two);
        System.out.println(L);
    }

    public List(){
        this.arr = new Object[10];
        this.length = 0;
        this.lengthMax = 10;
    }
    public void append(List obj){
        // This is a simple way to fix infinite recursion from happening, by
        checkSize();
        if (obj == this){
            arr[length] = new Element<List>(obj.copy());
        }else arr[length] = new Element<List>(obj);
        length++;
    }
    public void append(Object obj){
        checkSize();
        arr[length] = new Element<>(obj);
        length++;
    }
    public void extend(List list){
        checkSize(list.len());
        list = list.copy();
        for (int i = 0; i < list.len(); i++) append(list.get(i));
        length += list.len();
    }
    public void extend(Object[] Array){
        checkSize(Array.length);
        Array = Arrays.copyOf(Array, Array.length);
        for (int i = 0; i < Array.length; i++) append(Array[i]);
        length += Array.length;
    }
    public void insert(Object obj, int index){
        checkSize();
        for (int i = len()-1; i >= index; i++) arr[i+1] = arr[i];
        arr[index] = new Element<>(obj);
        length++;
    }

    /**
     * Gets and returns the Object at the specified index point.
     * @param O Takes an Object, Can Be any object including data types.
     * @return Returns the Element position if found and Throws an exception if it was unable to locate Object
     */
    public int index(Object O){
        for (int i = 0; i < length; i++){
            if (O == get(i)) return i;
        }
        System.out.println();
        try {
            throw new ValueError(O + " was not found");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }

    /**
     * This allows for the popping of an element in users list.
     * <p>
     *     This uses <T> for type casting to the things object. This is Honestly pointless, but because the compiler can't tell the actual
     *     type of the object does not error the casting of this to anything. So when calling this, you can do say
     *      Class newVar = List.pop(); instead of
     *      Class newVar = (Class) List.pop(); to prevent issues from occurring since List.pop() is going to return an Object.
     * </p>
     * @param <T> Takes Nothing. This is irrelevant to the User.
     * @return Returns an Object which can be then casted to what is needed.
     */
    public <T> T pop(){ return pop(-1); }
    public <T> T pop(int index){
        // I am pretty sure this <T> stuff is necessary as I need something that can be fluid and isn't just Object to return this object in its real form.
        // Sadly you cannot use its methods until after you have casted it, but this does work;
        if (index < 0) index += length;
        if (index > length || index < 0) return null;
        T temp = get(index);
        for (int i = index+1; i < length; i++){
            arr[i-1] = arr[i];
        }
        arr[length-1] = null;
        length--;
        return temp;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public <E> E get(int index){
        return ((E) ((Element) arr[index]).get());
    }

    public int len(){ return length; }

    public void clear(){
        for (int i = 0; i < length; i++){
            arr[i] = null;
        }
        length = 0;
        lengthMax = 10;
        arr = new Object[10];
    }

    public List copy(){ return copy(0, length); }
    public List copy(int end){ return copy(0, end); }
    public List copy(int start, int end){
        List tempo = new List();
        System.out.println(tempo);
        for (int i = start; i < end; i++) {
            tempo.append((Object) get(i));
        }
        return tempo;
    }

    @Override // This is redundant code :)
    public String toString(){
        String tempString = "[";
        StringBuilder temp = new StringBuilder("[");
        for(int i = 0; i < length; i++) {
            if (i != 0) temp.append(", "); //tempString += ", ";
            //if (((Element) arr[i]).specialPrintLine != null) tempString =
            if (get(i).getClass().toString().equals("class java.lang.String") || get(i).getClass().toString().equals("class java.lang.Character")) temp.append("'"); //tempString += "'";
            String str = get(i).getClass().toString();
            //tempString += get(i);
            temp.append(arr[i]);
            if (get(i).getClass().toString().equals("class java.lang.String") || get(i).getClass().toString().equals("class java.lang.Character")) temp.append("'"); //tempString += "'";
        }

        return temp.toString() + "]";
    }
    private void checkSize(){
        checkSize(0);
    }
    private void checkSize(int additions){
        if (length + additions >= lengthMax) grow();
        else if (lengthMax > 10 && lengthMax / 15 <= length) shrink();  // /15 is so that it doesn't just constantly flip between lets say 99 and 100 causing continuous allocation and de-allocation.
    }

    private void grow(){
        lengthMax *= 10;
        arr = Arrays.copyOf(arr, lengthMax);
    }
    private void shrink(){
        lengthMax /= 10;
        arr = Arrays.copyOf(arr, lengthMax);
    }

    /**
     * Magic Happens Here which I don't want to touch in case something breaks.
     * @param <T> Takes Some Type.
     */
    public static class Element<T>{
        /*
        No idea if this class is needed but, it is working and I am not going to jinx it.
         */
        private Object obj;
        private String specialPrintLine;
        private String type;

        private Element(Object obj){ this(obj, obj.toString()); }
        private Element(Object obj, String special){
            changeElement(obj, special);
        }

        public String type(){ return type; }  // This is Probably Pointless

        @SuppressWarnings("unchecked")
        public T get(){ return (T) obj; }

        public void changeElement(Object obj){ changeElement(obj, obj.toString()); }
        public void changeElement(Object obj, String special){
            this.obj = obj;
            this.type = obj.getClass().toString().replace("class ", "");
            this.specialPrintLine = special;
        }

        @Override
        public String toString(){
            return specialPrintLine;
        }
    }

    /**
     * This is a Custom Error Message I built Which is basically just a copy of Pythons ValueError, :)
     */
    private static class ValueError extends Exception {
        public ValueError(String message){
            super(message);
        }
    }
}



