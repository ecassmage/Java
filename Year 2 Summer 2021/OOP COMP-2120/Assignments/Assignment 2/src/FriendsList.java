import java.lang.reflect.*;
import java.util.Arrays;

public class FriendsList {
    private Person[] FriendsList;
//    private int[] quickLastNames = null;
    private int Len = 0;
    public static void main(String[] args){
        FriendsList list = new FriendsList();
        Person F1 = new Person("Evan Morrison", "519 318 2704", 4, 10);
        Person F10 = new Person("Evan Morrison", "519 318 2704", 4, 10);
        Person F11 = new Person("Evan Morrisons", "519 318 2704", 4, 10);
        Person F12 = new Person("Evan Morrisogn", "519 318 2704", 4, 10);
        Person F2 = new Person("Bob Johnson", "12 22344 5566", 3, 12);
        Person F3 = new Person("Cod Wallet", "1 234 345 4456", 12, 31);
        Person F4 = new Person("Bring", "it-on", "7 519 1112 54", 12, 1, "7 XXX-XXXX-XX");
        Person F5 = new Person("Loser Fire", "519 123 1234", 4, 5);
        Person F6 = new Person("Connor Morrison", "519 318 0030", 4, 1);
        Person F7 = new Person("Evan McMullet", "519 873 2345", 5, 3);
        Person F8 = new Person("Johnny Boy", "15193182704", 1, 1);
        Person F9 = new Person();
        list.addFriend(F1);
        list.addFriend(F10);
        list.addFriend(F11);
        list.addFriend(F12);
        list.addFriend(F2);
        list.addFriend(F3);
        list.addFriend(F4);
        list.addFriend(F5);
        list.addFriend(F6);
        list.addFriend(F7);
        list.addFriend(F8);
        list.addFriend(F9);
        System.out.println(list.getCellPhoneWithName("Evan", "Morrison"));
        Person[] lis1 = list.lastNamesSorted();
        Person[] lis2 = list.firstNamesSorted();
        Person[] lis3 = list.cellPhoneSorted();
        Person[] lis4 = list.birthMonthSorted();
        Person[] lis5 = list.birthDaySorted();
        printList(lis1, "LastName");
        printList(lis2, "FirstName");
        printList(lis3, "CellPhone");
        printList(lis4, "BirthMonth");
        printList(lis5, "BirthDay");
        Person[] listTempM = list.getListByMonth("April");
        printList(listTempM, "BirthDay");
        Person[] listTemp = list.getListByDay(10);
        printList(listTemp, "LastName");
//        printList(listTemp, "BirthDay");
//        list.printListOfPersons("LastName");
//        list.printListOfPersons();
//        list.printListOfPersons("FirstName");
//        list.printListOfPersons("CellPhone");
//        list.printListOfPersons("BirthMonth");
//        list.printListOfPersons("BirthDay");
        System.out.println(list.getFriendCount());
    }

    // Public Stuff

    public void addFriend(Person person){
        Len++; // I realized .length existed after I started doing it this way so I am not changing it.
        Person[] tempList = FriendsList;
        FriendsList = new Person[Len];
        for (int i = 0; i < Len - 1; i++){
            FriendsList[i] = tempList[i];
        }
        FriendsList[Len-1] = person;
    }
    public void addListOfFriends(Person[] people){ for (Person person: people) addFriend(person); }

    public void deleteFriend(Person person){
        Len--;
        Person[] tempList = FriendsList;
        FriendsList = new Person[Len];
        int i = 0;
        for (Person personInQuestion: tempList){
            if (personInQuestion == person) continue;
            FriendsList[i++] = personInQuestion;
        }
    }
    public void deletePeopleWithNames(String name){
        for (Person person: FriendsList){
            if (person.getFirstName().equals(name)) deleteFriend(person);
        }
    }

