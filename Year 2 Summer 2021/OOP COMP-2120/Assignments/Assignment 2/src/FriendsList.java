import java.lang.reflect.*;

public class FriendsList {
    private Person[] FriendsList;
//    private int[] quickLastNames = null;
    private int Len = 0;
    public static void main(String[] args){
        FriendsList list = new FriendsList();
        Person F1 = new Person("Evan Morrison");
        Person F2 = new Person("Bob Johnson");
        Person F3 = new Person("Cod Wallet");
        Person F4 = new Person("Bring it-on");
        Person F5 = new Person("Loser Fire");
        Person F6 = new Person("Connor Morrison");
        Person F7 = new Person("Evan McMullet");
        Person F8 = new Person("Johnny Boy");
        Person F9 = new Person();
        list.addFriend(F1);
        list.addFriend(F2);
        list.addFriend(F3);
        list.addFriend(F4);
        list.addFriend(F5);
        list.addFriend(F6);
        list.addFriend(F7);
        list.addFriend(F8);
        list.addFriend(F9);
        Person[] lis = list.lastNamesSorted();
        list.printListOfPersons("LastName");
        list.printListOfPersons();
        list.printListOfPersons("FirstName");
        list.printListOfPersons("FirstName");
        System.out.println(list.getFriendCount());
    }

    public void addFriend(Person person){
        Len++;
        Person[] tempList = FriendsList;
        FriendsList = new Person[Len];
        for (int i = 0; i < Len - 1; i++){
            FriendsList[i] = tempList[i];
        }
        FriendsList[Len-1] = person;
    }

    private void switchPositions(Person[] list, int person1, int person2){
        Person temp = list[person1];
        list[person1] = list[person2];
        list[person2] = temp;
    }
    private boolean matchWords(String person1, String person2){
        //forElseLoop:{  // Yay a Sort of Python For Else loop want to remember this for some other project even though it is useless now that it is now in a separate function
            for (int w1 = 0; w1 < person2.length() && w1 < person1.length(); w1++){
                if (person1.charAt(w1) < person2.charAt(w1))
                    return false;
                    //break forElseLoop;

                else if (person1.charAt(w1) > person2.charAt(w1)){
                    return true;
                    //break forElseLoop;
                }
            }
            if (person1.length() > person2.length()){
                return true;
            }
            return false;
        //}
    }
    public Person[] lastNamesSorted(){return PersonsSorted(0);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.
    private Person[] PersonsSorted(int code){
        if (code == 3) return FriendsList;
        Person[] lastNameList = FriendsList;
        for (int i = 1; i < len(this); i++) for (int j = 0; j < len(this)-i; j++) {
            String person1 = "";
            String person2 = "";
                if (code == 0) {
                    person1 = lastNameList[j].getLastName();
                    person2 = lastNameList[j + 1].getLastName();
                } else if (code == 1) {
                    person1 = lastNameList[j].getFirstName();
                    person2 = lastNameList[j + 1].getFirstName();
                } else if (code == 2) {
                    person1 = lastNameList[j].getCellNumber();
                    person2 = lastNameList[j + 1].getCellNumber();
                }
            if (person1 == null) continue;
            if (person2 == null || matchWords(person1, person2))
                switchPositions(lastNameList, j, j + 1);
        }
        return lastNameList;
    }

    public void printListOfPersons() {printListOfPersons("LastName", false);}
    public void printListOfPersons(boolean fullName) {printListOfPersons("LastName", fullName);}
    public void printListOfPersons(String formatType) {printListOfPersons(formatType, false);}
    public void printListOfPersons(String formatType, boolean fullName) {
        int number;
        if (formatType.equals("LastName")) number = 0;
        else if (formatType.equals("FirstName")) number = 1;
        else if (formatType.equals("CellPhone")) number = 2;
        else number = 3;
        Person[] list;
        String[] arr = {"getLastName", "getFirstName", "getCellNumber", "getName"};
        try {
            // I used this page to figure out how to get this Method stuff working https://stackoverflow.com/questions/160970/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string
            // Knew this was a thing since I did this stuff plenty in Python but didn't know if it was possible in Java so Kind of happy it is.
            /*
                I wanted this a little more compressed then making a bunch of if and else statements everywhere and
                this way I can scale it up easier since I just need to add 1 more else if at the top and then
                add the new method to the arr array and it should take care of everything else
            */
            Method method = FriendsList[0].getClass().getMethod(arr[number]);
            list = PersonsSorted(number);

            for (int i = 0; i < len(this); i++) {
                System.out.println("Person " + (i+1) + ": " + method.invoke(list[i]));
            }
            System.out.println();
        } catch(Exception NoSuchMethodException) {
            System.out.println("ERROR: " + NoSuchMethodException.toString());
            System.exit(0);
        }
    }

//    public Person[] bornInMonth(){
//
//    }

    public static int len(FriendsList fl){ return fl.Len; }
    public int getFriendCount(){ return len(this); }
}
