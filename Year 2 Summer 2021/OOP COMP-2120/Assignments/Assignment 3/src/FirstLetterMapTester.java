import java.io.File;

/*
* * * Java Files needed for this Tester.
* FirstLetterMapTester.java
* FirstLetterMap.java

* test1.txt
* test2.txt
* test3.txt
*/


public class FirstLetterMapTester {
    public static void main(String[] args){
        // I missed the input file part originally so I thought we were supposed to format a string given.
        if (new File("test1.txt").exists()){
            FirstLetterMap F1 = new FirstLetterMap("test1.txt");
            System.out.println(F1);
        }
        if (new File("test3.txt").exists()){
            FirstLetterMap F2 = new FirstLetterMap("test3.txt");
            System.out.println(F2);
        }
        System.out.println("Was Returned: ");
        if (new File("test2.txt").exists()){
            FirstLetterMap F3 = new FirstLetterMap("test2.txt");
            System.out.println(F3);
        }
        else {
            // If the TA wants to test this program themselves but don't got the test files on hand this will just input a test string for them.
            FirstLetterMap F = new FirstLetterMap("She took down a jar from one of the shelves as she passed; it was labelled 'ORANGE MARMALADE', but to her great disappointment it was empty.");
            System.out.println(F);
        }

        System.out.println("Expected: \n" +
                "a: [a, as]\n" +
                "b: [but]\n" +
                "d: [disappointment, down]\n" +
                "e: [empty]\n" +
                "f: [from]\n" +
                "g: [great]\n" +
                "h: [her]\n" +
                "i: [it]\n" +
                "j: [jar]\n" +
                "l: [labelled]\n" +
                "m: [marmalade]\n" +
                "o: [of, one, orange]\n" +
                "p: [passed]\n" +
                "s: [she, shelves]\n" +
                "t: [the, to, took]\n" +
                "w: [was]");
    }
}
