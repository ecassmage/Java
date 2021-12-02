import java.util.*;

public class Rondom<E> {

    public static void main(String[] args){
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("ab");
        stringQueue.add("abc");
        stringQueue.add("a");
        while (stringQueue.size() > 0)
        {
            System.out.print(stringQueue.remove() + ",");
        }
    }
    public static void helloGoodbye(LinkedList<String> theList)
    {

        ListIterator<String> iterator = theList.listIterator();
        while (iterator.hasNext())
        {
            if (iterator.next().equals("hello"))
            {
                iterator.set("goodbye");
            }
        }
    }
}
