public class Activity2Tester {
    public static void main(String[] args){
        Triangle T = new Triangle(10, 10);
        Triangle T2 = new Triangle(10, 10);
        Oval O = new Oval(10, 10);
        System.out.println("This is Number: " + T.compareTo(O));  // Umm I think either I am misunderstanding the question or the prof accidentally gave the answer to this one but Comparable was already implemented in Shapes
        System.out.println("This is Number: " + T.compareTo(T2));
        System.out.println("This is Number: " + O.compareTo(T));
    }
}
