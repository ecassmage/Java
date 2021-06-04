public class MyFriends {
    public static void main(String[] args){
        FriendsList list = new FriendsList();
        Person[] listOfFriends = {
            new Person("Evan Morrison", "519 318 2704", 4, 10),
            new Person("Evan NotMorrison", "519 318 2704", 4, 10),
            new Person("Evan HorrorMorrison", "519 318 2704", 4, 10),
            new Person("Evan Not-A-Real-Person-Morrison", "519 318 2704", 4, 10),
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
        for (Person person: listOfFriends){
            list.addFriend(person); // Why you might ask can you not create a new human with addFriend. Well simple, because you can't just create a new human by adding them to a friends list, they got to have existed first before you can add them.
        }

        list.addFriend(badFriend);
        list.printFormatCodes();
        list.printList("Name");
        list.deleteFriend(badFriend);
        list.printList("Name");
    }
}
