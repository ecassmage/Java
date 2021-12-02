public class Stack2540Array {
    int CAPACITY = 128;
    int top;
    String[] stack;

    public Stack2540Array() {
        this.stack = new String[this.CAPACITY];
        this.top = -1;
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public String top() {
        return this.top == -1 ? null : this.stack[this.top];
    }

    public void push(String element) {
        ++this.top;
        this.stack[this.top] = element;
    }

    public String pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            String temp = this.stack[this.top];
            this.stack[this.top--] = null;
            return temp;
        }
    }

    public boolean matchChars(String str) {
        String opening = "({[";
        String closing = ")}]";
        if (this.top() != null && this.top() != null) {
            return "({[".indexOf(this.top().charAt(0)) == ")}]".indexOf(str.charAt(0));
        } else {
            return false;
        }
    }
}
