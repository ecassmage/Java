import java.math.BigDecimal;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        firstEquation();
        secondEquation();
    }
    public static void runProgram(){
        System.out.println("\nThis is Problem1.java");
        firstEquation();
        secondEquation();
    }
    public static void firstEquation(){
        System.out.println("the first equation is s = s0 * v0 - (1/2) * g * t^3");
        double[] s = new double[4];
        s[0] = inputD("What is s0: ");
        s[1] = inputD("What is v0: ");
        s[2] = inputD("What is g: ");
        s[3] = inputD("What is t: ");
        System.out.println(
            "s = s0 * v0 - (1/2) * g * t^3\n" +
            "s = " + s[0] + " * " + s[1] + " - (1/2) * " + s[2] + " * " + s[3] + "^3\n" +
            "s = " + (s[0] * s[1] - (double) 1/2 * s[2] * power(s[3], 3))
        );
    }
    public static void secondEquation(){
        double pi = 3.14159265358979323846;
        System.out.println("the first equation is G = (3/4)*pi^2 * ( (a^3) / ( p^(1/2)*(m1-m2) ) )");
        double[] G = new double[4];
        G[0] = inputD("What is a: ");
        G[1] = inputD("What is p: ");
        G[2] = inputD("What is m1: ");
        G[3] = inputD("What is m2: ");
        System.out.println(
            "G = 0.75*pi^2 * ( (a^3) / ( p^(1/2)*(m1-m2) ) )\n" +
            "G = 0.75*pi^2 * ( (" + G[0] + "^3) / ( " + G[1] + "^(1/2) * (" + G[2] + "-" + G[3] + ") ) )\n" +
            "G = " + ((0.75 * power(pi, 2)) * ((power(G[0], 3)) / (power(G[1], 0.5) * (G[2] - G[3]))))
        );
    }
    private static double inputD(String stringLine){
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print(stringLine);
        return consoleScanner.nextDouble();
    }
    private static double power(double number, double powerNumber){
        // Only does positive powers, no negatives, right now at least
        double valueToReturn = 1;
        int Root = 0;
        double Power = powerNumber;

        // Will check if the power is an inverse power
        if (powerNumber < 0){
            powerNumber *= -1;
            number = 1 / number;
        }
        // will check if square root is needed or not.
        while ((Power - ((int) Power) != 0)){
            Root++;
            Power = Root * powerNumber;
        }

        for (; Power > 0; Power--){
            if (powerNumber < 1){
                valueToReturn *= number;
                break;
            }
            valueToReturn *= number;
        }
        if (Root == 2)
            return sqrt(valueToReturn, 6);
        return valueToReturn;
    }
    public static double sqrt(double number, int accuracy){
        // at this point I am not torturing myself to also do a cube root and whatnot
        // number: number is the number that is wanted to be square rooted so if number is 4, 2 will be returned
        // accuracy is the number of decimal points to return
        int position = 0;
        long currentNumber;
        int tempAccuracy = accuracy+1;
        double rootNumber = 0;
        int digitLength = lengthOfNumber(number, false);
        if (digitLength % 2 != 0){
            currentNumber = returnNDigit(number, position++);
            digitLength -= 1;
        }
        else{
            currentNumber = sD(returnNDigit(number, position++), returnNDigit(number, position++));
            digitLength -= 2;
        }
        boolean reachedDecimal = false;
        while (!reachedDecimal || tempAccuracy > 0) {
            for (int num = 1; num <= 10; num++){
                if (currentNumber < ((rootNumber * 2) * 10 + num) * num){
                    currentNumber -= ((rootNumber * 2) * 10 + (num - 1)) * (num - 1);
                    rootNumber = rootNumber * 10 + num - 1;
                    break;
                }
            }
            if (!reachedDecimal){
                if (digitLength != 0){
                    currentNumber = sD(sD(currentNumber, returnNDigit(number, position++)), returnNDigit(number, position++));
                    digitLength -= 2;
                }
                else{
                    reachedDecimal = true;
                    position++;
                    digitLength = lengthOfNumber(number, true) - position;
                }
            }
            if (reachedDecimal) {
                switch(digitLength){
                    case 0:
                        currentNumber = sD(sD(currentNumber, 0), 0);
                        break;
                    case 1:
                        currentNumber = sD(sD(currentNumber, position++), 0);
                        digitLength -= 1;
                        break;
                    default:
                        currentNumber = sD(sD(currentNumber, returnNDigit(number, position++)), returnNDigit(number, position++));
                        digitLength -= 2;
                        break;
                }
                tempAccuracy -= 1;
            }
        }
        return Math.round(rootNumber) / power(10, accuracy);
    }
    private static long sD(long num, int newDigit){
        //sD means shift Digit by 1 digit and add new digit to end, send 0 to newDigit if you want to only shift
        return (num * 10) + newDigit;
    }
    private static int lengthOfNumber(double number, boolean includeDecimal){
        String numberString = Double.toString(number);
        //System.out.println("The Length of the Number (" + number + ") is: " + numberString.length());
        for (int digit = 0; digit < numberString.length(); digit++){
            if (Character.compare(numberString.charAt(digit), '.') == 0){
                if (includeDecimal){
                    return numberString.length() - 1;
                }
                return digit;
            }
        }
        return numberString.length();
    }
    private static int returnNDigit(double number, int N){
        String numberString = Double.toString(number);
        return ((int) (numberString.charAt(N))) - 48;
    }
}
