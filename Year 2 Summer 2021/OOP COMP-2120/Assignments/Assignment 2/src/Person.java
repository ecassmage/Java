public class Person {

    private String[] Name = {null, null};
    private String CellNumber;
    private int[] BirthDate = {0, 0};
    private String CellFormat = "1 XXX XXX-XXXX"; // Default 1 XXX XXX-XXXX;  Unless the digit is defined to only be that digit an X needs to be placed in the position

    public static void main(String[] args){
        Person per = new Person("Evan", "Morrison", "519 318 2704", 4, 10);
        per.PrintPerson();
        Person per2 = new Person("Evan", "Morrison", "519-318-2704", 4, 10);
        per2.PrintPerson();
        Person per3 = new Person("Evan Morrison", "15193182704", 4, 10);
        per3.PrintPerson();
        Person per4 = new Person("Evan", "Morrison", "519-318-2704", new int[]{4, 10});
        per4.PrintPerson();
        Person per5 = new Person("Evan Morrison", "15193182704", new int[]{4, 10});
        per5.PrintPerson();
        per5.setCellFormat("2 XXX-XXX XXXXX");
        per5.setCellNumber("2 598 765 22234");
        per5.PrintPerson();
        Person per6 = new Person("Evan Morrison", "5193182704", new int[]{4, 10});
        per6.PrintPerson();
    }
    //Constructors
    public Person(String[] name, String cellNumber, int bMonth, int bDay){
        this.Name = new String[]{name[0], name[1]};
        this.CellNumber = formatCellPhone(cellNumber, CellFormat);
        this.BirthDate = new int[]{bMonth, bDay};
    }
    public Person(String firstName, String lastName, String cellNumber, int bMonth, int bDay){
        this(new String[]{firstName, lastName}, cellNumber, bMonth, bDay);
    }
    public Person(String firstName, String lastName, String cellNumber, int bMonth, int bDay, String newFormat){
        this.Name = new String[]{firstName, lastName};
        setCellFormat(newFormat);
        this.CellNumber = formatCellPhone(cellNumber, CellFormat);
        this.BirthDate = new int[]{bMonth, bDay};
    }
    public Person(String name, String cellNumber, int bMonth, int bDay){
        this(name.split(" "), cellNumber, bMonth, bDay);
    }
    public Person(String firstName, String lastName, String cellNumber, int[] birthDate){
        this(new String[]{firstName, lastName}, cellNumber, birthDate[0], birthDate[1]);
    }
    public Person(String name, String cellNumber, int[] birthDate){
        this(name.split(" "), cellNumber, birthDate[0], birthDate[1]);
    }
    public Person(String name){
        this(name.split(" "), null, 0, 0);
    }
    public Person(){this.Name = new String[]{null, null};}
    //Constructors

    public void PrintPerson(){
        System.out.println("First Name: " + getFirstName() + "\nLast Name: " + getLastName());
        System.out.println("Full Name: " + getName());
        System.out.println("Cell Number: " + getCellNumber());
        System.out.println("Birth Month: " + getBirthMonth());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println();
    }

    private static String formatCellPhone(String Number, String cellFormat){
        if (Number == null) return null;
        String newNumber = "";
        Number = Number.replace("-", "").replace(" ", "");  // to make sure to get rid of separation either "-" or " "
        int numberPosition = 0;
        for (int i = 0; i < Number.length(); i++) {
            if (!Character.isDigit(Number.charAt(i))){
                Number = Number.replace(Character.toString(Number.charAt(i)), "");
                i--;
            }
        }
        try {
            for (int i = 0; i < cellFormat.length(); i++) {
                if (Character.isDigit(cellFormat.charAt(i))) {
                    if (cellFormat.charAt(i) == Number.charAt(numberPosition)) {
                        newNumber += Number.charAt(numberPosition);
                        numberPosition++;
                    } else {
                        newNumber += cellFormat.charAt(i);
                    }
                } else if (cellFormat.charAt(i) == 'X' && Character.isDigit(Number.charAt(numberPosition))) {
                    newNumber += Number.charAt(numberPosition);
                    numberPosition++;
                } else {
                    newNumber += cellFormat.charAt(i);
                }
            }
        }
        catch (Exception StringIndexOutOfBoundsException){
            System.out.println("Bad Phone Number Entered: " + Number + "\nNeeded Format: " + cellFormat);
            System.exit(0);
        }
        if (numberPosition != Number.length()){
            System.out.println("The Phone Number inputted did not match up with the format");
            newNumber = null;
        }
        return newNumber;
    }

    //Setters
    public void setFirstName(String firstName){Name[0] = firstName;}
    public void setLastName(String lastName){Name[0] = lastName;}
    public void setName(String name){Name = name.split(" ");}
    public void setName(String firstName, String lastName){Name = new String[]{firstName, lastName};}
    public void setCellFormat(String newFormat){ CellFormat = newFormat; }
    public void setCellFormat(String newFormat, String newNumber){ CellFormat = newFormat; setCellNumber(newNumber);}
    public void setCellNumber(String Number){ CellNumber = formatCellPhone(Number, CellFormat); }
    public void setBirthMonth(int Month){BirthDate[0] = Month;}
    public void setBirthDay(int Day){BirthDate[1] = Day;}
    //Setters

    //Getters
    public String getFirstName(){return  Name[0];}
    public String getLastName(){return Name[1];}
    public String getName(){return getFirstName() + " " + getLastName();}
    public String getCellFormat(){return CellFormat;}
    public String getCellNumber(){return CellNumber;}
    public String getCellNumberJustNumbers(){
        String Number = CellNumber;
        for (int i = 0; i < Number.length(); i++) {
            if (!Character.isDigit(Number.charAt(i))){
                Number = Number.replace(Character.toString(Number.charAt(i)), "");
                i--;
            }
        }
        return Number;
    }
    public int getBirthMonth(){return BirthDate[0];}
    public int getBirthDay(){return BirthDate[1];}
    //Getters
}

