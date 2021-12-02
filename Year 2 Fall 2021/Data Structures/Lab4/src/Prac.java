public class Prac {

    public static void main(String[] args){
        int i = 0;
        int elements = 0;
        int sizeOfArray = 2;
        int iterations = 0;
        for (; elements <= 500; ++elements){
            if (elements == sizeOfArray) {
                iterations += elements;
                sizeOfArray += 2;
                i++;
            }
        }
        System.out.println(i + " " + sizeOfArray + " " + iterations + " " + elements);
    }
}
