public class Child extends Parent
{
    public static void main(String[] args){
        Child kid1 = new Child(-14);
        Child kid2 = new Child(21);
        System.out.println(kid1.getValue() + " " + kid2.getValue());
    }
    private int value;
    public Child(int number)
    {
        value = number;
    }
    public int getValue()
    {
        return value;
    }
}