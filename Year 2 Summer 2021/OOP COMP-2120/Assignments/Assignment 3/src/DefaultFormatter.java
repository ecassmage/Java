public class DefaultFormatter implements NumberFormatter {
    public static void main(String[] args){
        DefaultFormatter D = new DefaultFormatter();
        System.out.println("This is Output: " + D.format(1024323423));
        System.out.println("This is Output: " + D.format(101));
        System.out.println("This is Output: " + D.format(1));
        System.out.println("This is Output: " + D.format(0));
        System.out.println("This is Output: " + D.format(124432));
        System.out.println("This is Output: " + D.format(-12));
        System.out.println("This is Output: " + D.format(-554));
    }
    public String format(int n){
        return Integer.toString(n);
    }
}
