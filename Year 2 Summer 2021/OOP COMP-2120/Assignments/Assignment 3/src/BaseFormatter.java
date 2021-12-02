public class BaseFormatter implements NumberFormatter {
    int formattingNumber;  // Contains the Base
    public static void main(String[] args){
        BaseFormatter B = new BaseFormatter(8);
        System.out.println("This is Output: " + B.format(10000));
        System.out.println("This is Output: " + B.format(1024323423));
        System.out.println("This is Output: " + B.format(101));
        System.out.println("This is Output: " + B.format(1));
        System.out.println("This is Output: " + B.format(0));
        System.out.println("This is Output: " + B.format(124432));
        //System.out.println("This is Output: " + B.format(-12));
        //System.out.println("This is Output: " + B.format(-554));
    }
    public BaseFormatter(int formatNumber){ this.formattingNumber = formatNumber; }
    public String format(int n){
        boolean negative = n < 0;
        String newStr = "";
        n = Math.abs(n); // Make Sure this is Positive;
        if (n < 1) return Integer.toString(n);  // Just to Catch the Universal Numbers of 1 and 0 which are 1 and 0 no matter the base
        for (; n != 0; n /= formattingNumber) newStr = Integer.toString(n % formattingNumber).concat(newStr);  // Goes through concatenating the base formattingNumber digits. Concatenates the already written part of the number to the new digit.
        if (negative) newStr = "-".concat(newStr);
        return newStr;
    }


    public int getBase(){ return formattingNumber; }
    public void setBase(int newBase){ formattingNumber = newBase; }
}
