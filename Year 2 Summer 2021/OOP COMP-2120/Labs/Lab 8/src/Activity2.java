import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Collections;


public class Activity2 {

    public static void main(String[] args){
        Activity2 A = args.length == 0 ? new Activity2("input1.txt", "input2.txt", "input3.txt") : new Activity2(args);  // This way we will always get what we want.
        ArrayList<?> a = A.ReadSortStore(A.ReadLines());
        ArrayList<?> b = A.ReadSortStore(A.ReadLines());
        ArrayList<?> c = A.ReadSortStore(A.ReadLines());
        A.setptr();
        ArrayList<?> d = A.ReadSortStore(A.ReadLines(), false);
        ArrayList<?> e = A.ReadSortStore(A.ReadLines(), false);
        ArrayList<?> f = A.ReadSortStore(A.ReadLines(), false);

        System.out.println("Ascending: \n" + a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("Descending: \n" + d);
        System.out.println(e);
        System.out.println(f);
    }
    private final String[] inputs;
    private int ptr;

    public Activity2(String ...args){
        this.inputs = args;
        this.ptr = 0;
    }

    public void readAll(boolean ascending){
        System.out.println(ascending ? "Ascending:": "Descending:");
        while (ptr < inputs.length) System.out.println(ReadSortStore(ReadLines()));
        System.out.println();
    }

    public FileReader OpenReadFile(String arg){ return (FileReader) openFile(arg, false); }
    public FileWriter OpenWriteFile(String arg){ return (FileWriter) openFile(arg, true); }
    public Object openFile(String arg, boolean openWriteFile) {
        try{
            return openWriteFile ? new FileWriter(arg): new FileReader(arg);
        }// I don't like to use throw
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e.toString());
            System.exit(0);
        }
        return null;
    }

    // This Reads the Lines and adds them to an array, Like Python
    public ArrayList<String> ReadLines(){return ReadLines(OpenReadFile(inputs[ptr++]));}
    public ArrayList<String> ReadLines(String arg){return ReadLines(OpenReadFile(arg));}
    public ArrayList<String> ReadLines(FileReader FR){
        Scanner S = new Scanner(FR);
        ArrayList<String> str = new ArrayList<>();
        while (true){
            try{ str.add(S.nextLine()); } catch (NoSuchElementException e){break;}
        }
        return str;
    }

    private String[] StringSort(){
        return null;
    }

    private ArrayList<Integer> IntegerMk(ArrayList<String> arr){
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); intArr.add(Integer.parseInt(arr.get(i))), i++);
        return intArr;
    }
    private ArrayList<Double> DoubleMk(ArrayList<String> arr){
        ArrayList<Double> DoubleArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); DoubleArr.add(Double.parseDouble(arr.get(i))), i++);
        return DoubleArr;
    }/*
    private ArrayList<String> StringMk(ArrayList<String> arr){
        ArrayList<Double> DoubleArr = new ArrayList<>();
        for (int i = 1; i < arr.size(); DoubleArr.add(Double.parseDouble(arr.get(0))), i++);
        return DoubleArr;
    }*/
    public <E> ArrayList<E> sort(ArrayList<E> list){ return sort(list, true); }
    public <E> ArrayList<E> sort(ArrayList<E> list, boolean ascending){
        if (ascending) list.sort(null);
        else {
            list.sort(null);
            Collections.reverse(list);
        }
        return list;
    }
    public <E> ArrayList<?> ReadSortStore(ArrayList<String> arrayStr) { return ReadSortStore(arrayStr, true); }
    public <E> ArrayList<?> ReadSortStore(ArrayList<String> arrayStr, boolean ascending){
        if (arrayStr.size() == 0 ) return null;
        switch (arrayStr.remove(0)){
            case "String":    /*ArrayList<String> arrayStr = StringMk(arrayStr);*/  return sort(arrayStr, ascending);
            case "Integer":     ArrayList<Integer> arrayInt = IntegerMk(arrayStr);  return sort(arrayInt, ascending);
            case "Double":      ArrayList<Double> arrayDouble = DoubleMk(arrayStr); return sort(arrayDouble, ascending);
            default:                                                                return null;
        }
    }

    public void setptr(){setptr(0);}
    public void setptr(int num){ptr = 0;}
}
