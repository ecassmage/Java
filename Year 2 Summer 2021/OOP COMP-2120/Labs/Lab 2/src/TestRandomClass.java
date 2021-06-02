import java.util.Random;

public class TestRandomClass {
    private Random ThisIsDefinitelyRandom = new Random();
    public static void main(String[] args){
        TestRandomClass test = new TestRandomClass();
        for (int i = 0; i < 5; i++){System.out.println(test.randomInt());}
        System.out.println();
        for (int i = 0; i < 5; i++){System.out.println(test.randomDouble());}
        System.out.println();
        for (int i = 0; i < 5; i++){System.out.println(test.randomInt(10, 20+1));}
        System.out.println();
        for (int i = 0; i < 5; i++){System.out.println(test.randomEvenInts(10, 100+1));}
        System.out.println();
        for (int i = 0; i < 5; i++){System.out.println(test.flipCoinString());}
        System.out.println();
    }
    public int randomInt(int lowerBound, int upperBound){
        return ThisIsDefinitelyRandom.nextInt(upperBound - lowerBound) + lowerBound;
    }
    public int randomInt(){
        return ThisIsDefinitelyRandom.nextInt();
    }
    public double randomDouble(int lowerBound, int upperBound){
        return ThisIsDefinitelyRandom.nextDouble() + randomInt(lowerBound, upperBound-1);
    }
    public double randomDouble(){
        return ThisIsDefinitelyRandom.nextDouble();
    }
    public int randomEvenInts(int lowerBound, int upperBound){
        if (upperBound % 2 == 1) upperBound += 1;
        return (ThisIsDefinitelyRandom.nextInt((upperBound - lowerBound) / 2) * 2) + lowerBound;
    }
    public String flipCoinString(){
        if (ThisIsDefinitelyRandom.nextBoolean()) return "Head";
        else return "Tail";
    }
    public int flipCoinInt(){
        return ThisIsDefinitelyRandom.nextBoolean() ?1:0;
    }
}
