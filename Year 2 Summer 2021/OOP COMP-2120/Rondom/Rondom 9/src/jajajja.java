public class jajajja implements I{
    public static void main(String[] args){
        I i = new jajajja();
        System.out.println(i.getMeasure());
        System.out.println(i.num());
    }

    public double getMeasure(){
        return 100;
    }

    public int num(){
        return 10;
    }
}
