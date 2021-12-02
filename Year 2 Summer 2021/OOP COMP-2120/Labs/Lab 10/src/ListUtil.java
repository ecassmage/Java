import java.util.LinkedList;
/**
 This class supplies a utility method to reverse the entries in a linked list.
 */
public class ListUtil {
    /**
     Reverses the elements in a linked list
     @param list the linked list to reverse
     */
    public static void reverse(LinkedList<String> list) {
        // I Copy Pasted From ArrayListUtil.java
        for (int i = 1; i < list.size(); i++)   // This loops through the array. can't use fancy for loop since manipulating array.
            list.add(0, list.remove(i));  // First removes the Element at Index I then once it is returned, adds it back into the list at index 0, pushing everything else up 1 index position.
    }
}