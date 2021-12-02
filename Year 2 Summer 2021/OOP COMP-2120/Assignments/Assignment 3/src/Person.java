public class Person implements Comparable<Person>{

    private String Name;

    public static void main(String[] args){

    }

    public Person(String name){
        this.Name = name;
    }

    public String getName(){return Name;}

    @Override
    public int compareTo(Person obj) { return getName().compareTo(obj.getName()); }
}
