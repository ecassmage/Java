import java.util.*;


public class Polynomial implements Map<Integer, Integer>, Comparable<Polynomial> {
    private HashMap<Integer, Integer> list;
    public ArrayList<int[]> listSorted; // Technically This Should be Sorted Greatest to Smallest.
    private int degreeHolder = 0;

    public static void main(String[] args){
        Polynomial P = new Polynomial();
    }

    public Polynomial(){
        // I assume this is Meant to give length of 0 since it has nothing and a power of -1 is not an accepted power since the rules state no negative power is allowed.
        // Honestly I am not sure about this. I was told to put the power to -1 but it also says I can't allow negative powers through so I am conflicted
        this.list = new HashMap<>();
        this.listSorted = new ArrayList<>();

        this.listSorted.add(new int[]{-1, 0});
        list.put(-1, 0);
    }

    public Polynomial(int coefficient, int power){
        this.list = new HashMap<>();
        this.listSorted = new ArrayList<>();
        try{
            if (power < 0) {
                throw new IllegalArgumentException();
            }
            list.put(power, coefficient);
            this.listSorted.add(new int[]{power, coefficient});
            setDegree(power);
        }
        catch (IllegalArgumentException e){
            System.out.println("java.lang.IllegalArgumentException: Power of a term can't be negative.");
        }
    }

    public void add(Polynomial P){
        try{
            for(Entry<Integer, Integer> E: P.getMap().entrySet()){  // Uses entries to parse through the Hashmap.
                if (E.getKey() < 0){
                    throw new IllegalArgumentException();
                }
                if (list.containsKey(E.getKey())){
                    int[] temp = newPoly(E, list.get(E.getKey()));
                    if (temp == null) {
                        if (E.getKey() == degreeHolder) setDegree();
                        list.remove(E.getKey());
                        listSorted.remove(getList(E.getKey()));
                    }
                    else {
                        list.put(temp[0], temp[1]);
                        listSorted.add(new int[]{temp[0], temp[1]});
                    }
                }
                else {
                    list.put(E.getKey(), E.getValue());
                    listSorted.add(new int[]{E.getKey(), E.getValue()});
                }
                setDegree(E.getKey());
            }
            sort();
        }
        catch (IllegalArgumentException e){
            System.out.println("java.lang.IllegalArgumentException: Power of a term can't be negative.");
        }
    }

    private int[] getList(int key){
        for (int[] nums: listSorted){
            if (nums[0] == key) return nums;
        }
        return null;
    }

    private void sort(){
        for (int i = 0; i < listSorted.size()-1; i++){
            for (int j = 0; j < listSorted.size() - i - 1; j++){
                if (listSorted.get(j+1)[0] > listSorted.get(j)[0]){
                    int[] temp = listSorted.get(j);
                    listSorted.set(j, listSorted.get(j+1));
                    listSorted.set(j+1, temp);
                }
            }
        }
    }

    /*
    Subtract Uses add mainly to do its work. Add is build to handle subtractions job at the same time since add needs to be able to do it as well.
     */
    public void subtract(Polynomial P){
        for(Entry<Integer, Integer> E: P.getMap().entrySet())   add(new Polynomial(E.getValue() * -1, E.getKey()));  // The 0 will catch and
    }

    /*
    I am just glad division wasn't needed.
     */
    public Polynomial multiply(Polynomial P){
        Polynomial P2 = new Polynomial();
        for (Entry<Integer, Integer> E: list.entrySet()){
            for (Entry<Integer, Integer> E2: P.getMap().entrySet())
                P2.add(new Polynomial(E.getValue() * E2.getValue(), E.getKey() + E2.getKey()));
        }
        return P2;
    }

    public int getDegree(){
        return degreeHolder;
    }

    public int coefficient(int power){
        return list.get(power);
    }

    public double evaluate(double eval){
        double valReturn = 0;
        for (Entry<Integer, Integer> E: list.entrySet()){
            valReturn += E.getValue() * (Math.pow(eval, E.getKey()));
        }
        return valReturn;
    }

    public boolean equals(Object o){
        if (!(o instanceof Polynomial)) return false;
        for (Entry<Integer, Integer> E: ((Polynomial) o).entrySet()){
            if (!list.containsKey(E.getKey()) || (int) list.get(E.getKey()) != (int) E.getValue()) return false;
        }
        return true;
    }

    private String line(int[] number, boolean first){
        String str = "";
        if (!first){
            str = str.concat(" ");

        }
        if (number[1] < 0){
            str = str.concat("-");
            if (!first) str = str.concat(" ");
            str = str.concat(Integer.toString(number[1] * -1));
        }
        else if (number[1] == 0) return "";
        else {
            if (!first) str = str.concat("+ ");
            str = str.concat(Integer.toString(number[1]));
        }

        if (number[0] == 1) str = str.concat("x");
        else if (number[0] > 1) str = str.concat("x" + number[0]);
        return str;
    }

    public String toString(){
        String str = "";
        for (int i = degreeHolder; 0 <= i; i--){
            if (list.containsKey(i)){
                str = str.concat(line(new int[]{i, list.get(i)}, i == degreeHolder));
            }
        }
        return str;
    }

    /*
     * The setDegree stuff is called everytime there might be an upset to the highest power. for instand when a new power is added, this compares if it is a larger power then the current largest
     * and if the largest power was just removed then, this will check what the next largest power would have been. Since this is a hashmap things can't be sorted so it needs to be checked the usual way.
     */
    private void setDegree(int num){ if (num > degreeHolder) degreeHolder = num; }
    private void setDegree(){
        int temp = 0;
        for (Entry<Integer, Integer> E: list.entrySet()){
            if (E.getKey() > temp) temp = E.getKey();
        }
        this.degreeHolder = temp; //Meh
    }

    public HashMap<Integer, Integer> getMap(){
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return list.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return list.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return list.get(key);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return list.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return list.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        list.putAll(m);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return list.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return list.values();
    }

    @Override
    public Set<Entry<Integer, Integer>> entrySet() {
        return list.entrySet();
    }


    private int[] newPoly(Entry<Integer, Integer> E, int val){
        if (E.getValue() + val == 0) return null;
        return new int[]{E.getKey(), val + E.getValue()};
    }

    @Override
    public int compareTo(Polynomial o) {
        double num1 = evaluate(0);
        double num2 = o.evaluate(0);
        if (num1 > num2){
            return 1;
        }
        else if (num1 < num2){
            return -1;
        }
        return 0;
    }
}
