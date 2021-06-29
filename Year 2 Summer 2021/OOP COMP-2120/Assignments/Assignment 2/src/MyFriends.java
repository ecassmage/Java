public class MyFriends {
    public static void main(String[] args){
        FriendList list = new FriendList();
        Person[] listOfFriends = {
            new Person("Evan Morrison", "519 318 2704", 4, 10),
            new Person("Evan NotMorrison", "519 318 2704", 4, 10),
            new Person("Evan HorrorMorrison", "519 318 2704", 4, 15),
            new Person("Evan Not-A-Real-Person-Morrison", "519 318 2704", 4, 30),
            new Person("Evan Invisiboi", "532 522 3224", 4, 21),
            new Person("Bob Johnson", "12 22344 5566", 3, 12),
            new Person("Cod Wallet", "1 234 345 4456", 12, 31),
            new Person("Bring", "It-on", "7 519 1112 54", 12, 1, "7 XXX-XXXX-XX"),
            new Person("Loser Fire", "519 123 1234", 4, 5),
            new Person("Connor Morrison", "519 318 9876", 8, 1),
            new Person("Evan McMullet", "519 873 2345", 5, 3),
            new Person("Johnny Boy", "15193182704", 1, 1),
            new Person("Patti Burke", "519 123 1234", 9, 29),
            new Person("Chris", "Morrison", "519 123 1234", 3, 16)
        };
        Person badFriend = new Person("Bad", "Evan", "519 666 0009", 6, 66, "\\666/ (XXX) XXX-XXXX");
        list.addListOfFriends(listOfFriends);
        list.addFriend(badFriend);
        list.printFormatCodes();
        list.printList("Name"); // Prints First Names
        list.deleteFriend(badFriend);
        list.printList("Name"); // Prints First Names
        list.modifyFriend(list.getPerson("Evan", "Morrison"), "Evan", "Borrison", "5197222569", 8, 11, "111 XXX XXX XXXX");
        list.printPerson(list.getPerson("Evan", "Morrison"));
        list.printPerson(list.getPerson("Evan", "Borrison"));
        Person[] listOfLastNames = list.getSortedByLastNames();
        FriendList.printList(listOfLastNames, "Names");
        Person[] listOfAprilBirthdays = list.getListByMonth("April"); // You can also put just 4 in as well to get april, Strings though seem easier for most to understand quickly
        FriendList.printList(listOfAprilBirthdays, "BirthDay");
        Person[] listOf1stBDaysByLastName = list.getListByDay(1);
        FriendList.printList(listOf1stBDaysByLastName, "LastName");
        list.modifyFriend(list.getPerson("Loser", "Fire"), "April", "Tenth", "5191111111", 4, 10);
        Person[] listOfFriendsBornAprilTenth = list.getPeople(4, 10);
        FriendList.printList(listOfFriendsBornAprilTenth, "Names");
        String phoneNumber = list.getCellPhoneWithName("Cod Wallet");
        System.out.println("Expected Phone Number: 1 234 345-4456, Received: " + phoneNumber);
        shaneTest(list);
    }

    private static void shaneTest(FriendList list){
        Person[] listOfPeople = {
                new Person("Shane Hall"), // 1
                new Person("Hello World"),
                new Person("Professor Bob"),
                new Person("Java Developer"),
                new Person("Mr Java"),
                new Person("Mr Python"),
                new Person("Mr C"),
                new Person("Shane John"), // 2
                new Person("Shawn Bon"),
                new Person("Filament Tungsten"),
                new Person("Gold Or"),
                new Person("Silver Argent"),
                new Person("Not Creative"),
                new Person("Python Is-Better:)"),
                new Person("Something Something"),
                new Person("Shane IsGone"), // 3
                new Person("Future Money"),
                new Person("Mr Monopoly"),
                new Person("Ms Monopoly"),
                new Person("Brother Monopoly"),
                new Person("Sister Monopoly"),
                new Person("Shane Monopoly"), // 4
                new Person("Baby Monopoly"),
                new Person("Dog Monopoly"),
                new Person("Cat Monopoly"),
                new Person("House Monopoly")
        };
        list.addListOfFriends(listOfPeople);
        System.out.println("\n\nThis is a List of Shanes and Others\n");
        list.printList("Names");
        list.deletePeopleWithNames("Shane");
        list.printList("Names");
    }
}
