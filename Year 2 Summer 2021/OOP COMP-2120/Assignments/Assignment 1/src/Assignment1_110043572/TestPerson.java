public class TestPerson {
    public static void main(String[] args){
        Person person = new Person(true); // this true just turns on some notifications for if the person is hungry or sleepy or not
        Person friend1 = new Person(false);
        Person friend2 = new Person(false);

        person.talk("I Want to Talk");
        person.eat();
        person.needFood();
        person.eat();
        person.walk(1.75);
        person.sleep();
        person.walk(3);
        person.awake();
        person.sleep();
        person.awake();
        person.grow();
        person.grow();
        person.talk("I Want to Talk");
        for (int i = 0; i < 55; i++) {person.grow();}
        person.walk(2);
        person.walk(2);
        person.sleep();
        person.awake();
        for (int i = 0; i < 5; i++) {person.grow();}
        person.walk(2);
        person.sleep();
        person.awake();
        person.getFriend(friend1);
        person.changeFriend(friend2);
    }
}
