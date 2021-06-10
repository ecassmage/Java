
public class PrimeGenerator {
    private int current;
    public static void main(String[] args){
        PrimeGenerator PG = new PrimeGenerator();
        long timer = System.currentTimeMillis();
        for (int i = 0; i < 100; i++){
            System.out.println(i+1 + ": " + PG.nextPrime());
        }
        System.out.println("The Time it took was: " + ((System.currentTimeMillis() - timer) / 1000));
    }
    public PrimeGenerator() {
        current = 1;
    }

    public int nextPrime() {
        int num = current + 1;
        while(!isPrime(num))num++;
        current = num;
        return num;
    }
    public static boolean isPrime(int n) {
        if (n <= 3)     return true; // This will catch the weirdos at the bottom like 1, 2, 3 though since this starts at 1, 1 won't be caught and 1 also isn't a prime so it doesn't really matter.
        if (n % 2 == 0) return false;
        for (int i = 3; i < n / 2; i += 2){  // Going from 3 to n / 2 is more then 4x faster then going from odd(n / 2) to 2 Since it is quicker to catch many nonPrimes.
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    /*
    public int nextPrimeSlow() {
        int num = current + 1;
        while(!isPrimeSlow(num))num++;
        current = num;
        return num;
    }
    public static boolean isPrimeSlow(int n) {
        if (n <= 3) return true; // This will catch the weirdos at the bottom like 1, 2, 3 though since this starts at 1, 1 won't be caught and 1 also isn't a prime so it doesn't really matter.
        if (n % 2 == 0)
            return false;
        int i = n / 2;
        if (i % 2 == 0) i--; // since all even numbers other then 2 are not prime this is to make sure that only odds below half the original number are checked.
        for (; 2 < i; i-=2){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
     */
}