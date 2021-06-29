public class Manager extends Employee {
    private double bonus;
    public static void main(String[] args){

    }

    public Manager(){this(new String[]{null, null}, 0, "Apache Attack Helicopter", 0, new int[]{0, 0, 0}, 0);}
    public Manager(double bonus){ this(new String[]{null, null}, 0, "Apache Attack Helicopter", 0, new int[]{0, 0, 0}, bonus); }
    public Manager(String name, int age, String Gender , double Salary, int hiringYear, double bonus){ this(name.split(" "), age, Gender, Salary, new int[]{0, 0, hiringYear}, bonus); }
    public Manager(String name, int age, String Gender, double Salary, int[] DMY, double bonus){ this(name.split(" "), age, Gender, Salary, DMY, bonus); }
    public Manager(String fName, String lName, int age, String Gender, double Salary, int[] DMY, double bonus){ this(new String[]{fName, lName}, age, Gender, Salary, DMY, bonus); }

    public Manager(String[] name, int age, String Gender, double Salary, int[] DMY, double bonus){
        super(name, age, Gender, Salary, DMY);
        this.bonus = bonus;
    }

    @Override
    public String toString(){
        return getName() + ", Manager, Salary = $" + getSalary() + "/year, Weekly Bonus = " + bonus;
    }

    public void setBonus(double bonus){ this.bonus = bonus; };
}
