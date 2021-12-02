public class TestClass {
    public static int num = 0;
    public int number;
    public String string;
    public TestClass(){
        this.number = ++num;
        string = "Hello World: " + number;
    }

    public String get(){
        return string;
    }

    @Override
    public String toString(){
        return get();
    }
}
