public class Main {

    public static void main(String[] args) {
        Person Evan = new Person("Evan", 20);
        System.out.println(Evan.getName());
        System.out.println(Evan.getAge());
        Evan.changeName("Evan is the New Name");
        System.out.println(Evan.getName());
    }
}
