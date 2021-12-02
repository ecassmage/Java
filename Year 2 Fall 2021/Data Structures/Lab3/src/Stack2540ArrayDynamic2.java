import java.util.Arrays;

public class Stack2540ArrayDynamic2 {
    private static final int CapDefault = 128;
    private final int initialCap;

    private int maxCapacity;
    int top;
    char[][] stack;


    public Stack2540ArrayDynamic2(int Capacity) {
        this.maxCapacity = Capacity;
        this.initialCap = Capacity;

        this.stack = new char[this.maxCapacity][];
        this.top = -1;


        // Extra Stuff
    }
    public Stack2540ArrayDynamic2() {
        this(CapDefault);
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public String top() {
        return isEmpty() ? null : String.valueOf(this.stack[this.top]);
    }

    public void push(String element) {
        resizeUp();
        ++this.top;
        this.stack[this.top] = element.toCharArray();
    }

    public String pop() {

        if (this.isEmpty()) return String.valueOf(this.stack[0]);
        else {
            String temp = top();
            this.stack[this.top--] = null;
            return temp;
        }
    }

    public void resize(int size){
        stack = Arrays.copyOf(stack, size);
    }

    private void resizeUp(){
        if (this.size() + 1 > this.maxCapacity) {
            maxCapacity *= 2;
            stack = Arrays.copyOf(stack, maxCapacity);
        }
    }
}
