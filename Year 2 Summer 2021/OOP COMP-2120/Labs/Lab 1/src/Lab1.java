import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Lab1 {
        public static void main(String[] args) {
                Activity1();
                Activity2();
        }
        public static void Activity1(){
                // This is for Activity 1, Kept separate from Activity 2 for ease of reading.
                String name = JOptionPane.showInputDialog("What is your name?");
                System.out.println("\"Hello, " + name + "!\"");
        }
        public static void Activity2(){
                // This is for Activity 2, Kept separate from Activity 1 for ease of reading.
                ArrayList<String> ThreeNames = new ArrayList<String>(); // I could just print 1 after the other only using string but I like this more.
                for (int nameCount = 1; nameCount <= 3; nameCount++) {
                        ThreeNames.add(JOptionPane.showInputDialog("What is friend number " + nameCount + "'s name?"));
                }
                printNames(ThreeNames);
        }
        public static void printNames (ArrayList<String> list){
                for (int position = 0; position < list.toArray().length; position++){
                        System.out.println((position + 1) + "\t" + list.get(position));
                }
        }
}
