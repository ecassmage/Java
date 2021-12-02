import java.util.Arrays;

public class Stack2540ArrayDynamicCop {
    private static final int CapDefault = 128;
    private final int initialCap;
    private boolean backWardsForwards;
    private int maxCapacity;
    int top;
    String[] stack;

    public Stack2540ArrayDynamicCop(int Capacity, boolean Backwards) {
        this.maxCapacity = Capacity;
        this.initialCap = Capacity;
        this.backWardsForwards = Backwards;
        if (this.backWardsForwards){
            this.top = Capacity;
        }
        else{
            this.top = -1;
        }
        this.stack = new String[this.maxCapacity];

    }
    public Stack2540ArrayDynamicCop(int Capacity) {
        this(Capacity, false);
    }
    public Stack2540ArrayDynamicCop() {
        this(CapDefault);
    }

    public int size() {
        return (backWardsForwards) ? initialCap - top : this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public String top() {
        return isEmpty() ? null : this.stack[this.top];
    }

    public void push(String element) {
        if (backWardsForwards){
            this.top--;
            this.stack[this.top] = element;
            return;
        }
        resizeUp();
        ++this.top;
        this.stack[this.top] = element;
    }

    public String pop() {
        if (backWardsForwards){
            if (this.isEmpty()) return null;
            else {
                String temp = this.stack[this.top];
                this.stack[this.top++] = null;
                return temp;
            }
        }
        if (this.isEmpty()) return null;
        else {
            String temp = this.stack[this.top];
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

    private void resizeDown() {
        if (this.size() > initialCap && this.size() < this.maxCapacity / 20){
            maxCapacity /= 2;
            stack = Arrays.copyOf(stack, maxCapacity);
        }
    }
}
