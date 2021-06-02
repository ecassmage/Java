public class Activity1 {
    private String str;
    private String str2;
    private String firstName;
    private String lastName;
    public static void main(String[] args){
        Activity1 act = new Activity1();
        System.out.println(act.getName());
        System.out.println(act.getName().length());
        act.splitName();
        System.out.println(act.getFirstName() + "\n" + act.getLastName());
        act.makeCoolerName();
        System.out.println(act.getStr2());
        System.out.println(act.findFirstOccurrenceOfLastCharacterOfLastNameInFirstName());
        System.out.println(act.findLastOccurrenceOfFirstCharacterOfLastNameInFirstName());
        act.CapitaliseName();
        System.out.println(act.getFirstName() + " " + act.getLastName());

    }
    public Activity1(){
        str = "evan morrison";
    }
    public Activity1(String name){
        str = name;
    }
    public void splitName(){
        String[] tempStr = str.split(" ");
        firstName = tempStr[0];
        lastName = tempStr[1];
    }
    public void makeCoolerName(){
        str2 = getLastName() + ", " + getFirstName();
    }
    public int findFirstOccurrenceOfLastCharacterOfLastNameInFirstName(){
        char character = lastName.charAt(lastName.length() - 1);
        for (int i = 0; i < firstName.length(); i++){
            if (firstName.charAt(i) == character){
                return i;
            }
        }
        return -1; // returns -1 if not found
    }
    public int findLastOccurrenceOfFirstCharacterOfLastNameInFirstName(){
        char character = lastName.charAt(0);
        for (int i = firstName.length() - 1; i >= 0; i--){
            if (firstName.charAt(i) == character){
                return i;
            }
        }
        return -1; // returns -1 if not found
    }
    public String getName(){return str;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getStr2(){return str2;}

    public void CapitaliseName(){
        firstName = CapitalizeWord(firstName);
        lastName = CapitalizeWord(lastName);
    }
    public String CapitalizeWord(String word){
        String tempReturn = Character.toString(word.charAt(0)).toUpperCase();
        for(int i = 1; i < word.length(); i++){
            tempReturn += Character.toString(word.charAt(i));
        }
        return tempReturn;
    }

}
