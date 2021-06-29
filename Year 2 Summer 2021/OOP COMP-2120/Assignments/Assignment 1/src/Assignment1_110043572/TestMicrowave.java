public class TestMicrowave {
    public static void print(int num){
        System.out.println("Time Currently is: " + num);
    }
    public static void print(String word){
        System.out.println("Power Level Currently is: " + word);
    }
    public static void print(boolean bool){
        if (bool) System.out.println("Microwave Currently is: ON");
        else System.out.println("Microwave Currently is: OFF");
    }
    public static void print(){
        System.out.println();
    }
    public static void main(String[] args){
        Microwave microwaveTestingNamesAreLong = new Microwave();
        System.out.println("You got yourself a really really good new toaster!!!");

        print();

        print(microwaveTestingNamesAreLong.getTime());
        print(microwaveTestingNamesAreLong.getOn());
        print(microwaveTestingNamesAreLong.getPower());

        print();

        microwaveTestingNamesAreLong.button1();
        print(microwaveTestingNamesAreLong.getTime());
        microwaveTestingNamesAreLong.button1();
        print(microwaveTestingNamesAreLong.getTime());
        microwaveTestingNamesAreLong.button1();
        print(microwaveTestingNamesAreLong.getTime());
        microwaveTestingNamesAreLong.button1();
        print(microwaveTestingNamesAreLong.getTime());

        print();

        microwaveTestingNamesAreLong.button2();
        print(microwaveTestingNamesAreLong.getPower());
        microwaveTestingNamesAreLong.button2();
        print(microwaveTestingNamesAreLong.getPower());
        microwaveTestingNamesAreLong.button2();
        print(microwaveTestingNamesAreLong.getPower());
        microwaveTestingNamesAreLong.button2();
        print(microwaveTestingNamesAreLong.getPower());

        print();

        microwaveTestingNamesAreLong.button3();
        print(microwaveTestingNamesAreLong.getOn());
        microwaveTestingNamesAreLong.button5();
        print(microwaveTestingNamesAreLong.getOn());
        microwaveTestingNamesAreLong.button3();
        print(microwaveTestingNamesAreLong.getOn());

        print();

        microwaveTestingNamesAreLong.button4();
        print(microwaveTestingNamesAreLong.getTime());
        print(microwaveTestingNamesAreLong.getOn());
        print(microwaveTestingNamesAreLong.getPower());

        print();

    }
}
