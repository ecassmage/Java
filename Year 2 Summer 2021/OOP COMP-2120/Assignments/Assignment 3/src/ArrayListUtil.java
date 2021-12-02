import java.util.ArrayList;

/*
 * * * Java Files needed for this Tester.
 * ArrayListUtil.java
 */

public class ArrayListUtil {
    // Not sure if this is Cheating since I just copy pasted my lab 10 answers since they were the same questions.
    public static void main(String[] args){
        // No Tester Was Asked for So I am felt like this was okay to use.
        ArrayList<String> S = new ArrayList<>();
        S.add("hello");
        S.add("bello");
        S.add("mello");
        S.add("coolio");
        S.add("Evan");
        S.add("Morrison");
        System.out.println(S);  // Printing Original
        invertArrayList(S);  // Inverting Array
        System.out.println(S);  // Printing Inverted Array
        invertArrayList(S);  // Inverting Array back to Original
        System.out.println(S);  // Printing Original
        ArrayList<String> S2 = invertArrayListCopy(S);  // Inverting Array, Returning Copy
        System.out.println("\n" + S + "\n" + S2);  // Printing Both Inverted Arrays
        S2.add("HiWorld");  // Adding a String To prove these two objects are different.
        System.out.println("\n" + S + "\n" + S2);  // Printing Both Inverted Arrays to Prove that the Objects are different.
    }

    public static <E> void invertArrayList(ArrayList<E> list){
        for (int i = 1; i < list.size(); i++)   // This loops through the array. can't use fancy for loop since manipulating array.
            list.add(0, list.remove(i));  // First removes the Element at Index I then once it is returned, adds it back into the list at index 0, pushing everything else up 1 index position.
    }
    public static <E> ArrayList<E> invertArrayListCopy(ArrayList<E> list){
        ArrayList<E> newList = new ArrayList<>(list);
        invertArrayList(newList);
        return newList;
    }
}
