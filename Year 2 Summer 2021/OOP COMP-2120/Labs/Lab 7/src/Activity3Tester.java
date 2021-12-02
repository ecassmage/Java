public class Activity3Tester {
    public static void main(String[] args){
        Fruit O = new Orange();
        Fruit A = new Apple();
        Fruit B = new Banana();
        Animal C = new Chicken();
        Animal M = new Meat();
        Animal F = new Fish();

        System.out.println(O.howToEat());
        System.out.println(A.howToEat());
        System.out.println(B.howToEat());
        System.out.println(C.howToEat());
        System.out.println(M.howToEat());
        System.out.println(F.howToEat());
    }
}
