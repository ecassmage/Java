import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;

//String[] paths = {"dblp100", "dblp200", "dblp400", "dblp800", "dblp1600", "dblp3200", "dblp6400", "dblp10k", "dblp100k", "dblp1m", "dblp3m"};
public class Tester {
    public static void main(String[] args) throws Exception{
        //Test();
        badLinked();
    }

    public static void badLinked() throws Exception{
        String[] paths = {"dblp100", "dblp200", "dblp400", "dblp800", "dblp1600", "dblp3200", "dblp6400", "dblp10k", "dblp100k", "dblp1m"};
        int averageLoops = 125;
        long timeAverage;
        int num = 0;
        int max = paths.length;
        for (String path: paths){
            timeAverage = 0;
            String[] tokens = WordCountLinkedList254.readText("Folder/" + path + ".txt");

            for (int i = 0; i < 100000; i++){
            }

            for (int j = 0; j < averageLoops; j++){
                long startTime = System.currentTimeMillis();
                Map.Entry<String, Integer> entry = WordCountLinkedList254.countFAST_FINAL(tokens);
                long endTime = System.currentTimeMillis();
                String time = String.format("%12d", endTime - startTime);

                timeAverage += (endTime - startTime);
                if (num > max) {
                    break;
                }
            }
            if (num > max)
                System.out.println("Path: " + path + ".txt\t Average Time Over " + 1 + " loops: " + (timeAverage) + "\n");
            else
                System.out.println("Path: " + path + ".txt\t Average Time Over " + averageLoops + " loops: " + (timeAverage / averageLoops) + "\n");


            num++;
        }
    }
    
    public static void Test() throws Exception{
        String path = "dblp1m";
        String[] tokens = WordCountLinkedList254.readText("Folder/" + path + ".txt");
        System.out.println("Total Tokens = " + tokens.length);
        long timeAverage;
        int averageLoops = 100;
        int top = 1000;
        LinkedList<Double[]> best = new LinkedList<>();
        for (double i = 1.1; i <= 2.5; i += 0.05){
            timeAverage = 0;
            for (int j = 0; j < averageLoops; j++){
                long startTime = System.currentTimeMillis();
                Map.Entry<String, Integer> entry = WordCountLinkedList254.countFAST2(tokens, i);
                long endTime = System.currentTimeMillis();
                String time = String.format("%12d", endTime - startTime);
                System.out.println("\tLoad Factor [" + (((double) Math.round(i*100)) / 100) + "]\t[" + ((int) Math.ceil(tokens.length * i)) + "] \tcount_sort   -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());
                timeAverage += (endTime - startTime);
            }
            System.out.println("Load Factor: [" + (((double) Math.round(i*100)) / 100) + "]\t Capacity: [" + ((int) Math.ceil(tokens.length * i)) + "]\t Average Time Over " + averageLoops + " loops: " + (timeAverage / averageLoops) + "\n");
            forelseLoop:{
                for (int n = 0; n < best.size(); n++){
                    Double[] temp = best.get(n);
                    if ((double)((double) timeAverage / averageLoops) < temp[1] || temp[1] == 0){
                        best.add(n, new Double[]{((double) Math.round(i*100)) / 100, ((double) Math.round(((double) timeAverage / averageLoops)*100)) / 100});
                        break forelseLoop;
                    }
                }
                best.addLast(new Double[]{((double) Math.round(i*100)) / 100, ((double) Math.round(((double) timeAverage / averageLoops)*100)) / 100});
            }
        }
        System.out.println("\n");
        int length = Math.min(best.size(), top);
        for (int i = 0; i < length; i++){
            Double[] temp = best.get(i);
            System.out.println("Number " + (i + 1) + ":\t Load Factor: [" + temp[0] + "]\t Capacity: [" + (int) Math.ceil(tokens.length * temp[0]) + "]\t Average Time Over " + averageLoops + " loops: " + temp[1]);
        }
    }
}
