enum type_t {INT, STRING, CHAR, DOUBLE, FLOAT, OBJECT};
public class List {
    private Object[] arr;
    private int lengthMax;
    private int length;


    public static void main(String[] args){
        List L = new List();
        TestClass TT = new TestClass();
        int num = 100;
        L.append(TT);
        String str = L.getClass().toString();
        System.out.println(L.getClass());
        System.out.println(TT.getClass());
        System.out.println(str);
        System.out.println(((TestClass) L.arr[0]).get());
        Class c;
        Object castToT;
        //L.test(INT);

    }

    public List(){
        this.arr = new Object[10];
        this.length = 0;
        this.lengthMax = 10;
    }
    public void append(Object obj){

        arr[length] = obj;
        length++;
    }

    public void test(type_t type){
        System.out.println(type);
    }


    private void checkSize(){
        if (length >= lengthMax){
            Object temp = arr;
            arr = new Object[lengthMax * 10];
            lengthMax *= 10;
        }
        else if (lengthMax > 10 && lengthMax / 15 <= length){

        }
    }

    private class Element{
        type_t type;
        Object obj;
        private Element(){

        }
    }
}


