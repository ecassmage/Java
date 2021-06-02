import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Part1and2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\Github\\JavaScript\\Advent_of_Code\\Advent_of_Code_2020\\Day1\\input.txt");
        Scanner scan = new Scanner(file);
        //String nums[];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (scan.hasNextLine()) {
            nums.add(Integer.parseInt(scan.nextLine()));
        }
        //System.out.println(nums);
        System.out.println("\nMaking the answer to Part 1 be: " + two_sum(nums));
        System.out.println("\nMaking the answer to Part 2 be: " + three_sum(nums));

    }
    public static int two_sum(ArrayList<Integer> x) {
        int zz = 0;
        for (int i = 0; i < x.size(); i++){
            Integer y = x.get(i);
            for (int j = i+1; j < x.size(); j++){
                Integer z = x.get(j);
                if (y + z == 2020){
                    zz = y * z;
                    String answer = "The Answer to Part 1 is: " + y + " and: " + z;
                    System.out.println(answer);
                    return zz;
                }
            }
        }
        return 0;
    }
    public static int three_sum(ArrayList<Integer> x) {
        int zz = 0;
        for (int i = 0; i < x.size(); i++){
            Integer y = x.get(i);
            for (int j = i+1; j < x.size(); j++){
                Integer z = x.get(j);
                for (int m = j+1; m < x.size(); m++){
                    Integer w = x.get(m);
                    if (y + z + w == 2020){
                        zz = y * z * w;
                        String answer = "The Answer to Part 2 is: " + y + " , " + z + " , " + w;
                        System.out.println(answer);
                        return zz;
                    }
                }
            }
        }
        return 0;
    }
}
