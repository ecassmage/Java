import java.util.Scanner;

/*
 * * * Java Files needed for this Tester.
 * PersonTester.java
 * Person.java
 */

public class PersonTester {
    private static final int AmountOfPersons = 10;
    public static void main(String[] args){
        Scanner S = new Scanner(System.in);
        Person Smallest = null;
        Person Largest = null;
        Person[] listOfPeople = new Person[10];

        // I decided to do the collecting of names and determining the first and last names in tandem with each other.

        for(int i = 0; i < AmountOfPersons; i++){
            System.out.print("Please Enter Name " + (i+1) + ": ");
            String Collect = S.nextLine().replace("\n", "");
            if (Collect.length() == 0){
                System.out.println("Sorry that isn't a name");
            }
            BreakLoop:{
                for (char c: Collect.toCharArray()){
                    if (!((65 <= c && c <= 90) || (97 <= c && c <= 122) || (c == '\'' || c == '-' || c == '.'))){  // Characters Generally found in names ie A-Z and a-z as well as int some cultures - and ' ignoring characters not in the basic ascii
                        System.out.println("Sorry " + c + " is not an accepted character");
                        i--;
                        break BreakLoop;  // Sort of like a for else loop
                    }
                }
                listOfPeople[i] = new Person(Collect);
                Largest = CompareTo(Largest, listOfPeople[i], true);
                Smallest = CompareTo(Smallest, listOfPeople[i], false);
            }
        }
        System.out.println("Out of The Names we were given:");
        for (Person per: listOfPeople) System.out.println(" " + per.getName());
        System.out.println("\nThe First Alphabetically was: \t" + Smallest.getName() + "\nThe Last Alphabetically was: \t" + Largest.getName());
        // If the getName() is giving a warning for you it is wrong. this section can't be reached without Something being placed into Smallest and Largest.
    }

    public static Person CompareTo(Person per1, Person per2, boolean larger){  // larger will flip between returning the first object or the last object.
        if (per1 == null) return per2;  // This will make sure that the nulls are overridden by something.
        if (larger) return per1.compareTo(per2) < 0 ? per2 : per1;  // if larger is true return last Object
        return per1.compareTo(per2) < 0 ? per1 : per2; // if larger is false return first Object

    }
}
