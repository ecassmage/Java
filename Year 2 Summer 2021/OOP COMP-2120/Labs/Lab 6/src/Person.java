public class Person {
    private String[] Name;
    private int age;
    private String gender; // Yes You can be an Apache attack Helicopter.

    public static void main(String[] args){

    }
    public Person(String name, int age, String gender){
        this(name.split(" "), age, gender);
    }
    public Person(String[] name, int age, String gender){
        this.Name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName(){ return Name[0] + " " + Name[1]; }
    public int getAge(){ return age; }
    public String getGender(){ return gender; }

    public void setName(String name){
        this.Name = name.split(" ");
    }
    public void setFName(String fName){
        this.Name[0] = fName;
    }
    public void setLName(String lName){
        this.Name[1] = lName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString(){
        //No Idea if needed, probably not but meh.
        return getName() + ", Person, Age = " + age + ", Gender = " + gender;
    }
}
