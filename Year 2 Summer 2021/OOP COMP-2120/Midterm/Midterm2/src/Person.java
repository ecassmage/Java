public class Person {
    private String firstName;
    private String lastName;

    public Person(){};

    public Person(String firstName, String lastName){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
