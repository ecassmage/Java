import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Stack2540ArrayDynamic {
    private static final int CapDefault = 128;
    private final int initialCap;

    private int maxCapacity;
    int top;
    String[] stack;


    public Stack2540ArrayDynamic(int Capacity) {
        this.maxCapacity = Capacity;
        this.initialCap = Capacity;

        this.stack = new String[this.maxCapacity];
        this.top = -1;
    }
    public Stack2540ArrayDynamic() {
        this(CapDefault);
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public String top() {
        return isEmpty() ? null : this.stack[this.top];
    }

    public void push(String element) {
        if (size() == maxCapacity) grow();
        top++;
        this.stack[this.top] = element;
    }

    public String pop() {
        return isEmpty() ? null : stack[this.top--];
    }

    private void grow(){
        maxCapacity *= 2;
        stack = Arrays.copyOf(stack, maxCapacity);
    }
    private void shrink(){
        maxCapacity /= 2;
        stack = Arrays.copyOf(stack, maxCapacity);
    }

    public void resize(){
        if (size() == maxCapacity) grow();
        else if (maxCapacity > initialCap && size() < maxCapacity / 4) shrink();
        // maxCapacity > initialCap, so that the stack doesn't resize when empty and size is lets say 10.
        // size() < maxCapacity / 4 so that you don't get in a situation where you push, pop, push, pop and everytime the array resizes.
    }



    public void resizeC(int size){
        stack = Arrays.copyOf(stack, size);
        maxCapacity = size;
    }
    public static byte[] getBytes(String filename) throws Exception{
        return Files.readAllBytes(Paths.get(filename));
    }
}
