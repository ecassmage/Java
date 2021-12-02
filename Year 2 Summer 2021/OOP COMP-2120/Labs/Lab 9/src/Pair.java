public class Pair<O/*ne*/, T/*wo*/> {
    private O ObjectOne;
    private T ObjectTwo;
    public static void main(String[] args){
        Pair<String, Integer> SI = new Pair<>("String Here", 100);
        Pair<Boolean, Double> BD = new Pair<>(true, 123.0);
        Pair<String, Double> SD = new Pair<>("String Here", 110.0);
    }

    public Pair(O ObjectOne, T ObjectTwo){
        setObjectOne(ObjectOne);
        setObjectTwo(ObjectTwo);
    }

    public O getObjectOne(){
        return ObjectOne;
    }
    public T getObjectTwo(){
        return ObjectTwo;
    }
    public void setObjectOne(O ObjectOne){
        this.ObjectOne = ObjectOne;
    }
    public void setObjectTwo(T ObjectTwo){
        this.ObjectTwo = ObjectTwo;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Pair && ((Pair<?, ?>) obj).getObjectOne().getClass() == this.getObjectOne().getClass() && ((Pair<?, ?>) obj).getObjectTwo().getClass() == this.getObjectTwo().getClass()){
            return ObjectOne == ((Pair<?, ?>) obj).getObjectOne() && ObjectTwo == ((Pair<?, ?>) obj).getObjectTwo();
        }
        return false;
        // I can't think of a way to determine if a different Object to this Pair could be measured since I don't know if it even has any instance variables
    }

    public String toString(){
        return "<" + ObjectOne.toString() + ", " + ObjectTwo.toString() + ">";
    }
}
