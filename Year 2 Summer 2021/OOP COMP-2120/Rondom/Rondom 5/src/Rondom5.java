import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Rondom5 {
    public static void main(String[] args) {

    }
    public static void doSomething (int[] values, int p1, int p2)
    {
        int temp = values[p1];
        values[p1] = values[p2];
        values[p2] = temp;
    }
}