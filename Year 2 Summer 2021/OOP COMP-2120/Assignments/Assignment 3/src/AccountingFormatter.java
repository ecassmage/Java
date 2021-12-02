public class AccountingFormatter implements NumberFormatter{
    public static void main(String[] args){
        AccountingFormatter A = new AccountingFormatter();
        System.out.println("This is Output: " + A.format(1024323423));
        System.out.println("This is Output: " + A.format(101));
        System.out.println("This is Output: " + A.format(1));
        System.out.println("This is Output: " + A.format(0));
        System.out.println("This is Output: " + A.format(124432));
        System.out.println("This is Output: " + A.format(-12));
        System.out.println("This is Output: " + A.format(-554));
    }
    public String format(int n){
        return (n < 0) ? "(" + Integer.toString(n * -1) + ")" : Integer.toString(n);
    }
}
