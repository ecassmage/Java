import java.io.*;
import java.util.*;

public class Stack2540Array {
    static int CAPACITY = 812000;
    int top;
    String[] stack;

    public Stack2540Array(int Capacity) {
        stack = new String[CAPACITY];
        top = -1;
    }

    public Stack2540Array() {
        this(CAPACITY);
    }

    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        return (top == -1);
    }

    public String top() {
        if (top == -1)
            return null;
        return stack[top];
    }

    public void push(String element) {
        top++;
        stack[top] = element;
    }

    public String pop(){
        return isEmpty() ? null : stack[top--];
    }
}
