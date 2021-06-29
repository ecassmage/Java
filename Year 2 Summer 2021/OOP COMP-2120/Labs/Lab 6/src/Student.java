public class Student extends Person {
    private String Program;
    private String Level;
    private int year;
    public static void main(String[] args){

    }

    public Student(String name, int age, String gender, String program, String level, int year){
        this(name.split(" "), age, gender, program, level, year);
    }
    public Student(String[] name, int age, String gender, String program, String level, int year){
        super(name, age, gender);
        this.Program = program;
        this.Level = level;
        this.year = year;
    }

    @Override
    public String toString(){
        //No Idea if needed, probably not but meh.
        return getName() + ", Student, Program = " + Program + ", Level = " + Level + ", Year = " + year;
    }

    public String getProgram(){ return Program; }
    public String getLevel(){ return Level; }
    public int getYear(){ return year; }

    public void setProgram(String program) { this.Program = program; }
    public void setLevel(String level) { this.Level = level; }
    public void setYear(int year) { this.year = year; }
}
