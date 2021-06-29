public class Classs {
    private static int count = 0;
    public int number = 0;
    public static void main(String[] args){
        Classs one = new Classs();
        Classs two = new Classs();
        System.out.println(one.getNumber() + " " + two.getNumber());
        System.out.println(one.getCount() + " " + two.getCount());
        System.out.println(getS() + " " + getS());
        count++;
    }


    public Classs()
    {
        count++;
        number = count;
    }

    public int getCount() { return count; }

    public int getNumber() { return number; }
    public static int getS(){
        return count;
    }
}
