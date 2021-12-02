public class DecimalSeparatorFormatter implements NumberFormatter{
    public static void main(String[] args){
        DecimalSeparatorFormatter D = new DecimalSeparatorFormatter();
        System.out.println("This is Output: " + D.format(1));
        System.out.println("This is Output: " + D.format(1231));
        System.out.println("This is Output: " + D.format(123));
        System.out.println("This is Output: " + D.format(1024323423));
        System.out.println("This is Output: " + D.format(-5));
        System.out.println("This is Output: " + D.format(10000));
        System.out.println("This is Output: " + D.format(-10000));
        System.out.println("This is Output: " + D.format(0));
        System.out.println("This is Output: " + D.format(-5434234));
        System.out.println("This is Output: " + D.format(-540034234));
    }
    public String format(int n){
        String newStr = n < 0 ? "-" : "";               // This Checks For if integer is negative or not.
        String numStr = Integer.toString(Math.abs(n));  // This creates a string from integer. This is so I can better cut parts of the number out. It is run through Math.abs to make sure it is always a positive number.

        newStr = newStr.concat(numStr.substring(0, numStr.length() % 3));  // Concatenates the first characters. + negatives
        boolean isCommaNeeded = (newStr.length() != 0 && !(newStr.length() == 1 && newStr.charAt(0) == '-'));  // Checks if newStr needs a comma immediately
        for (int i = numStr.length() % 3; i < numStr.length(); i+= 3){
            if (isCommaNeeded) newStr = newStr.concat(",");  // I am doing this this way instead of newStr += "," since it seems to not like it and the internet seemed to agree that it is not a good idea.
            else isCommaNeeded = true;  // This is to reduce the number of calculations needed to complete so as to prevent isCommaNeeded from being given a true value after every iteration.
            newStr = newStr.concat(numStr.substring(i, i+3));  // Concats every digit, three at a time
        }
        return newStr;
    }
}