    public void modifyFriendName(Person person, String newName){ person.setName(newName); }
    public void modifyFriendName(Person person, String newFName, String newLName){ person.setName(newFName + " " + newLName); }
    public void modifyFriendFirstName(Person person, String newFName){ person.setName(newFName + " " + person.getLastName()); }
    public void modifyFriendLastName(Person person, String newLName){ person.setName(person.getFirstName() + " " + newLName); }
    public void modifyFriendPhoneNumber(Person person, String newNumber){ person.setCellNumber(newNumber); }
    public void modifyFriend(Person person, String newFName, String newLName, String newNumber, int newBirthMonth, int newBirthDay) { modifyFriend(person, new Person(newFName, newLName, newNumber, newBirthMonth, newBirthDay)); }
    public void modifyFriend(Person person, String newFName, String newLName, String newNumber, int newBirthMonth, int newBirthDay, String newFormat) { modifyFriend(person, new Person(newFName, newLName, newNumber, newBirthMonth, newBirthDay, newFormat)); }

    public void printSortedListOfPersons(String formatType) {
        int number = controlBoard(formatType);
        Person[] list;
        list = PersonsSortedStrings(FriendsList.clone(), number);
        printList(list, number);
    }

        //sorting FriendsList
    public static Person[] sort(Person[] list, String formatString){return PersonsSortedStrings(list.clone(), controlBoard(formatString));}
    public Person[] lastNamesSorted(){return PersonsSortedStrings(FriendsList.clone(), 1);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.
    public Person[] firstNamesSorted(){return PersonsSortedStrings(FriendsList.clone(), 2);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.
    public Person[] cellPhoneSorted(){return PersonsSortedStrings(FriendsList.clone(), 3);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.
    public Person[] birthMonthSorted(){return PersonsSortedStrings(FriendsList.clone(), 4);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.
    public Person[] birthDaySorted(){return PersonsSortedStrings(FriendsList.clone(), 5);} // Yay just love being able to do things like this. Missed this in C. Python Spoiled me.

        //getListByMonth
    public Person[] getListByMonth(int month){return getListByMonth(FriendsList, month, true);}
    public Person[] getListByMonth(String month){return getListByMonth(FriendsList, month, true);}

        //getListByDay
        public Person[] getListByDay(int day){return getListByDay(FriendsList, day, true);}
        // Print List Out
    public static void printList(Person[] list, String code){printList(list, controlBoard(code));}
    public void printList(String code){printList(FriendsList, controlBoard(code));}
        //Get Phone Number
    public String getCellPhoneWithName(String fName, String lName){ return getCellPhoneWithName(fName + " " + lName); }
    public String getCellPhoneWithName(String name){
        String number = null;
        for (Person person: FriendsList){
            if (person.getName().equals(name)) {
                if (number != null){
                    System.out.println("There are more then 1: " + name + "'s found in the Friends List");
                    return number;
                }
                number = person.getCellNumber();
            }
        }
        return number;

    }
        // Getters
    public static int len(FriendsList fl){ return fl.Len; }
            // Required Methods
    public Person[] getSortedByLastNames(){ return lastNamesSorted(); }
    public int getFriendCount(){ return len(this); }
    public Person[] getSortedByDayBornInMonth(String month){ return getListByMonth(month); }
    public Person[] getSortedByLastNamesWithDay(int day){ return getListByDay(day); }
            // Required Methods
            //GetPerson
    public Person getPerson(String fName, String lName){return getPerson(new String[]{fName, lName}, null, 0, 0, false)[0];}
    public Person getPerson(String Number){return getPerson(new String[]{null, null}, Number, 0, 0, false)[0];}
    public Person getPerson(int bMonth, int bDay){ return getPerson(new String[]{null, null}, null, bMonth, bDay, false)[0]; }
            //GetPerson
            //GetPeople
    public Person[] getPeople(String fName, String lName){return getPerson(new String[]{fName, lName}, null, 0, 0, true);}
    public Person[] getPeople(String Number){return getPerson(new String[]{null, null}, Number, 0, 0, true);}
    public Person[] getPeople(int bMonth, int bDay){ return getPerson(new String[]{null, null}, null, bMonth, bDay, true); }
            //GetPeople
    //Getters

    // Public Stuff


    // Private Stuff

    private void modifyFriend(Person person, Person replaceThisBadPerson){
        person.setName(replaceThisBadPerson.getName());
        person.setCellFormat(replaceThisBadPerson.getCellFormat());
        person.setCellNumber(replaceThisBadPerson.getCellNumber());
        person.setBirthMonth(replaceThisBadPerson.getBirthMonth());
        person.setBirthDay(replaceThisBadPerson.getBirthDay());
    }

    private static void switchPositions(Person[] list, int person1, int person2){
        Person temp = list[person1];
        list[person1] = list[person2];
        list[person2] = temp;
    }
    private static boolean matchWords(String person1, String person2){
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
            return person1.length() > person2.length();
        //}
    }

    private static Person[] PersonsSortedStrings(Person[] list, int code){
        if (code == 0) return list;
        for (int i = 1; i < list.length; i++) for (int j = 0; j < list.length-i; j++) {
            String person1 = "";
            String person2 = "";
            switch(code){
                case 1:
                    person1 = list[j].getLastName();
                    person2 = list[j + 1].getLastName();
                    break;
                case 2:
                    person1 = list[j].getFirstName();
                    person2 = list[j + 1].getFirstName();
                    break;
                case 3:
                    person1 = list[j].getCellNumber();
                    person2 = list[j + 1].getCellNumber();
                    break;
                case 4:
                    boolean truck = (PersonsSortedInt(list[j].getBirthMonth(), list[j + 1].getBirthMonth()));
                    int one = list[j].getBirthMonth();
                    int two = list[j+1].getBirthMonth();
                    if (PersonsSortedInt(list[j].getBirthMonth(), list[j + 1].getBirthMonth())) switchPositions(list, j, j + 1);
                    continue;
                case 5:
                    if (PersonsSortedInt(list[j].getBirthDay(), list[j + 1].getBirthDay())) switchPositions(list, j, j + 1);
                    continue;
            }
            if (person1 == null) continue;
            if (person2 == null || matchWords(person1, person2))
                switchPositions(list, j, j + 1);
        }
        return list;
    }
    private static boolean PersonsSortedInt(int person1, int person2){
        return !(person1 == 0) && (person2 == 0 || person1 > person2);
    }

    private Person[] getListByMonth(Person[] list, String month, boolean sortByDay){ // Inner use to call more controllable
        String[] arr = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        month = month.toLowerCase();
        for (int i = 1; i < 12; i++){
            if (arr[i].equals(month)) return getListByMonth(list, i+1, sortByDay);
        }
        System.out.println(month + " is not a Real Month");
        return null;
    }
    // You Might be wondering why I have sortByDay here when it is always true and that is because I like to have the ability to change things easily.
    private Person[] getListByMonth(Person[] list, int month, boolean sortByDay){ // Inner use to call more controllable

        Person[] listOfMonth = new Person[list.length];
        int p = 0;

        for (int i = 0; i < list.length; i++)
            if (list[i].getBirthMonth() == month) listOfMonth[p++] = list[i];

        list = new Person[p];

        for (int i = 0; i < p; i++) list[i] = listOfMonth[i]; // To get rid of any empty Cells.

        if (sortByDay) return PersonsSortedStrings(list, 5); // code: 5 is "BirthDay";
        return list;
    }

    private Person[] getListByDay(Person[] list, int day, boolean sortByLastName){
        Person[] listOfDay = new Person[list.length];
        int p = 0;

        for (int i = 0; i < list.length; i++)
            if (list[i].getBirthDay() == day) listOfDay[p++] = list[i];

        list = new Person[p];

        for (int i = 0; i < p; i++) list[i] = listOfDay[i]; // To get rid of any empty Cells.

        if (sortByLastName) return PersonsSortedStrings(list, 1);
        return list;
    }

//    public Person[] bornInMonth(Person[] list, String month){
//        String[] arr = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
//        month = month.toLowerCase();
//        for (int i = 1; i < 12; i++){
//            if (arr[i].equals(month)) return PersonsSortedInt(1, i+1);
//        }
//        System.out.println(month + " is not a Real Month");
//        return null;
//    }


    public static int controlBoard(String formatType){
        switch(formatType){
            case "LastName", "LastNames":        return 1;
            case "FirstName", "FirstNames":       return 2;
            case "CellPhone", "CellPhones":       return 3;
            case "BirthMonth", "BirthMonths":      return 4;
            case "BirthDay", "BirthDays":        return 5;
            case "Name", "Names": default:   return 0;
        }
    }

    public void printFormatCodes(){
        System.out.println(
                "LastName: Prints the Last Name of the People in the List\n" +
                "FirstName: Prints the First Name of the People in the List\n" +
                "CellPhone: Prints the Cell Phone of the People in the List\n" +
                "BirthMonth: Prints the Birth Month of the People in the List\n" +
                "BirthDay: Prints the Birth Day of the People in the List\n" +
                "Name: Prints the Full Name of the People in the List\n"
        );
    }
    // Redundant
    private static String printErrorStrings(int code){
        switch(code){
            case 1:   return "This list Contains No one with a Last Name";
            case 2:   return "This list Contains No one with a First Name";
            case 3:   return "This list Contains No one with a Cell Phone";
            case 4:   return "This list Contains No one with a Birth Month";
            case 5:   return "This list Contains No one with a Birth Day";
            default:  return "This list Contains No one with a Name";
        }
    }

    private static void printList(Person[] list, int code){
        try {
            // I used this page to figure out how to get this Method stuff working https://stackoverflow.com/questions/160970/how-do-i-invoke-a-java-method-when-given-the-method-name-as-a-string
            // Knew this was a thing since I did this stuff plenty in Python but didn't know if it was possible in Java so Kind of happy it is.
            /*
                I wanted this a little more compressed then making a bunch of if and else statements everywhere and
                this way I can scale it up easier since I just need to add 1 more else if at the top and then
                add the new method to the arr array and it should take care of everything else
            */
            String[] arr = {"getName", "getLastName", "getFirstName", "getCellNumber", "getBirthMonth", "getBirthDay"};
            if (list.length == 0) {
                System.out.println("This list Contains Nothing");
                return;
            }
            Method method = list[0].getClass().getMethod(arr[code]);
            for (int i = 0; i < list.length; i++) {
                System.out.println("Person " + (i+1) + ": " + method.invoke(list[i]));
            }
            System.out.println();
        } catch(Exception NoSuchMethodException) {
            System.out.println("ERROR: " + NoSuchMethodException.toString());
            System.exit(0);
        }
    }

    private Person[] getPerson(String[] Name, String Number, int bMonth, int bDay, boolean listOrNot){
        Person[] listOfPeople = null;
        for (Person person : FriendsList) {
            if (Name[0] != null && !(person.getFirstName().equals(Name[0])))
                continue;
            if (Name[1] != null && !(person.getLastName().equals(Name[1])))
                continue;
            if (Number != null && !((person.getCellNumber().equals(Number) && (person.getCellNumberJustNumbers().equals(Number)))))
                continue;
            if (bMonth != 0 && !(person.getBirthMonth() == bMonth))
                continue;
            if (bDay != 0 && !(person.getBirthDay() == bDay))
                continue;
            if (listOrNot) {
                if (listOfPeople == null) listOfPeople = new Person[]{person};
                else listOfPeople = Arrays.copyOf(listOfPeople, listOfPeople.length+1);
                listOfPeople[listOfPeople.length - 1] = person;
            }
            else return new Person[]{person};
        }
        if (listOfPeople == null) listOfPeople = new Person[]{null};
        return listOfPeople;
    }
    public void printPerson(Person person){
        if (person == null) return;
        person.PrintPerson();
    }
}
