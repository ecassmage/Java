public class Person {
    private String Name;
    private int Age;

    public Person(String name, int age){
        this.Name = name;
        this.Age = age;
    }
    public int getAge(){
        return Age;
    }
    public String getName(){
        return Name;
    }
    public void changeName(String name){
        Name = name;
    }
    public void changeAge(int age){
        Age = age;
    }
    public static void main(String[] args){
        Person Evan = new Person("Evan", 20);
        System.out.println(Evan.Name);
        System.out.println(Evan.Age);
        System.out.println(Evan.getAge());
        System.out.println(Evan.getName());
        Evan.changeAge(21);
        Evan.changeName("Not Evan");
        System.out.println(Evan.Name);
        System.out.println(Evan.Age);
        System.out.println(Evan.getAge());
        System.out.println(Evan.getName());
    }
}
