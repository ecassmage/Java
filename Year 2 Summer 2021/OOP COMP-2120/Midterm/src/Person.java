public class Person {

    private String[] name;

    public Person(String fName, String lName){
        this.name = new String[]{fName, lName};
    }

    public String fName(){
        return name[0];
    }
    public String lfName(){
        return name[1];
    }

    @Override
    public String toString(){
        return name[0] + " " + name[1];
    }
}
